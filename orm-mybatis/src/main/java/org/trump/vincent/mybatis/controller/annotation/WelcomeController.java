package org.trump.vincent.mybatis.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/hello")
    public ModelAndView hello(HttpServletRequest request, HttpServletResponse response){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","Welcome World!");
        modelAndView.setViewName("/WEB-INF/content/welcome.jsp");
        return modelAndView;
    }


    @RequestMapping(value = "/hello")
    public String welcome(HttpServletRequest request, HttpServletResponse response){

        return "/WEB-INF/content/welcome.jsp";
    }
}
