package com.example;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List <String> palabrasElegidas = Arrays.asList("programacion", "computadora", "java", "desarrollo", "tecnologia");

        JuegoAhorcado juegoAhorcado = new JuegoAhorcado(palabrasElegidas);

        juegoAhorcado.jugar();
    }
}
