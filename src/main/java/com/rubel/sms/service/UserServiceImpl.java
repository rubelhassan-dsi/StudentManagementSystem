package com.rubel.sms.service;

import com.rubel.sms.dao.UserDao;
import com.rubel.sms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rubel on 7/16/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User delete(User user) {
        return userDao.delete(user);
    }

    public User saveOrUpdate(User user) {
        return userDao.saveOrUpdate(user);
    }
}
