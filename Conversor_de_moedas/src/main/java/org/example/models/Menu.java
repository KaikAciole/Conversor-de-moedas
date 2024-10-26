package org.example.models;

import org.example.interfaces.MenuI;

import java.util.Scanner;

public class Menu implements MenuI {
    private Scanner sc = new Scanner(System.in);

    public String mainMenu(){
        System.out.print("Seja bem vindo ao Conversor de moedas!!" +
                "\n\n1) Dólar --> Real" +
                "\n2) Real --> Dólar"+
                "\n3) Euro --> Dólar" +
                "\n4) Dólar --> Euro" +
                "\n5) Peso Argentino --> Real" +
                "\n6) Real --> Peso Argentino" +
                "\n7)(sair do conversor)!!" +
                "\nEscolha uma opção válida: ");
         return getResposta(sc);
    }

    public String getCoin(String resposta){
        return switch (resposta) {
            case "1" -> "USD/BRL";
            case "2" -> "BRL/USD";
            case "3" -> "EUR/USD";
            case "4" -> "USD/EUR";
            case "5" -> "ARS/BRL";
            case "6" -> "BRL/ARS";
            default -> "ERRO";
        };
    }

    public String amountMenu(){
        System.out.println("\nAgora diga quanto quer converter: ");
        return getResposta(sc);
    }

    private String getResposta(Scanner sc){
        return sc.nextLine();
    }


}
