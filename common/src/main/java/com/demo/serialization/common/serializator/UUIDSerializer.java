package com.demo.serialization.common.serializator;


import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.util.UUID;

public class UUIDSerializer extends Serializer<UUID> {

    @Override
    public void write(Kryo kryo, Output output, UUID uuid) {
        output.writeLong(uuid.getLeastSignificantBits(), true);
        output.writeLong(uuid.getMostSignificantBits(), true);
    }

    @Override
    public UUID read(Kryo kryo, Input input, Class<UUID> aClass) {
        long least = input.readLong(true);
        long most = input.readLong(true);
        return new UUID(most, least);
    }
}
