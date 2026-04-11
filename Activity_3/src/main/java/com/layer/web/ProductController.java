package com.layer.web;

import com.layer.entity.Product;
import com.layer.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    //Injection des dépandances  
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/user/index")
    @PreAuthorize("hasRole('USER')")
    public String index(Model model) {
        List<Product> product = productRepository.findAll();
        model.addAttribute("listproducts" , product);
        //Forwared vers la vue
        return "products";
    }

    @GetMapping("/")
    public String home(Model model) {
        return "redirect:/user/index";
    }

    @PostMapping("/admin/deletProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@RequestParam(name = "id") Long id){
        productRepository.deleteById(id);
        //Redirection vers /index
        return "redirect:/user/index";
    }

    @GetMapping("/admin/newProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "new-product";
    }

    @PostMapping("/admin/saveProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) return "new-product";
        productRepository.save(product);
        return "redirect:/admin/newProduct";
    }

    @GetMapping("/noAuthorized")
    public String noAuthorized(){
        return "noAuthorized";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


}
