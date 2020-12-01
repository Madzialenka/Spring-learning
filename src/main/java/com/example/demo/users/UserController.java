package com.example.demo.users;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(UserFilterDTO userFilterDTO){
        return userService.getUsers(userFilterDTO);
    }

    @PostMapping
    public User createUser(@RequestBody UserDataDTO userDataDTO){
        return userService.createUser(userDataDTO);
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody UserDataDTO userDataDTO){
        return userService.updateUser(id, userDataDTO);
    }

    @DeleteMapping("{id}")
    public User deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }
}
