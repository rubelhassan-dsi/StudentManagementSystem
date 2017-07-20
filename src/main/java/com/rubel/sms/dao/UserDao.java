package com.rubel.sms.dao;

import com.rubel.sms.model.User;

import java.util.List;

/**
 * Created by rubel on 7/16/17.
 */
public interface UserDao {

    public List<User> findAll();
    public User delete(User user);
    public User saveOrUpdate(User user);

}
