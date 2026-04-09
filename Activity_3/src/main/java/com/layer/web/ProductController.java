package com.layer.web;

import com.layer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    //Injection des dépandances  
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


}
