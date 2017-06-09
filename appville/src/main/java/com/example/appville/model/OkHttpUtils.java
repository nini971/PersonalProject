package com.example.appville.model;

import java.net.HttpURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Nicolas Th on 29/05/2017.
 */

public class OkHttpUtils {
    public static String sendGetOkHttpRequest(String url) throws Exception {
        OkHttpClient client = new OkHttpClient();
        // Création de la requete
        Request request = new Request.Builder().url(url).build();
        // Execution de la requête
        Response response = client.newCall(request).execute();
        // Analyse du code retour
        if (response.code() != HttpURLConnection.HTTP_OK) {
            throw new Exception("Réponse du serveur incorrect : " + response.code());
        } else {
            // Résultat de la requete.
            return response.body().string();
        }
    }
}
