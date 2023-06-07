package com.example.hw28.Controller;


import com.example.hw28.Model.Order;
import com.example.hw28.Model.User;
import com.example.hw28.Repository.OrderRepository;
import com.example.hw28.Service.OrderService;
import com.example.hw28.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {



    private final OrderService orderService;


    @GetMapping("/get")
    public ResponseEntity getAllUser() {
        return ResponseEntity.status(200).body(orderService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity addOrder(@Valid @RequestBody Order order){
        orderService.addOrder(order);
        return ResponseEntity.status(200).body("order added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@Valid @RequestBody Order order,@PathVariable Integer id){
        orderService.updateOrder(id,order);
        return ResponseEntity.status(200).body("order update");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return ResponseEntity.status(200).body("order deleted");


    }
}

