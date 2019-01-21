package com.stackroute.controller;

import com.stackroute.services.DatabaseConnection;
import com.stackroute.services.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    Login login =new Login();
    @RequestMapping(value= "/")
    public String greeting(){

        return "login";
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){

        DatabaseConnection databaseConnection = new DatabaseConnection();

        login.setUsername(request.getParameter("h1"));
        login.setPassword(request.getParameter("h2"));

        String message = "Welcome to Stackroute" + " "+ login.getUsername();

        databaseConnection.InsertData(login.getUsername(),login.getPassword());
        databaseConnection.showdata();
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("index");
        modelView.addObject("result",message);
        return modelView;

    }

}

