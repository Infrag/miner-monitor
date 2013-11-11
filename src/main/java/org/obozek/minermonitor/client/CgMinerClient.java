package org.obozek.minermonitor.client;

import com.google.gson.Gson;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.Response;
import java.util.concurrent.Future;
import org.obozek.minermonitor.CgMinerApi;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ondrej.Bozek
 */
@Service
public class CgMinerClient
{

    private Gson gson = new Gson();
    private static final String SUMMARY_COMMAND = "summary";

    public String getSummary(String url)
    {
        return getQuery(url, SUMMARY_COMMAND);
    }

    public String getQuery(String url, String command)
    {
        try {
            AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
            asyncHttpClient.
            Future<Response> f = asyncHttpClient.prepareRequest(new RequestBuilder("POST")
                    .setUrl(url)
                    .setHeader("content-type", "application/json")
                    .setBody("{\"command\":\"" + command + "\"}")
                    .build()).execute();
            Response r = f.get(); //http://115.143.broadband12.iol.cz:4028
            String result = r.getResponseBody();
//            String result = CgMinerApi.process("{\"command\": \"summary\"}", "90.179.143.115", "4028");
            return result;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
