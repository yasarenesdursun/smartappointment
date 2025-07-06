package com.dursun.smartappointment.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "appointment")
@Data
public class AppointmentProperties {
    private int slotDurationMinutes;
}
