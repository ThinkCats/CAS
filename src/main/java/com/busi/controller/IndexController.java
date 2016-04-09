package com.busi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wanglei25 on 2016/4/7.
 */
@Slf4j
@RequestMapping("/")
@Controller
public class IndexController {

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String home(){
        return "index";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(){
        log.info("begin login...");
        System.out.println("-------------------------------------------------------------------------- TEST POST ------------------------------------------------");
        return "index";
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String loginGet(){
        log.info("begin login...");
        System.out.println("-------------------------------------------------------------------------- TEST GET ------------------------------------------------");
        return "index";
    }
}
