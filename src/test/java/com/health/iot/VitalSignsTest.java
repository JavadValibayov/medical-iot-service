package com.health.iot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class VitalSignsTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidVitalSigns() throws Exception {
        // Simulating a healthy patient data packet
        String json = "{\"patientId\": \"TEST-01\", \"heartRate\": 75}";

        mockMvc.perform(post("/api/v1/vitals")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isAccepted()) // Expect 202 Accepted
                .andExpect(content().string("Data accepted for processing."));
    }

    @Test
    public void testInvalidHeartRate() throws Exception {
        // Simulating a sensor error (Heart Rate 500 is impossible)
        // The system MUST reject this to pass the test
        String json = "{\"patientId\": \"TEST-02\", \"heartRate\": 500}";

        mockMvc.perform(post("/api/v1/vitals")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest()); // Expect 400 Bad Request
    }
}