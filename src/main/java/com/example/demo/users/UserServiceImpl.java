package com.example.demo.users;

import com.example.demo.customers.Gender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(1L, "Kamil", "kamil@example.com", LocalDate.of(1999, Month.SEPTEMBER, 15),
                    Gender.MALE),
            new User(2L, "Madzia", "madzia@example.com", LocalDate.of(1999, Month.MARCH, 15),
                    Gender.FEMALE),
            new User(3L, "Maria", "maria@example.com", LocalDate.of(2001, Month.JANUARY, 3),
                    Gender.FEMALE),
            new User(4L, "Karol", "karol@example.com", LocalDate.of(1994, Month.FEBRUARY, 28),
                    Gender.MALE),
            new User(5L, "Karolina", "karolina@example.com", LocalDate.of(1998, Month.DECEMBER, 24),
                    Gender.FEMALE)
    ));

    @Override
    public List<User> getUsers(UserFilterDTO userFilterDTO) {
         return users.stream()
                 .filter(user -> {
                     if (userFilterDTO.getName() != null) {
                         return user.getName().startsWith(userFilterDTO.getName());
                     }
                     return true;
                 })
                 .filter(user -> {
                     if (userFilterDTO.getGender() != null) {
                         return user.getGender().equals(userFilterDTO.getGender());
                     }
                     return true;
                 })
                 .collect(Collectors.toList());
    }

    @Override
    public User createUser(UserDataDTO userDataDTO) {
        Long id = users.stream()
                .map(User::getId)
                .max(Comparator.comparingLong(a -> a))
                .orElse(0L) + 1L;
        User user = new User(id, userDataDTO.getName(), userDataDTO.getEmail(), userDataDTO.getBirthday(),
                userDataDTO.getGender());
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(Long id, UserDataDTO userDataDTO) {
        User userToUpdate = getUserById(id);
        userToUpdate.setName(userDataDTO.getName());
        userToUpdate.setEmail(userDataDTO.getEmail());
        userToUpdate.setBirthday(userDataDTO.getBirthday());
        userToUpdate.setGender(userDataDTO.getGender());
        return userToUpdate;
    }

    @Override
    public User deleteUser(Long id) {
        User userToDelete = getUserById(id);
        users.remove(userToDelete);
        return userToDelete;
    }

    private User getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
}
