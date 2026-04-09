package com.layer.web;

import com.layer.entity.Product;
import com.layer.repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    //Injection des dépandances  
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Product> product = productRepository.findAll();
        model.addAttribute("listproducts" , product);
        //Forwared vers la vue
        return "products";
    }

    @GetMapping("/deletProduct")
    public String delete(@RequestParam(name = "id") Long id){
        productRepository.deleteById(id);
        //Redirection vers /index
        return "redirect:/index";
    }

}
