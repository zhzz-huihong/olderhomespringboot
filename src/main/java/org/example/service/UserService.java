package org.example.service;

import cn.hutool.core.bean.BeanUtil;
import jakarta.annotation.Resource;
import org.example.dao.UserDao;
import org.example.pojo.dto.UserDto;
import org.example.pojo.entity.UserEntity;
import org.example.utils.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoren
 * @date 2024/06/02 15:13
 **/
@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public List<UserDto> getAllUser() {
        return BeanUtils.copyList(userDao.findAll(), UserDto.class);
    }
}
