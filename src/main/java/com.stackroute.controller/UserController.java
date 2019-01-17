package com.stackroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    User user=new User();

    @RequestMapping(value= "/")
    public String greeting(){

        return "login";
    }

    @RequestMapping("/index")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
        user.setName(request.getParameter("h1"));
        user.setPassword(request.getParameter("h2"));

        String message = "Welcome to Stackroute" + " "+user.getName();

        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("index");
        modelView.addObject("result",message);
        return modelView;

    }

}

