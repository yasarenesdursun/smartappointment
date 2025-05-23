package com.dursun.smartappointment.payload.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Incorrect response information")
@Data
@Builder
public class ApiErrorResponse {
    @Schema(example = "400")
    private int status;
    @Schema(example = "Invalid request parameter.")
    private String message;
    @Schema(example = "2025-05-20T22:15:41.123")
    private LocalDateTime timestamp;
    @Schema(example = "/api/appointment")
    private String path;
}
