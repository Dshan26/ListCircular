package principal;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\n\t\tLista circular UMB\n");

        System.out.print("Ingrese el tamaño de la lista circular: ");
        int tamano = scanner.nextInt();

        ListaCircular lista = new ListaCircular();
        // Generar un número aleatorio entre 0 y 99
        IntStream.range(0, tamano).map(i -> random.nextInt(100)).forEachOrdered(lista::agregar);

        System.out.println("La lista circular Ordenada es:");
        lista.imprimir();
    }
}
