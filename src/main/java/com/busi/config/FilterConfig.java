package com.busi.config;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanglei25 on 2016/4/8.
 */

@Order(3)
@Configuration
public class FilterConfig {

    @Order(4)
    @Bean
    public FilterRegistrationBean singleSignOutFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new SingleSignOutFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("casServerUrlPrefix","https://localhost:8443/cas-server-webapp-3.4.10/login");
        //filterRegistrationBean.addInitParameter("casServerUrlPrefix","https://localhost:8447/index");
        filterRegistrationBean.setName("CAS Single Sign Out Filter");
        return filterRegistrationBean;
    }

    @Order(5)
    @Bean
    public FilterRegistrationBean authFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new AuthenticationFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String,String> initParamMap = new HashMap<>();
        initParamMap.put("casServerLoginUrl","https://localhost:8443/cas-server-webapp-3.4.10/login");
       // initParamMap.put("casServerLoginUrl","https://localhost:8447/login");
        initParamMap.put("serverName","http://localhost:8081/#");
        filterRegistrationBean.setInitParameters(initParamMap);
        filterRegistrationBean.setName("CAS Auth Filter");
        return filterRegistrationBean;
    }

    @Order(6)
    @Bean
    public FilterRegistrationBean validatorFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName("CAS Validator Filter");
        filterRegistrationBean.setFilter(new Cas20ProxyReceivingTicketValidationFilter());
        Map<String,String> initParamMap = new HashMap<>();
        initParamMap.put("casServerUrlPrefix","https://localhost:8447");
        initParamMap.put("serverName","http://localhost:8081");
        filterRegistrationBean.setInitParameters(initParamMap);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
