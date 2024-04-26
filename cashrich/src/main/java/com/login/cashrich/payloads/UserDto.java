package com.login.cashrich.payloads;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserDto {

    private int id;
    @NotBlank(message = "Cannot be Empty")
    private String firstName;

    @NotBlank(message = "Cannot be Empty")
    private String lastName;

    @Email(message = "Email address is not valid")
    @NotBlank(message = "Cannot be Empty")
    private String email;

    @NotBlank(message = "Cannot be Empty")
    private String mobile;

//    @Size(min = 4, max = 15)
    @Pattern(regexp =  "^[a-zA-Z0-9]{4,15}", message = "username should be char and digit of length 4-15")
    @NotBlank(message = "Cannot be Empty")
    private String username;

    @NotBlank(message = "Cannot be Empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$",
            message = "Password must contain 1 uppercase letter, 1 lowercase letter, 1 digit, 1 special character (8-15 characters)")
    private String password;
}
