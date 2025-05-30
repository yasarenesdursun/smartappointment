package com.dursun.smartappointment.controller;

import com.dursun.smartappointment.entity.Appointment;
import com.dursun.smartappointment.payload.AppointmentDto;
import com.dursun.smartappointment.payload.req.AppointmentRequest;
import com.dursun.smartappointment.payload.resp.ApiErrorResponse;
import com.dursun.smartappointment.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    @Operation(summary = "Create new appointment")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
        @ApiResponse(responseCode = "403", description = "Unauthorized operation", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    public AppointmentDto createAppointment(@Valid @RequestBody AppointmentRequest request) {
        return appointmentService.create(request);
    }

    @GetMapping
    public List<AppointmentDto> getMyAppointments() {
        return appointmentService.getMyAppointments();
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<AppointmentDto> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        appointmentService.delete(id);
    }

    @GetMapping(params = "date")
    public List<AppointmentDto> getAppointmentsByDate(@RequestParam("date") LocalDate date) {
        return appointmentService.getAppointmentsByDate(date);
    }
}
