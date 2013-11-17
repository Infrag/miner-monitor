package org.obozek.minermonitor.view;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import org.obozek.minermonitor.service.CgMinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Ondrej.Bozek
 */
@URLMapping(id = "auth:test", viewId = "/view/auth/index.xhtml", pattern = "/auth/test")
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class BackingBean implements Serializable
{

    @Autowired
    private CgMinerService cgMinerService;
    private String summary = "pomm";
    private String url = "";
    private Integer port = 4028;

    public String refreshSummary()
    {
        try {
//            summary = cgMinerService.getSummary(url, port);
        } catch (Exception ex) {
            throwMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "success";
    }

    public String queryConfig()
    {
        try {
//            summary = cgMinerService.getConfig(url, port);
        } catch (Exception ex) {
            throwMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "success";
    }

    public String queryDeviceDetails()
    {
        try {
//            summary = cgMinerService.getDeviceDetails(url, port);
        } catch (Exception ex) {
            throwMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "success";
    }

    public String queryNotify()
    {
        try {
//            summary = cgMinerService.getNotify(url, port);
        } catch (Exception ex) {
            throwMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "success";
    }

    public String queryDevices()
    {
        try {
//            summary = cgMinerService.getDevices(url, port);
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

    public Integer getPort()
    {
        return port;
    }

    public void setPort(Integer port)
    {
        this.port = port;
    }
}
