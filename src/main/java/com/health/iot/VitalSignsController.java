package com.health.iot;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vitals")
public class VitalSignsController {

    @Autowired
    private VitalSignsService service;

    @PostMapping
    public ResponseEntity<String> receiveVitals(@Valid @RequestBody VitalSignData data) {
        service.processData(data);
        return ResponseEntity.accepted().body("Data accepted for processing.");
    }
}
