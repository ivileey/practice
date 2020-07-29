package com.yuner.practice.modules.system.web;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.yuner.practice.modules.system.entity.User;
import com.yuner.practice.modules.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/system/user")
@Api(value = "user", tags = "用户管理模块")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody User user) {
        return R.ok(userService.save(user));
    }

    @ApiOperation(value="获取用户列表", notes = "获取用户列表")
    @GetMapping("/list")
    public R<List<User>> list() {
        return R.ok(userService.list(Wrappers.<User>query()));
    }


    @GetMapping("/hello")
    public String test(){
        return "Helloword";
    }



}
