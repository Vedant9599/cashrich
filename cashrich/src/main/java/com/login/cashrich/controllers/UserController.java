package com.login.cashrich.controllers;


import com.login.cashrich.payloads.Updatuser;
import com.login.cashrich.payloads.UserDto;
import com.login.cashrich.services.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        log.info("i have received this data {}",userDto.getUsername().toString());
        UserDto createuserdto = this.userService.createUser(userDto);

        return new ResponseEntity<>(createuserdto, HttpStatus.CREATED) ;

    }

    @PutMapping("/{username}")
    public ResponseEntity<Updatuser> updateUser(@Valid @RequestBody Updatuser updateuser, @PathVariable String email){
        Updatuser updateduser = this.userService.updateUser(updateuser, email);
        return ResponseEntity.ok(updateduser);
    }
}
