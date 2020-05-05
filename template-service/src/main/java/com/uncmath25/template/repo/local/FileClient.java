package com.uncmath25.template.repo.local;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uncmath25.template.repo.TemplateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Service
public class FileClient {
    private static Logger LOG = LoggerFactory.getLogger(TemplateRepository.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${storage.localDir}")
    private String LOCAL_DIR;
    @Value("${storage.dataDir}")
    private String DATA_DIR;

    private final String JSON_EXT = ".json";

    public <T> T readJsonObject(final String fileName,
                                final Class<T> jsonObjectClass) throws IOException {
        final String path = Paths.get(LOCAL_DIR, DATA_DIR, fileName).toString() + JSON_EXT;
        LOG.info("Reading JSON data locally from: {}", path);
        return objectMapper.readValue(new File(path), jsonObjectClass);
    }

    public void writeJsonObject(final String fileName,
                                final Object jsonObject) throws IOException {
        final String path = Paths.get(LOCAL_DIR, DATA_DIR, fileName).toString() + JSON_EXT;
        final File file = new File(path);
        file.getParentFile().mkdirs();
        objectMapper.writeValue(file, jsonObject);
        LOG.info("Wrote JSON data locally to: {}", path);
    }
}
