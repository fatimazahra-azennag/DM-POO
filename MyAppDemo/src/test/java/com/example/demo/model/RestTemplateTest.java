package com.example.demo.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RestTemplateTest {
    @Test
   void testGet() throws JSONException {
        RestTemplate restTemplate = new RestTemplate();
        String EtalabResourceUrl
                = "https://api-adresse.data.gouv.fr/search/?q=20%20avenue%20de%20S%C3%A9gur%2C%20Paris&type=housenumber&autocomplete=1";
        String resultat = restTemplate
                .getForObject(EtalabResourceUrl, String.class);
        JSONObject resultatJson =new JSONObject(resultat);
        JSONArray resultatFeatures=resultatJson.getJSONArray("features");
        for(int i=0;i<resultatFeatures.length();i++){
            JSONObject JsonEtalabAdress=resultatFeatures.getJSONObject(i).getJSONObject("properties");
            Gson gson= new Gson();
            EtalabAdress etalabAdress=gson.fromJson(JsonEtalabAdress.toString(),EtalabAdress.class);

        }





    }
}