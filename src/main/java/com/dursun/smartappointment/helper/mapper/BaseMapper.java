package com.dursun.smartappointment.helper.mapper;

public interface BaseMapper<E, D> {
    D mapTo(E entity);
    E mapFrom(D dto);
}
