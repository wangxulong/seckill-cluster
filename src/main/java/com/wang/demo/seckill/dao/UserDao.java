package com.wang.demo.seckill.dao;

import com.wang.demo.seckill.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserDao {
    @Select("select * from t_user where id=#{id}")
    User findById(int id);
}
