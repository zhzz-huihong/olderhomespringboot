package org.example.controller;

import jakarta.annotation.Resource;
import org.example.common.response.Result;
import org.example.pojo.dto.UserDto;

import org.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author haoren
 * @date 2024/06/02 14:38
 **/
@RestController
public class TestController {
    @Resource
    private CacheManager caffeine;
    @Resource
    private TestService testService;
    @GetMapping("/test/info")
    public Result testInfo() {
        return Result.success("查询成功",new UserDto(1L,"admin","123456"));
    }

    @GetMapping("/test/cache/{id}")
    public Result testCache(@PathVariable("id") String id) {
        String testCache = testService.testCache(id);
        return Result.success("查询成功",testCache);
    }

    @GetMapping("/test/cacheyml/{id}")
    @Cacheable(value = "testCacheYml", key = "#id",cacheManager = "caffeineByYml")
    public Result testCacheState(@PathVariable("id") String id) {
        String testCache = testService.testCacheYml(id);
        return Result.success("查询成功",testCache);
    }
}
