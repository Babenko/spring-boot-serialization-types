package com.demo.serialization.common.serializator;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.util.Date;

public class DateSerializer extends Serializer<Date> {
    @Override
    public void write(Kryo kryo, Output output, Date date) {
        output.writeLong(date.getTime(), true);
    }

    @Override
    public Date read(Kryo kryo, Input input, Class<Date> aClass) {
        return new Date(input.readLong(true));
    }
}
