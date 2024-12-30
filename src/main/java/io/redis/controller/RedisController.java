package io.redis.controller;

import io.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Khonimov Ulugbek
 * Date: 12/30/2024 2:35 PM
 * Info:
 */
@RestController
@RequestMapping("/v1/redis")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RedisController {
    private final RedisService redisService;

    @GetMapping
    public String get(@RequestParam String key) {
        return redisService.get(key);
    }

    @GetMapping("/{key}")
    public String set(@PathVariable String key) {
        return redisService.set(key);
    }

}
