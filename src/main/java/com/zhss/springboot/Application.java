package com.zhss.springboot;

import com.zhss.springboot.config.DruidDataSourceConfig;
import com.zhss.springboot.listener.MyApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*@EnableAutoConfiguration
@Configuration
@ComponentScan*/
@SpringBootApplication
@RestController
@Import(DruidDataSourceConfig.class)
public class Application {


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(new MyApplicationStartedEventListener());
        app.run(args);
    }
}
