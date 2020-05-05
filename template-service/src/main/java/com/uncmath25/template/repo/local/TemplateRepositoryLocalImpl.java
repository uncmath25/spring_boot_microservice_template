package com.uncmath25.template.repo.local;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uncmath25.template.park.model.Park;
import com.uncmath25.template.repo.TemplateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
@Profile("local")
public class TemplateRepositoryLocalImpl implements TemplateRepository {
    private static Logger LOG = LoggerFactory.getLogger(TemplateRepository.class);

    @Autowired
    private FileClient fileClient;

    public Park getPark(final String name) {
        try {
            final String fileName = name;
            return fileClient.readJsonObject(fileName, Park.class);
        } catch (IOException e) {
            LOG.error("Template Local Repository failed to retrieve JSON data for name: {}", name);
            return null;
        }
    }

    public void putPark(final String name,
                        final Park park) {
        try {
            LOG.info("Template Local Repository received the following JSON data for name: {}, : {}",
                    name, new ObjectMapper().writeValueAsString(park));
            final String fileName = name;
            fileClient.writeJsonObject(fileName, park);
        } catch (IOException e) {
            LOG.error("Template Local Repository failed to store JSON data for name: {}", name);
        }
    }
}
