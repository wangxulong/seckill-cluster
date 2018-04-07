package com.wang.demo.seckill.service;

import com.wang.demo.seckill.dao.UserDao;
import com.wang.demo.seckill.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findById(Integer id) {
        return userDao.findById(id);
    }
}
