package org.example.service.user;

import org.example.base.service.BaseService;
import org.example.model.Users;

public interface UserService extends BaseService<Users,Long> {

    void signUpUsers(Users users);
    Users findByUserName(String username);

}
