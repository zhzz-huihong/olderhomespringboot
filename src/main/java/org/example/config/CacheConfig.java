package org.example.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.CaffeineSpec;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

/**
 * @author haoren
 * @date 2024/06/02 17:03
 **/
@Slf4j
@Configuration
public class CacheConfig {

    @Value("${spring.cache.caffeine.spec}")
    private String caffeineSpec;

    @Primary
    @Bean(name = "caffeine")
    public CacheManager cacheManagerWithCaffeine() {
        Caffeine<Object, Object> caffeine = Caffeine.newBuilder()
                .initialCapacity(50)
                .maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .evictionListener((k, v, e) -> {
                    log.info("key: " + k + " value: " + v + " cacheManagerWithCaffeine reason: " + e);
                })
                .recordStats();
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(caffeine);
        cacheManager.setAllowNullValues(true);
        return cacheManager;
    }

    @Bean(name = "caffeineByYml")
    public CacheManager cacheManagerWithCaffeineYml() {
        CaffeineSpec spec = CaffeineSpec.parse(caffeineSpec);
        Caffeine<Object, Object> caffeine = Caffeine.from(spec);
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(caffeine);
        cacheManager.setAllowNullValues(true);
        return cacheManager;
    }
}
