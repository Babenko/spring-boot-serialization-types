package com.demo.serialization.common.serializator;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.time.Instant;

public class InstantSerializer extends Serializer<Instant> {
    @Override
    public void write(Kryo kryo, Output output, Instant instant) {
        output.writeLong(instant.getEpochSecond(), true);
    }

    @Override
    public Instant read(Kryo kryo, Input input, Class<Instant> aClass) {
        return Instant.ofEpochSecond(input.readLong(true));
    }
}
