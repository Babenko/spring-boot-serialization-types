package com.demo.serialization.common.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@Data
@ToString
public class Movies {

    private ArrayList<Movie> movies;
}
