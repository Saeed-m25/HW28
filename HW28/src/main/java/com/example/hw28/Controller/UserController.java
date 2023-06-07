package com.example.hw28.Controller;


import com.example.hw28.Model.User;
import com.example.hw28.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {



    private final UserService userService;


    @GetMapping("/get")
    public ResponseEntity getAllUser() {
        return ResponseEntity.status(200).body(userService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.status(200).body("user added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody User user,@PathVariable Integer id){
        userService.updateUser(id,user);
        return ResponseEntity.status(200).body("user update");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("User deleted");


    }
}
