package com.chinavisionary.tools.aliyun.sms.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans(value = {
        @ComponentScan("com.chinavisionary.tools.aliyun.sms.**")
})
public class ToolsAliyunSmsTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolsAliyunSmsTestApplication.class, args);
    }

}
