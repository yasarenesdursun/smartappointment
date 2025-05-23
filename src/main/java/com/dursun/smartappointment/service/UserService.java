package com.dursun.smartappointment.service;

import com.dursun.smartappointment.entity.User;
import com.dursun.smartappointment.helper.mapper.UserMapper;
import com.dursun.smartappointment.payload.UserDTO;
import com.dursun.smartappointment.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO getCurrentUser(UserDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        return userMapper.mapToDto(user);
    }
}
