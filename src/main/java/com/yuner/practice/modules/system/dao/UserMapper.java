package com.yuner.practice.modules.system.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuner.practice.modules.system.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
