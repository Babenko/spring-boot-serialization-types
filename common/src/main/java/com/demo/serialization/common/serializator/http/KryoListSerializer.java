package com.demo.serialization.common.serializator.http;

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
import java.util.ArrayList;
import java.util.List;

public class KryoListSerializer extends AbstractHttpMessageConverter<ArrayList> {

    private Kryo kryo;

    public KryoListSerializer(Kryo kryo) {
        super(MediaType.APPLICATION_OCTET_STREAM);
        this.kryo = kryo;
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return ArrayList.class.isAssignableFrom(aClass);
    }

    @Override
    protected ArrayList readInternal(Class<? extends ArrayList> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        try (Input input = new Input(httpInputMessage.getBody())) {
            return kryo.readObject(input, ArrayList.class);
        }
    }

    @Override
    protected void writeInternal(ArrayList movies, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        try(Output output = new Output(httpOutputMessage.getBody())) {
            kryo.writeObject(output, movies);
        }
    }
}