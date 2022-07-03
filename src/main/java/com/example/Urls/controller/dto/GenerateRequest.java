package com.example.Urls.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateRequest {
    @NotNull(message = "field original cannot be null")
    @NotBlank(message = "field original cannot be empty")
    private String original;
}
