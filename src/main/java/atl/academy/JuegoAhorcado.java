package atl.academy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Scanner;

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
    public boolean setListaDePalabras(List<String> listaDePalabras) {

        boolean palabrasVerificadas = verificarListaDePalabras(listaDePalabras);

        if (palabrasVerificadas) {
            this.listaDePalabras = listaDePalabras;
        } else {
            System.out.println("Error al cargar la palabra");
        }
        return palabrasVerificadas;
    }

    public void setPalabraSecreta(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
        this.palabraAdivinada = ocultarPalabra(palabraSecreta);
    }

    public boolean setIntentosDisponibles(Integer cantidadDeIntentos) {
        if (cantidadDeIntentos < intentosDisponibles){
            this.cantidadDeIntentos = cantidadDeIntentos;
            return true;
        } else {
            System.out.println("No se puede ingresar mas de " + intentosDisponibles + " intentos.");
            return false;
        }
    }


    // Constructores
    public JuegoAhorcado(List<String> listaDePalabras) {
        this.listaDePalabras = listaDePalabras;
        this.cantidadDeIntentos = intentosDisponibles;
        this.palabraSecreta = listaDePalabras.get((int) (Math.random() * listaDePalabras.size()));
        this.palabraAdivinada = ocultarPalabra(palabraSecreta);
    }

    public JuegoAhorcado(List<String> listaDePalabras, Integer cantidadDeIntentos) {
        this(listaDePalabras);
        this.cantidadDeIntentos = cantidadDeIntentos;

    }


    // Metodos (comportamientos)
    public void jugar () {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa una letra: ");

        while (getCantidadDeIntentos() > 0) {
            System.out.println("\nPalabra adivinada: " + palabraAdivinada);
            System.out.println("Intentos restantes: " + cantidadDeIntentos);
            System.out.print("Ingresa una letra: ");
            String palabraAdivinadaActual = verificarLetra (teclado.next().charAt(0));

            if (!palabraAdivinada.equals(palabraAdivinadaActual)) {

                palabraAdivinada = palabraAdivinadaActual;

                if (seAdivinoLaPalabra()) {
                    System.out.println("Felicitaciones! Has adivinado la palabra: " + palabraSecreta);
                    break;
                }
            } else {
                cantidadDeIntentos--;
                System.out.println("Letra incorrecta!");
            }
        }

        if (getCantidadDeIntentos() == 0) {
            System.out.println("Te quedaste sin intentos. La palabra era: " + palabraSecreta);
        }
    }



    static String ocultarPalabra(String palabraSecreta) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            sb.append("_");
        }
        return sb.toString();
    }

    public String verificarLetra(char letra) {

        var caracteresDePalabraAdivinada = palabraAdivinada.toCharArray();

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                caracteresDePalabraAdivinada[i] = letra;
            }
        }

        return new String(caracteresDePalabraAdivinada);
    }

    public boolean seAdivinoLaPalabra () {
        return palabraAdivinada.equals(palabraSecreta);
    }

    private boolean verificarListaDePalabras(List<String> listaDePalabras) {
        for (var p : listaDePalabras) {
            if (p.contains(" ")) {
                return false;
            }
        }
        return true;
    }
}
