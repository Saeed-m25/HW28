package com.example.hw28.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Setter
@Getter
public class User {
//    id - username - password - role


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private Integer password;
    private String role;


    @OneToMany(cascade = CascadeType.ALL ,mappedBy ="User")
    private Set<Order> orderSet;


}
