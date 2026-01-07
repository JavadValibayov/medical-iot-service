package com.health.iot;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class VitalSignsService {

    @Async
    public void processData(VitalSignData data) {
        // Simulate heavy processing
        try {
            Thread.sleep(100); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (data.getTimestamp() == null) {
            data.setTimestamp(LocalDateTime.now());
        }

        if (data.getHeartRate() > 120) {
            System.out.println("[ALERT] TACHYCARDIA DETECTED: Patient " + data.getPatientId());
        } else {
            System.out.println("[INFO] Normal Vitals: Patient " + data.getPatientId());
        }
    }
}