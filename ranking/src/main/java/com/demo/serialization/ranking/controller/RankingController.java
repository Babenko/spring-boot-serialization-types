package com.demo.serialization.ranking.controller;

import com.demo.serialization.common.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RankingController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/ranking", produces = "application/json")
    public List<Movie> ranking() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/octet-stream");
        ResponseEntity<ArrayList> exchange = restTemplate.exchange("http://localhost:8080/list", HttpMethod.GET, new HttpEntity<>(null, headers), ArrayList.class);
        return exchange.getBody();
    }
}
