package com.demo.serialization.common.serializator.http;

import com.demo.serialization.common.model.Movies;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

public class KryoSerializer extends AbstractHttpMessageConverter<Movies> {

    private Kryo kryo;

    public KryoSerializer(Kryo kryo) {
        super(MediaType.APPLICATION_OCTET_STREAM);
        this.kryo = kryo;
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return Movies.class.isAssignableFrom(aClass);
    }

    @Override
    protected Movies readInternal(Class<? extends Movies> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        try (Input input = new Input(httpInputMessage.getBody())) {
            return kryo.readObject(input, Movies.class);
        }
    }

    @Override
    protected void writeInternal(Movies movies, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        try (Output output = new Output(httpOutputMessage.getBody())) {
            kryo.writeObject(output, movies);
        }
    }
}
