package com.example.Urls.service.impl;

import com.example.Urls.model.RankedUrl;
import com.example.Urls.model.Url;
import com.example.Urls.repository.UrlRepository;
import com.example.Urls.service.*;
import com.example.Urls.utils.Base62;
import com.example.Urls.utils.Base62Exception;
import org.springframework.stereotype.Service;

@Service
public class UrlService implements RedirectionService, GeneratorService {
    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    @Override
    public String generateShortUrl(String original) {
        Url url = new Url(original);
        repository.save(url);
        return Base62.to(url.getId());
    }

    @Override
    public String doRedirect(String link) {
        try {
            int id = Base62.from(link);
            String originalUrl = repository
                    .findById(id)
                    .orElseThrow(() -> new LinkNotFoundException(link))
                    .getOriginal();
            return originalUrl;
        } catch (Base62Exception e) {
            throw new WrongLinkException(link, e);
        }
    }


    private UrlStatistic convertRankedUrlToUrlStatistic(RankedUrl url) {
        return new UrlStatistic(url, Base62.to(url.getId()));
    }
}
