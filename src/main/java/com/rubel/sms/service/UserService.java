package com.rubel.sms.service;

import com.rubel.sms.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rubel on 7/16/17.
 */

public interface UserService {
    public List<User> findAll();
    public User delete(User user);
    public User saveOrUpdate(User user);
}
