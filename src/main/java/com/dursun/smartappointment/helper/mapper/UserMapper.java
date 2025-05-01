package com.dursun.smartappointment.helper.mapper;

import com.dursun.smartappointment.entity.User;
import com.dursun.smartappointment.payload.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDTO> {
}
