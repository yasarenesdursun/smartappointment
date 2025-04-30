package com.dursun.smartappointment.payload;

import com.dursun.smartappointment.enums.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;

    private String username;

    private String email;

    private Role role;
}
