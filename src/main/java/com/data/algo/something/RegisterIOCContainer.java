package com.data.algo.something;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterIOCContainer {

    @Bean
    public WithoutAnnotation withoutAnnotation(){
        return new WithoutAnnotation();
    }
}
