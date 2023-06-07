package com.example.hw28.Service;

import com.example.hw28.Model.User;
import com.example.hw28.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final AuthRepository authRepository;

    public List<User> getAllUser() {

        return authRepository.findAll();
    }


    public void register(User user) {
        String hash = new BCryptPasswordEncoder().encode(User.getPassword());
        user.setPassword(Integer.valueOf(hash));
        user.setRole("USER");
        authRepository.save(user);
    }
}
