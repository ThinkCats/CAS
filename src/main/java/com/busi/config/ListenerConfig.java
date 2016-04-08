package com.busi.config;

import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Created by wanglei25 on 2016/4/8.
 */

@Order(2)
@Configuration
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean casListener(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new SingleSignOutHttpSessionListener());
        return servletListenerRegistrationBean;
    }
}
