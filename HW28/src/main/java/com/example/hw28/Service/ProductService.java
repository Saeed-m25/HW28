package com.example.hw28.Service;

import com.example.hw28.Model.Product;
import com.example.hw28.Model.User;
import com.example.hw28.Repository.ProductRepository;
import com.example.hw28.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }
    public void updateProduct(Integer id,Product product) {
        Product oldproduct = productRepository.findUsersById(id);
        if (oldproduct == null) {
            throw new RuntimeException();
        }
        oldproduct.setName(product.getName());
        oldproduct.setPrice(product.getPrice());

        productRepository.save(oldproduct);
    }
    public void deleteProduct(Integer id){
        Product oldproduct=productRepository.getById(id);
        if (oldproduct==null){
            throw new RuntimeException();
        }
        productRepository.delete(oldproduct);
    }


}
