package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author haoren
 * @date 2024/06/02 17:18
 **/
@Service
@Slf4j
public class TestService {
    @Cacheable(value = "testCache", key = "#id",cacheManager = "caffeine")
    public String testCache(String id) {
        log.info("testCache " + id);
        return "testCache " + id;
    }

    public String testCacheYml(String id) {
        log.info("testCacheYml " + id);
        return "testCacheYml " + id;
    }
}
