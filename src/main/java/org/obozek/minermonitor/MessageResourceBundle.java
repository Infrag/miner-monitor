package org.obozek.minermonitor;

import java.util.Collections;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

/**
 * Resource bundle implementation which serves as the resource getter for the
 * application messages. It delegates calling to the application registered
 * {@link MessageSource} with id
 * <pre>com.asseco.agportal.application.messages</pre>.
 *
 */
public class MessageResourceBundle extends ResourceBundle
{

    private Messages messages;

    /**
     * Default constructor.
     */
    public MessageResourceBundle()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        WebApplicationContext context = FacesContextUtils.getWebApplicationContext(facesContext);
        this.messages = context.getBean(Messages.class);
    }

    @Override
    protected Object handleGetObject(String key)
    {
        try {
            return messages.getMessage(key);
        } catch (NoSuchMessageException e) {
            return null;
        }
    }

    @Override
    public Enumeration<String> getKeys()
    {
        return Collections.enumeration(Collections.EMPTY_LIST);
    }
}
