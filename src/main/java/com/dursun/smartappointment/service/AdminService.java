package com.dursun.smartappointment.service;

import com.dursun.smartappointment.helper.mapper.UserMapper;
import com.dursun.smartappointment.payload.UserDTO;
import com.dursun.smartappointment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::mapFrom).toList();
    }
}
