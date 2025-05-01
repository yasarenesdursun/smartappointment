package com.dursun.smartappointment.helper.mapper;

public interface BaseMapper<E, D> {
    D mapToDto(E entity);
    E mapFromDto(D dto);
}
