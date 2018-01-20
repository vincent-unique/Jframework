package org.trump.vincent.mybatis.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception{

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","Hello World!");

        modelAndView.setViewName("/WEB-INF/content/welcome.jsp");

        return modelAndView;
    }

}
