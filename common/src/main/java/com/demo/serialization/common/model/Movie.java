package com.demo.serialization.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Instant registerTime;
    private Date release;
    private UUID id;
    private String name;
}
