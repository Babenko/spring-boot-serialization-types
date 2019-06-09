package com.demo.serialization.movie.config;

import com.demo.serialization.common.serializator.DateSerializer;
import com.demo.serialization.common.serializator.InstantSerializer;
import com.demo.serialization.common.serializator.UUIDSerializer;
import com.demo.serialization.common.serializator.http.KryoListSerializer;
import com.demo.serialization.common.serializator.http.KryoSerializer;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Configuration
public class AppConfig {

    @Bean
    public Kryo kryo() {
        Kryo kryo = new Kryo();
        kryo.register(UUID.class, new UUIDSerializer());
        kryo.register(Date.class, new DateSerializer());
        kryo.register(Instant.class, new InstantSerializer());
        return kryo;
    }

    @Bean
    public KryoSerializer kryoSerializer(Kryo kryo) {
        return new KryoSerializer(kryo);
    }

    @Bean
    public AbstractHttpMessageConverter<ArrayList> kryoSerializers(Kryo kryo) {
        return new KryoListSerializer(kryo);
    }
}
