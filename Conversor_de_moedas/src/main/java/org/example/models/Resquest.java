package org.example.models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Resquest {
    String endereco;

    public Resquest(String key, String coins, String amount){
        endereco = "https://v6.exchangerate-api.com/v6/" + key + "/pair/" + coins + "/" + amount;
    }

    public String doResquest() {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            return json;
        }catch (Exception e){
            System.out.println("Erro!!!!!!!");
            e.printStackTrace();
        }
        return "erro";
    }

}
