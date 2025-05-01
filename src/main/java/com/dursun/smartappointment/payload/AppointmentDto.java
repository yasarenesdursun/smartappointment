package com.dursun.smartappointment.payload;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AppointmentDto {
    private Long id;
    private String title;
    private String note;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String username;
}
