package com.example.hw28.Service;

import com.example.hw28.Model.User;
import com.example.hw28.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
    public void updateUser(Integer id,User user) {
        User olduser = userRepository.findUsersById(id);
        if (olduser == null) {
            throw new RuntimeException();
        }
        olduser.setUsername(user.getUsername());
        olduser.setPassword(user.getPassword());

        userRepository.save(olduser);
    }
    public void deleteUser(Integer id){
        User olduser=userRepository.getById(id);
        if (olduser==null){
            throw new RuntimeException();
        }
        userRepository.delete(olduser);
    }

}
