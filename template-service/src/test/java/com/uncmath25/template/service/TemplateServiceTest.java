package com.uncmath25.template.service;

import com.uncmath25.template.model.TestUtils;
import com.uncmath25.template.repo.mock.DataBuilder;
import com.uncmath25.template.service.TemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TemplateServiceTest {
    @Autowired
    private TemplateService templateService;

    @Test
    public void testGetPark() {
        final String name = "Test Park";
        TestUtils.assertParksEqual(
                templateService.getPark(name),
                DataBuilder.buildPark(name)
        );
    }
}
