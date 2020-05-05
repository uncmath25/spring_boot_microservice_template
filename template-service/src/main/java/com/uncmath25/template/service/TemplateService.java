package com.uncmath25.template.service;

import com.uncmath25.template.park.model.Park;
import com.uncmath25.template.repo.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateService {
    @Autowired
    private TemplateRepository templateRepository;

    public Park getPark(final String name) {
        return templateRepository.getPark(name);
    }

    public void putPark(final String name,
                        final Park park) {
        templateRepository.putPark(name, park);
    }
}
