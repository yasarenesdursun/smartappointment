package com.dursun.smartappointment.service;

import com.dursun.smartappointment.entity.Appointment;
import com.dursun.smartappointment.entity.User;
import com.dursun.smartappointment.enums.Role;
import com.dursun.smartappointment.helper.mapper.AppointmentMapper;
import com.dursun.smartappointment.payload.AppointmentDto;
import com.dursun.smartappointment.payload.req.AppointmentRequest;
import com.dursun.smartappointment.repository.AppointmentRepository;
import com.dursun.smartappointment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final UserRepository userRepository;

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email).orElseThrow();
    }

    public AppointmentDto create(AppointmentRequest request){
        User user = getCurrentUser();

        Appointment appointment = Appointment.builder()
                .title(request.getTitle())
                .note(request.getNote())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .user(user)
                .build();

        return appointmentMapper.mapToDto(appointmentRepository.save(appointment));
    }

    public List<AppointmentDto> getMyAppointments() {
        User user = getCurrentUser();

        return appointmentRepository.findByUserId(user.getId())
                .stream()
                .map(appointmentMapper::mapToDto)
                .toList();
    }

    public List<AppointmentDto> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(appointmentMapper::mapToDto)
                .toList();
    }

    public void delete(Long id) {
        User user = getCurrentUser();
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found!."));

        if (!user.getRole().equals(Role.ADMIN) && !appointment.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You do not have permission the delete this appointment.");
        }

        appointmentRepository.delete(appointment);
    }
}
