package com.example.Urls;

import com.example.Urls.properties.ShortenerConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ShortenerConfigProperties.class)
@SpringBootApplication
public class UrlsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlsApplication.class, args);
	}

}
