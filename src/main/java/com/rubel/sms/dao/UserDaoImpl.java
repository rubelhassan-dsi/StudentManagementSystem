package com.rubel.sms.dao;

import com.rubel.sms.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rubel on 7/16/17.
 */
@Repository
@Transactional
public class UserDaoImpl  implements UserDao {

    @Autowired
    SessionFactory session;

    public List<User> findAll() {
        return session.getCurrentSession().createQuery("from User").list();
    }

    public User delete(User user) {
        try{
            session.getCurrentSession().delete(user);
        }catch (Exception e){
            return null;
        }

        return user;
    }

    public User saveOrUpdate(User user) {
        session.getCurrentSession().saveOrUpdate(user);
        return user;
    }
}
