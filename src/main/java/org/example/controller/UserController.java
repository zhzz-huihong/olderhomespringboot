package org.example.controller;

import jakarta.annotation.Resource;
import org.example.common.response.Result;
import org.example.pojo.dto.UserDto;
import org.example.pojo.entity.UserEntity;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haoren
 * @date 2024/06/02 15:11
 **/
@RestController
public class UserController {

    @Resource
    private UserService userService;
    @GetMapping("/user/all")
    public Result getAllUser(){
        List<UserDto> userDtoList = userService.getAllUser();
        return Result.success("查询成功",userDtoList);
    }

}
