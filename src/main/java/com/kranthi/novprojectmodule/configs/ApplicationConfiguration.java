package com.kranthi.novprojectmodule.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApplicationConfiguration {

    @Bean
    public RestTemplate resttemplate(){
        return new RestTemplate();
    }
}
