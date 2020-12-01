package com.example.demo.users;

import java.util.List;

public interface UserService {

    List<User> getUsers(UserFilterDTO userFilterDTO);

    User createUser(UserDataDTO userDataDTO);

    User updateUser(Long id, UserDataDTO userDataDTO);

    User deleteUser(Long id);
}
