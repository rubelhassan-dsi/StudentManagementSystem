package com.rubel.sms.controller;

import com.rubel.sms.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by rubel on 7/22/17.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView tryLogin(@ModelAttribute("user") User user){
        ModelAndView mav = new ModelAndView("userHome");
        System.out.println("User Name: " + user.getName() + ", " + user.getEmail());
        mav.addObject("user", user);
        return mav;
    }
}
