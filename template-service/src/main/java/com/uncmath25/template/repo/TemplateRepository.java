package com.uncmath25.template.repo;

import com.uncmath25.template.park.model.Park;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository {
    Park getPark(final String name);
    void putPark(final String name,
                 final Park park);
}
