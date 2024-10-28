package org.example;

import org.example.models.Conversor;
import org.example.models.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Conversor conversor = new Conversor("your-key-example:123456789");

        Menu menu = new Menu();
        conversor.init(menu);
    }
}