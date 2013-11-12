/*
 * Project: MinerMonitor
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Nov 12, 2013
 *
 * Version: $Revision: $
 *
 * Last revision date: $Date: $
 * Last revision by: $Author: $
 *
 * $Log: $
 */
package org.obozek.minermonitor;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Date;

/**
 *
 * @author Ondrej.Bozek
 */
public class LinuxTimeAdapter implements JsonDeserializer<Date>, JsonSerializer<Date>
{

    private static final int MILISECONDS_IN_SECOND = 1000;

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        return new Date(json.getAsJsonPrimitive().getAsLong() * MILISECONDS_IN_SECOND);
    }

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.getTime() / MILISECONDS_IN_SECOND);
    }
}
