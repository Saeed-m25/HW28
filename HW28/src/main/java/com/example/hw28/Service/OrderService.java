package com.example.hw28.Service;

import com.example.hw28.Model.Order;
import com.example.hw28.Model.User;
import com.example.hw28.Repository.OrderRepository;
import com.example.hw28.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }
    public void updateOrder(Integer id,Order order) {
        Order oldorder = orderRepository.findUsersById(id);
        if (oldorder == null) {
            throw new RuntimeException();
        }
        oldorder.setQuantity(order.getQuantity());
        oldorder.setTotalPrice(order.getTotalPrice());

        orderRepository.save(oldorder);
    }
    public void deleteOrder(Integer id){
        Order oldorder=orderRepository.getById(id);
        if (oldorder==null){
            throw new RuntimeException();
        }
        orderRepository.delete(oldorder);
    }

}

