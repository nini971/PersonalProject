package com.example.appville.model;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by Nicolas Th on 29/05/2017.
 */

public class AppVilleWS {
    private static final String URL = "https://data.toulouse-metropole.fr/api/records/1.0/search/?dataset=agenda-des-manifestations-culturelles-so-toulouse&facet=type_de_manifestation";
    private static final Gson gson = new Gson();

    public static ArrayList<Fields> getFieldServ() throws Exception {
        String reponse = OkHttpUtils.sendGetOkHttpRequest(URL);
        Resultat resultat = gson.fromJson(reponse, Resultat.class);
        ArrayList<Fields> fields = new ArrayList<>();
        if (resultat == null) {
            throw new Exception("Variable list à null");
        } else if (resultat.getRecords() != null) {
            for (Records records : resultat.getRecords()) {
                if (records.getFields() != null) {
                    fields.add(records.getFields());
                }
            }
        }
        return fields;

    }
}
