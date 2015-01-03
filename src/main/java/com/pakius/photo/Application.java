package com.pakius.photo;


import com.cloudinary.Cloudinary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


import javax.servlet.MultipartConfigElement;
import java.io.IOException;


@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("1048576KB");
        factory.setMaxRequestSize("1048576KB");
        return factory.createMultipartConfig();
    }

    @Value("${cloudinary.cloud_name}")
    private  String cloudinaryCloudName;

    @Value("${cloudinary.api_key}")
    private String cloudinaryApiKey;

    @Value("${cloudinary.api_secret}")
    private String cloudinaryApiSecret;

    @Bean
    public Cloudinary cloudinary() {
        return  new Cloudinary(Cloudinary.asMap(
                "cloud_name", cloudinaryCloudName,
                "api_key", cloudinaryApiKey,
                "api_secret", cloudinaryApiSecret));

    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);

    }

}
