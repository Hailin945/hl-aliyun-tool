package com.chinavisionary.tools.aliyun.green.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author Hailin
 * @date 2019/12/17
 */
@SpringBootApplication
@ComponentScans(value = {
        @ComponentScan("com.chinavisionary.tools.aliyun.green.**")
})
public class ToolsAliyunGreenTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolsAliyunGreenTestApplication.class, args);
    }
}
