package com.login.cashrich.services;

import com.login.cashrich.payloads.Updatuser;
import com.login.cashrich.payloads.UserDto;

public interface UserService {

    UserDto createUser(UserDto user);

    Updatuser updateUser(Updatuser updateuser, String email);


}
