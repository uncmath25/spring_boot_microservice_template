package com.uncmath25.template.webapi.healthcheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class SimpleHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
//        TODO: Perform actual health check
        if (false) { return Health.down().withDetail("Error", "ERROR").build(); }
        return Health.up().build();
    }
}
