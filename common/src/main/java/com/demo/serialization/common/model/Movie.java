package com.demo.serialization.common.model;

import lombok.Data;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Data
public class Movie {

    private Instant registerTime;
    private Date release;
    private UUID id;
    private String name;
}
