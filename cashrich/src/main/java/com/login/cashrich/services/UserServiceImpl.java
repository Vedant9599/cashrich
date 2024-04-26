package com.login.cashrich.services;

import com.login.cashrich.entities.User;
import com.login.cashrich.payloads.Updatuser;
import com.login.cashrich.payloads.UserDto;
import com.login.cashrich.repositories.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userdto) {
        log.info("i have received this data {}",userdto.getUsername().toString());
        User user = this.DtotoUser(userdto);
            User savedUser = this.userRepo.save(user);
            return this.userToDto(savedUser);



    }

    @Override
    public Updatuser updateUser(Updatuser updateuser, String email) {

        User user = this.userRepo.findByEmail(email).orElseThrow(()-> new com.myprojects.blogging.exceptions.ResourceNotFoundException("email","email", email));

        user.setMobile(updateuser.getMobile());
        user.setFirstName(updateuser.getFirstName());
        user.setLastName(updateuser.getLastName());
        user.setPassword(updateuser.getPassword());

        User us = this.userRepo.save(user);

        Updatuser updateduser = new Updatuser();
        updateduser.setFirstName(us.getFirstName());
        updateduser.setLastName(us.getLastName());
        updateduser.setMobile(us.getMobile());
        updateduser.setPassword(us.getPassword());

        return updateduser;
    }

    private User DtotoUser(UserDto userdto)
    {

        User user = User.builder()
                .id(userdto.getId())
                .email(userdto.getEmail())
                .mobile(userdto.getMobile())
                .username(userdto.getUsername())
                .firstName(userdto.getFirstName())
                .lastName(userdto.getLastName())
                .password(userdto.getPassword())
                .build();

        return user;
    }

    public UserDto userToDto(User user)
    {

        UserDto userdto = UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .mobile(user.getMobile())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .build();

        return userdto;
    }
}
