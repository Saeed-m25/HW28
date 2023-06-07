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
public class Product {
//    id - name - price


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;


    @OneToMany(cascade = CascadeType.ALL ,mappedBy ="Product")
    private Set<Order> orderSet;

}
