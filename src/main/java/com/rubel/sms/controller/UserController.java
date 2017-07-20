package com.rubel.sms.controller;

import com.rubel.sms.model.User;
import com.rubel.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rubel on 7/16/17.
 */
@Controller
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/home")
    public ModelAndView userHome(){
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("msg", "450");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/createOrUpdate", method = RequestMethod.POST)
    public Map<String, Object> getSaved(User user) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (userService.saveOrUpdate(user) != null) {
            map.put("status", "200");
            map.put("message", "Your record have been saved successfully");
        }

        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Map<String, Object> getAll(User user) {
        Map<String, Object> map = new HashMap<String, Object>();

        List<User> list = userService.findAll();

        if (list != null) {
            map.put("status", "200");
            map.put("message", "Data found");
            map.put("data", list);
        } else {
            map.put("status", "404");
            map.put("message", "Data not found");

        }

        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Map<String, Object> delete(User user) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (userService.delete(user) != null) {
            map.put("status", "200");
            map.put("message", "Your record have been deleted successfully");
        }

        return map;
    }

}
