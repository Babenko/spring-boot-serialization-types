package com.demo.serialization.ranking.config;

import com.demo.serialization.common.serializator.DateSerializer;
import com.demo.serialization.common.serializator.InstantSerializer;
import com.demo.serialization.common.serializator.UUIDSerializer;
import com.demo.serialization.common.serializator.http.KryoListSerializer;
import com.demo.serialization.common.serializator.http.KryoSerializer;
import com.esotericsoftware.kryo.Kryo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(KryoListSerializer kryoListSerializer, KryoSerializer kryoSerializer) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().addAll(Arrays.asList(kryoListSerializer, kryoListSerializer));
        return restTemplate;
    }

    @Bean
    public Kryo kryo() {
        Kryo kryo = new Kryo();
        kryo.register(UUID.class, new UUIDSerializer());
        kryo.register(Date.class, new DateSerializer());
        kryo.register(Instant.class, new InstantSerializer());
        return kryo;
    }

    @Bean
    public KryoListSerializer kryoListSerializer(Kryo kryo) {
        return new KryoListSerializer(kryo);
    }

    @Bean
    public KryoSerializer kryoSerializer(Kryo kryo) {
        return new KryoSerializer(kryo);
    }

}
