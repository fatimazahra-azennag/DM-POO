package com.example.demo.Service;

import com.example.demo.model.EtalabAdress;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class EtalabService {

    public ArrayList<EtalabAdress> getEtalabServicesFromUrl(String EtalabResourceUrl) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<EtalabAdress> etalabAdresses=new ArrayList<EtalabAdress>();
        String resultat = restTemplate
                .getForObject(EtalabResourceUrl, String.class);
        JSONObject resultatJson =new JSONObject(resultat);
        JSONArray resultatFeatures=resultatJson.getJSONArray("features");
        for(int i=0;i<resultatFeatures.length();i++){
            JSONObject JsonEtalabAdress=resultatFeatures.getJSONObject(i).getJSONObject("properties");
            Gson gson= new Gson();
            EtalabAdress etalabAdress=gson.fromJson(JsonEtalabAdress.toString(),EtalabAdress.class);
            etalabAdresses.add(etalabAdress);

        }
        return etalabAdresses;
    }
}
