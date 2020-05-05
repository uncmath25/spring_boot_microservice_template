package com.uncmath25.template.webapi.endpoints;

import com.uncmath25.template.park.model.Park;
import com.uncmath25.template.webapi.entities.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/template")
public class TemplateController {
    @Autowired
    private TemplateDelegate templateDelegate;

    private static final ResponseStatusException parkNotFoundException
            = new ResponseStatusException(HttpStatus.NOT_FOUND, "Park not found");

    @GetMapping("/parks/{name}")
    ResponseEntity<Park> getPark(
            @PathVariable final String name
    ) {
        final Park response = templateDelegate.getPark(name);
        if (response == null) { throw parkNotFoundException; }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/parks/{name}")
    ResponseEntity<SimpleResponse> putPark(
            @PathVariable final String name,
            @RequestBody final Park park
    ) {
        final SimpleResponse response = templateDelegate.putPark(name, park);
        if (response == null) { throw parkNotFoundException; }
        return ResponseEntity.ok(response);
    }
}
