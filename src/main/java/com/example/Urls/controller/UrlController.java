package com.example.Urls.controller;

import com.example.Urls.controller.dto.GenerateResponse;
import com.example.Urls.controller.dto.RedirectController;
import com.example.Urls.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.MalformedURLException;
import java.net.URL;


@Controller
@RequestMapping("/add")
public class UrlController {
    private final GeneratorService generatorService;

    @Autowired
    public UrlController(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @PostMapping(value = "/html")
    public String addHtml(Model model, @RequestParam(value = "link") String link) throws MalformedURLException {
        GenerateResponse generateResponse = new GenerateResponse(RedirectController.REDIRECTION_PREFIX, generatorService.generateShortUrl(link));
        model.addAttribute("link", generateResponse.getLink());
        model.addAttribute("keyed", keyUrl(link));
        return "result";
    }

    public String keyUrl (String link) throws MalformedURLException {
        URL aURL = new URL(link);
        return aURL.getHost();
    }
}
