package org.obozek.minermonitor.view;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import org.obozek.minermonitor.client.CgMinerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Ondrej.Bozek
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class BackingBean implements Serializable
{

    @Autowired
    private CgMinerClient cgMinerClient;
    private String summary = "pomm";
    private String url = "";

    public String refreshSummary()
    {
        try {
            summary = cgMinerClient.getQuery(url, "summary");
        } catch (Exception ex) {
            throwMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "success";
    }

    private static void throwMessage(String msg, Severity severity)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, msg, msg));
    }

    public String getSummary()
    {
        return summary;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
