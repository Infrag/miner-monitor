package org.obozek.minermonitor;

import java.util.Locale;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 * Convenient accessor class which allows to access the application's messages
 * programatically. Use this instead of the obsolete
 * {@link com.berit.faces.commons.bundle.BundleUtils} to directly access the
 * {@link MessageSource} configured within the application.
 *
 */
@Service
public final class Messages
{

    @Autowired
    private FacesContext facesContext;
    @Autowired
    private MessageSource messageSource;

    /**
     * Returns the default locale.
     *
     * @return Faces associated locale
     */
    private Locale getDefaultLocale()
    {
        return facesContext.getApplication().getDefaultLocale();
    }

    /**
     * Retrieve the message for the given code and the default Locale.
     *
     * @param code code of the message
     * @param args arguments for the message
     * @return the message
     * @throws org.springframework.context.NoSuchMessageException if no message
     * found
     *
     * @see #getDefaultLocale
     * @see #getMessage(Locale, String, Object...)
     */
    public String getMessage(String code, Object... args)
    {
        return getMessage(getDefaultLocale(), code, args);
    }

    /**
     * Retrieve the message for the given code and the given Locale.
     *
     * @param locale Locale in which to do lookup
     * @param code code of the message
     * @param args arguments for the message
     * @return the message
     * @throws org.springframework.context.NoSuchMessageException if no message
     * found
     *
     * @see MessageSource#getMessage(String, Object[], Locale)
     */
    public String getMessage(Locale locale, String code, Object... args)
    {
        return messageSource.getMessage(code, args, locale);
    }

    /**
     * Retrieve the message for the given code and the default Locale. If no
     * message for the given code found, return the defaultMessage.
     *
     * @param code code of the message
     * @param defaultMessage the default message
     * @param args arguments for the message
     * @return the message
     *
     * @see #getDefaultLocale
     * @see #getMessage(Locale, String, String, Object...)
     */
    public String getMessageOrDefault(String code, String defaultMessage, Object... args)
    {
        return getMessage(getDefaultLocale(), code, defaultMessage, args);
    }

    /**
     * Retrieve the message for the given code and the given Locale. If no
     * message for the given code found, return the defaultMessage.
     *
     * @param locale Locale in which to do lookup
     * @param code code of the message
     * @param defaultMessage the default message
     * @param args arguments for the message
     * @return the message
     *
     * @see MessageSource#getMessage(String, Object[], String, Locale)
     */
    public String getMessageOrDefault(Locale locale, String code, String defaultMessage, Object... args)
    {
        return messageSource.getMessage(code, args, defaultMessage, locale);
    }
}
