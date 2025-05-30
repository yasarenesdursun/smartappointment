package com.dursun.smartappointment.repository;


import com.dursun.smartappointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByUserId(Long userId);

    @Query("""
            SELECT a FROM Appointment a
            WHERE (
            (:startTime BETWEEN a.startTime AND a.endTime) OR
            (:endTime BETWEEN a.startTime AND a.endTime) OR
            (a.startTime BETWEEN :startTime AND :endTime)
            )
            """)
    List<Appointment> findConflictingAppointments(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    List<Appointment> findByStartTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
}
