package com.example.demo.controller;

import com.example.demo.Service.EtalabService;
import com.example.demo.model.Address;
import com.example.demo.model.EtalabAdress;
import com.google.gson.Gson;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Controller
public class MeteoController {

    @Autowired
    private EtalabService etalabService;


    @PostMapping("/meteo")
    public String getMeteo(@RequestParam("adress") String adress){
        String inpuut=adress;
        return "meteo";
    }
    @GetMapping("/meteo")
    public String getEtalabMeteo(Model model){

        try {
            ArrayList<EtalabAdress> etalabAdresses=etalabService.getEtalabServicesFromUrl("https://api-adresse.data.gouv.fr/search/?q=20%20avenue%20de%20S%C3%A9gur%2C%20Paris&type=housenumber&autocomplete=1");
            model.addAttribute("EtalabAddresses",etalabAdresses);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "meteo";
    }
}
