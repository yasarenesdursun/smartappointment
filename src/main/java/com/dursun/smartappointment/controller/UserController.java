package com.dursun.smartappointment.controller;

import com.dursun.smartappointment.entity.User;
import com.dursun.smartappointment.helper.mapper.UserMapper;
import com.dursun.smartappointment.payload.UserDTO;
import com.dursun.smartappointment.repository.UserRepository;
import com.dursun.smartappointment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public UserDTO getCurrentUser(@AuthenticationPrincipal UserDTO dto) {
        return userService.getCurrentUser(dto);
    }
}
