package com.uncmath25.template.repo.prod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uncmath25.template.park.model.Park;
import com.uncmath25.template.repo.TemplateRepository;
import com.uncmath25.template.repo.mock.DataBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
@Profile("prod")
public class TemplateRepositoryProdImpl implements TemplateRepository {
    private static Logger LOG = LoggerFactory.getLogger(TemplateRepository.class);

    public Park getPark(final String name) {
//        TODO: Replace with S3Client prod implementation
        return DataBuilder.buildPark(name);
    }

    public void putPark(final String name,
                        final Park park) {
//        TODO: Replace with S3Client prod implementation
        try {
            LOG.info("Template Prod Repository received the following JSON data for name: {}, : {}",
                    name, new ObjectMapper().writeValueAsString(park));
        } catch (IOException e) {}
    }
}
