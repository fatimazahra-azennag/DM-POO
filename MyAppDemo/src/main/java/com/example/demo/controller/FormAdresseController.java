package com.example.demo.controller;

import com.example.demo.model.Address;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FormAdresseController {
    @GetMapping("/Adresse")
    public String getMeteo(Model model){
        model.addAttribute("address", new Address());

        return "Adresse";
    }
}
