package com.login.cashrich.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.dialect.MySQL8Dialect;

@Entity
@Table(name="Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {


    @Id //indicating the member field below is the primary key of current entity.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="First_Name")
    private String firstName;


    @Column(name="Last_Name")
    private String lastName;


    @Column(name="Email", unique = true)
    private String email;


    @Column(name="Mobile")
    private String mobile;

    @Column(name="User_Name")
    private String username;


    @Column(name="Password")
    private String password;

}
