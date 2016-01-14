package de.muenchen.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by huningd on 14.01.16.
 */
//@Configuration
//@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{

    // CORS to allow isPreFlightRequest
    // https://github.com/angular/angular.js/issues/3406
    // https://dzone.com/articles/cors-support-spring-framework
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept")
                .allowedMethods("POST", "PUT", "PATCH", "GET", "OPTIONS", "DELETE")
                .exposedHeaders( "Location")
                .maxAge(3600l)
                .allowedOrigins("*");
    }
}
