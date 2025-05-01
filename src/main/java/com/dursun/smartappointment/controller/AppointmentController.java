package com.dursun.smartappointment.controller;

import com.dursun.smartappointment.entity.Appointment;
import com.dursun.smartappointment.payload.AppointmentDto;
import com.dursun.smartappointment.payload.req.AppointmentRequest;
import com.dursun.smartappointment.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public AppointmentDto addAppointment(@RequestBody AppointmentRequest request) {
        return appointmentService.create(request);
    }

    @GetMapping
    public List<AppointmentDto> getAppointments() {
        return appointmentService.getMyAppointments();
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<AppointmentDto> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        appointmentService.delete(id);
    }
}
