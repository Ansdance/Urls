package com.example.Urls.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ConfigurationProperties(prefix = "example")
public class ShortenerConfigProperties {

    @NotBlank
    private String prefix;
}
