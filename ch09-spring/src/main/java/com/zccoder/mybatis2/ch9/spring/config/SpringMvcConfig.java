package com.zccoder.mybatis2.ch9.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * 标题：SpingMvc配置类<br>
 * 描述：SpingMvc配置类<br>
 * 时间：2018/06/27<br>
 *
 * @author zc
 **/
@Configuration
@EnableWebMvc
@ComponentScan("com.zccoder.mybatis2.ch9.spring")
@ImportResource("classpath:applicationContext.xml")
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置视图解析器
     * @return JSP视图解析器
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
     * 配置静态资源映射
     * @param registry 注册器
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径。
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 配置ViewController点击链接直接跳转页面
     * @param registry 注册器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/index").setViewName("index");
//        registry.addViewController("/dict_add").setViewName("dict_add");
//        registry.addViewController("/dicts").setViewName("dicts");
    }
}
