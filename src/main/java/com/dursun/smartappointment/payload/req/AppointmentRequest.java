package com.dursun.smartappointment.payload.req;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequest {
    private String title;
    private String note;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
