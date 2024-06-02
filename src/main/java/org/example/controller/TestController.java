package org.example.controller;

import org.example.common.response.Result;
import org.example.pojo.dto.UserDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haoren
 * @date 2024/06/02 14:38
 **/
@RestController
public class TestController {
    @GetMapping("/test/info")
    public Result testInfo() {
        return Result.success("查询成功",new UserDto(1L,"admin","123456"));
    }
}
