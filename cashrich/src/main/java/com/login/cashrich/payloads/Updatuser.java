package com.login.cashrich.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Updatuser {

    @NotBlank(message = "Cannot be Empty")
    private String firstName;

    @NotBlank(message = "Cannot be Empty")
    private String lastName;
    @NotBlank(message = "Cannot be Empty")
    private String mobile;
    @NotBlank(message = "Cannot be Empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$",
            message = "Password must contain 1 uppercase letter, 1 lowercase letter, 1 digit, 1 special character (8-15 characters)")
    private String password;
}
