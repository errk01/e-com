package com.tts.ecomspring.controller;

import com.tts.ecomspring.model.Product;
import com.tts.ecomspring.service.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Data
@Controller
@ControllerAdvice
public class MainController {

    @Autowired
    ProductService productService;

    @GetMapping(value="/")
    public String main(){
        return "main";
    }

    @ModelAttribute("products")
    public List<Product> products(){
        return productService.findAll();
    }

    public List<String> categories(){
        return productService.findDistinctCategory();
    }

    @ModelAttribute("brands")
    public List<String> brands(){
        return productService.findDistinctBrands();
    }
    @GetMapping(value = "/filter")
    public String filter(@RequestParam(required = false)
                                     String category, @RequestParam(required = false) String brand,
                         Model model){
        List<Product> filtered =productService.findByBrandAndCategory(brand, category);
//        List<Product> filtered =productService.findByBrandAndCategory(brand, category);
        model.addAttribute("products", filtered);
        return "main";
    }
    @GetMapping(value= "/about")
    public String about(){
        return "about";
    }
}
