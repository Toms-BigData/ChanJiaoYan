package com.lyx.teach;

import com.lyx.teach.config.IdInfoConfig;
import com.lyx.teach.config.UrlInfoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({UrlInfoConfig.class, IdInfoConfig.class})
public class planApp {
    public static void main(String[] args) {
        SpringApplication.run(planApp.class, args);
    }
}
