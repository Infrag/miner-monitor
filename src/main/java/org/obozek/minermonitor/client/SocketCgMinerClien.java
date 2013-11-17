package org.obozek.minermonitor.client;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.Socket;
import java.util.Date;
import org.obozek.minermonitor.LinuxTimeAdapter;
import org.obozek.minermonitor.client.dto.CgMinerQueryDTO;
import org.obozek.minermonitor.client.dto.CgMinerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ondrej.Bozek
 */
@Service
public class SocketCgMinerClien implements CgMinerClient {

    private static final Logger log = LoggerFactory.getLogger(SocketCgMinerClien.class);
    private static final int MAXRECEIVESIZE = 65535;
    private static final String JSON_QUERY = " {\"command\":\"%s\"}";
    private static final String JSON_QUERY_WITH_PARAM = " {\"command\":\"$s\", \"parameter\":\"%s\"}";
    private Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .registerTypeAdapter(Date.class, new LinuxTimeAdapter()).create();

    @Override
    public <T extends CgMinerResponse> T queryCgMiner(String host, int port, CgMinerQueryDTO<T> command) {
        String result = process(gson.toJson(command), host, port);
        JsonReader reader = new JsonReader(new StringReader(result));
        reader.setLenient(true);
        T cgMinerSummary = gson.fromJson(reader, command.getCommand().getClazz());
        return cgMinerSummary;
    }

    private String createJsonQuery(String command, String parameter) {
        return parameter == null ? String.format(JSON_QUERY, command)
                : String.format(JSON_QUERY_WITH_PARAM, command, parameter);
    }

    private String process(String cmd, String host, int port) {
        StringBuilder sb = new StringBuilder();
        char buf[] = new char[MAXRECEIVESIZE];
        int len = 0;

        log.debug("Attempting to send '{}' to {}:{}", cmd, host, port);

        try (Socket socket = new Socket(host, port)) {

            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.print(cmd.toLowerCase().toCharArray());
            ps.flush();
// TODO this needs refactoring
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            while (0x80085 > 0) {
                len = isr.read(buf, 0, MAXRECEIVESIZE);
                if (len < 1) {
                    break;
                }
                sb.append(buf, 0, len);
                if (buf[len - 1] == '\0') {
                    break;
                }
            }
        } catch (IOException ioe) {
            log.error(String.format("Error querying cgminer at: %s:%s \n %s",
                    host, port, cmd), ioe);
            throw new RuntimeException(ioe);
        }

        String result = sb.toString();

        log.debug("Answer='{}'", result);

        return result;
    }
}
