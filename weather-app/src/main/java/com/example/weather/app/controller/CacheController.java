package com.example.weather.app.controller;

import com.example.weather.app.service.RedisCacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class CacheController {

    private final RedisCacheService redisCacheService;

    public CacheController(RedisCacheService redisCacheService) {
        this.redisCacheService = redisCacheService;
    }

    @GetMapping("/cache/keys")
    public Set<String> getKeys() {
        return redisCacheService.getAllKeys();
    }

}
