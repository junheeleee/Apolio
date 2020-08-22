package com.ssafy.apolio;

import com.ssafy.apolio.config.AppProperties;
import com.ssafy.apolio.config.FileUploadProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableConfigurationProperties({
        FileUploadProperties.class,
        AppProperties.class
})
@EnableJpaAuditing
@SpringBootApplication
public class ApolioApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ApolioApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApolioApplication.class);
    }
}
