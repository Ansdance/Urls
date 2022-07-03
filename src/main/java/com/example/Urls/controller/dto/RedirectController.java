package com.example.Urls.controller.dto;

import com.example.Urls.service.RedirectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping(RedirectController.REDIRECTION_PREFIX)
public class RedirectController {
    public static final String REDIRECTION_PREFIX = "/ans";
    private final RedirectionService service;

    public RedirectController(RedirectionService service) {
        this.service = service;
    }

    @GetMapping("/{link}")
    RedirectView redirect(@PathVariable String link) {
        return new RedirectView(service.doRedirect(link));
    }
}
