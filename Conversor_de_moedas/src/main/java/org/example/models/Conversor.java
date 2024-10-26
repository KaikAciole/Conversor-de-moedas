package org.example.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.interfaces.MenuI;

import java.io.IOException;
import java.util.Timer;

public class Conversor {
    private String resultValue;
    private float conversionResult;
    private Gson gson;
    private String key, coins, amount;
    private Resquest request;

    public Conversor(String key){
        this.key = key;
        gson = new Gson();
    }

    public Conversor(ConversorRecord record){
        this.resultValue = record.result();
        this.conversionResult = record.conversion_result();
    }

    @Override
    public String toString() {
        return resultValue + ", Resultado= " + conversionResult + '}';
    }

    public void init(MenuI menuI){
        String resposta = menuI.mainMenu();

        while (!resposta.equals("7")){
            coins = menuI.getCoin(resposta);
            amount = menuI.amountMenu();

            request = new Resquest(key, coins, amount);

            String json = request.doResquest();
            ConversorRecord myConversor = gson.fromJson(json, ConversorRecord.class);
            Conversor convertedConversor = new Conversor(myConversor);
            System.out.println("\n=====> " + convertedConversor + "\n\n");

            try {
                // Espera por 2 segundos
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Deu ruim !!!!!!");
                e.printStackTrace();
            }
            resposta = menuI.mainMenu();
        }

    }
}