package com.uncmath25.template.webapi.endpoints;

import com.uncmath25.template.park.model.Park;
import com.uncmath25.template.service.TemplateService;
import com.uncmath25.template.webapi.entities.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TemplateDelegate {
    @Autowired
    private TemplateService templateService;

    public Park getPark(final String name) {
        return templateService.getPark(name);
    }

    public SimpleResponse putPark(final String name,
                                  final Park park) {
        templateService.putPark(name, park);
        final String STORED_MESSAGE = "Park was successfully stored!";
        return new SimpleResponse(STORED_MESSAGE);
    }
}
