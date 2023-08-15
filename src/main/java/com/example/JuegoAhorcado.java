package com.example;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class JuegoAhorcado {

    // Atributos (caracteristicas)
    private List<String> listaDePalabras;
    private String palabraSecreta;
    private String palabraAdivinada;
    private Integer cantidadDeIntentos;
    private final Integer intentosDisponibles = 3;


    // Getters y Setters


    // Constructores


    // Metodos (comportamientos)
}
