package com.yuner.practice.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuner.practice.modules.system.dao.UserMapper;
import com.yuner.practice.modules.system.entity.User;
import com.yuner.practice.modules.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
