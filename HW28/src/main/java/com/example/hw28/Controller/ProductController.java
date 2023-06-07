package com.example.hw28.Controller;


import com.example.hw28.Model.Product;
import com.example.hw28.Model.User;
import com.example.hw28.Service.ProductService;
import com.example.hw28.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {



    private final ProductService productService;


    @GetMapping("/get")
    public ResponseEntity getAllProduct() {
        return ResponseEntity.status(200).body(productService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product){
        productService.addProduct(product);
        return ResponseEntity.status(200).body("product added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@Valid @RequestBody Product product,@PathVariable Integer id){
        productService.updateProduct(id,product);
        return ResponseEntity.status(200).body("product update");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(200).body("product deleted");


    }

}
