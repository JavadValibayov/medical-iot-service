package com.health.iot;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class VitalSignData {

    @NotNull(message = "Patient ID is required")
    private String patientId;

    @NotNull
    @Min(value = 0, message = "Heart rate cannot be negative")
    @Max(value = 300, message = "Heart rate > 300 is physically impossible")
    private Integer heartRate;

    private Integer oxygenLevel;
    private LocalDateTime timestamp;

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public Integer getHeartRate() { return heartRate; }
    public void setHeartRate(Integer heartRate) { this.heartRate = heartRate; }

    public Integer getOxygenLevel() { return oxygenLevel; }
    public void setOxygenLevel(Integer oxygenLevel) { this.oxygenLevel = oxygenLevel; }
    
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}