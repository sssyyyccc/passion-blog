package com.developerchen.core.config;

import com.developerchen.core.exception.ErrorViewResolver;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring MVC 配置类
 *
 * @author syc
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin/index").setViewName("admin/index");
        registry.addViewController("/admin/files").setViewName("admin/file/index");
    }

    @Bean
    public DefaultErrorViewResolver conventionErrorViewResolver(
            ApplicationContext applicationContext,
            ResourceProperties resourceProperties) {
        return new ErrorViewResolver(applicationContext, resourceProperties);
    }

}