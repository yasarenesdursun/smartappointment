package com.dursun.smartappointment.payload.req;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequest {

    @NotBlank(message = "Title cannot be null")
    private String title;

    private String note;

    @NotNull(message = "Start time required")
    @Future(message = "Start time must be in the future")
    private LocalDateTime startTime;

    @NotNull(message = "End date required")
    @Future(message = "End time must be in the future")
    private LocalDateTime endTime;
}
