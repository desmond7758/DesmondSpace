package com.dsm.springbootdemo;

import com.dsm.springbootdemo.filter.TestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.dsm.springbootdemo.servlet")
public class SpringbootdemoApplication {

    public static void main(String[] args) {
        // 启动方式1
        new SpringApplicationBuilder(SpringbootdemoApplication.class)
                // 不开启Web
                .web(WebApplicationType.NONE)
                .properties("key=value")
                .run(args);
        // 启动方式2
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

    @Bean
    public RegistrationBean dsmFilter(){
        RegistrationBean dsmFilter = new FilterRegistrationBean<>();
        ((FilterRegistrationBean) dsmFilter).setFilter(new TestFilter());
        return dsmFilter;
    }
}
