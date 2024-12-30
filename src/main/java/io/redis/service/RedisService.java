package io.redis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Author: Khonimov Ulugbek
 * Date: 12/30/2024 2:35 PM
 * Info:
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RedisService {

    @Cacheable(cacheNames = "get", key = "#key")
    public String get(String key) {
        return UUID.randomUUID().toString();
    }

    @CachePut(cacheNames = "get", key = "#key")
    public String set(String key) {
        return UUID.randomUUID().toString();
    }
}
