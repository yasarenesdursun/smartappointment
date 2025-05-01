package com.dursun.smartappointment.helper.mapper;

import com.dursun.smartappointment.entity.Appointment;
import com.dursun.smartappointment.payload.AppointmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper extends BaseMapper<Appointment, AppointmentDto> {
    @Override
    @Mapping(source = "user.username", target = "username")
    AppointmentDto mapToDto(Appointment entity);

    @Override
    @Mapping(target = "user", ignore = true) // çünkü user ilişkisini dışarıdan set edeceğiz
    Appointment mapFromDto(AppointmentDto dto);
}
