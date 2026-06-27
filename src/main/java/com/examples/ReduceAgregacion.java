package com.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Tema 6: Reduce y Agregación
 * 
 * La operación reduce() agrega elementos de un stream en un único valor.
 * Permite realizar operaciones como suma, producto, concatenación, etc.
 */
public class ReduceAgregacion {

    public static void main(String[] args) {
        System.out.println("=== 6. REDUCE Y AGREGACIÓN ===\n");

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> palabras = Arrays.asList("Java", "Funcional", "Ejemplos", "Streams");

        // 1. Reduce básico - Suma
        System.out.println("--- 6.1 Reduce: Suma simple ---");
        int suma = numeros.stream()
                .reduce(0, (acumulador, actual) -> {
                    System.out.println("  Acumulador: " + acumulador + " + Actual: " + actual);
                    return acumulador + actual;
                });
        System.out.println("Suma total: " + suma + "\n");

        // 2. Reduce sin valor inicial
        System.out.println("--- 6.2 Reduce: Sin valor inicial ---");
        java.util.Optional<Integer> sumaOpcional = numeros.stream()
                .reduce((acumulador, actual) -> acumulador + actual);
        System.out.println("Suma (Optional): " + sumaOpcional.orElse(0) + "\n");

        // 3. Reduce - Multiplicación
        System.out.println("--- 6.3 Reduce: Multiplicación ---");
        int producto = numeros.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Producto: " + producto + "\n");

        // 4. Reduce - Máximo
        System.out.println("--- 6.4 Reduce: Encontrar máximo ---");
        int maximo = numeros.stream()
                .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        System.out.println("Máximo: " + maximo + "\n");

        // 5. Reduce - Mínimo
        System.out.println("--- 6.5 Reduce: Encontrar mínimo ---");
        int minimo = numeros.stream()
                .reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
        System.out.println("Mínimo: " + minimo + "\n");

        // 6. Reduce - Concatenación de strings
        System.out.println("--- 6.6 Reduce: Concatenar strings ---");
        String concatenado = palabras.stream()
                .reduce("", (acumulador, actual) -> acumulador + " " + actual);
        System.out.println("Concatenado: " + concatenado + "\n");

        // 7. Reduce - Unión con separador
        System.out.println("--- 6.7 Reduce: Unión con separador ---");
        String union = palabras.stream()
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        System.out.println("Unión: " + union + "\n");

        // 8. Reduce con objetos
        System.out.println("--- 6.8 Reduce: Con objetos custom ---");
        List<Producto> productos = Arrays.asList(
                new Producto("Laptop", 1000),
                new Producto("Mouse", 25),
                new Producto("Teclado", 75),
                new Producto("Monitor", 300)
        );

        Producto productoAgregado = productos.stream()
                .reduce(new Producto("Total", 0),
                    (total, actual) -> new Producto(total.nombre + " + " + actual.nombre, 
                                                    total.precio + actual.precio)
                );
        System.out.println("Precio total: $" + productoAgregado.precio + "\n");

        // 9. IntStream - sum()
        System.out.println("--- 6.9 IntStream: sum() ---");
        int sumaIntStream = IntStream.rangeClosed(1, 100)
                .sum();
        System.out.println("Suma de 1 a 100: " + sumaIntStream + "\n");

        // 10. IntStream - average()
        System.out.println("--- 6.10 IntStream: average() ---");
        double promedio = numeros.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        System.out.println("Promedio: " + promedio + "\n");

        // 11. Stream - count()
        System.out.println("--- 6.11 Stream: count() ---");
        long cantidad = numeros.stream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("Cantidad de pares: " + cantidad + "\n");

        // 12. Reduce personalizado - Estadísticas
        System.out.println("--- 6.12 Reduce: Estadísticas ---");
        Estadisticas stats = numeros.stream()
                .reduce(new Estadisticas(),
                    (acc, valor) -> {
                        acc.suma += valor;
                        acc.cantidad++;
                        acc.maximo = Math.max(acc.maximo, valor);
                        acc.minimo = Math.min(acc.minimo, valor);
                        return acc;
                    },
                    (acc1, acc2) -> acc1  // Combinar si es paralelo
                );
        System.out.println("Suma: " + stats.suma);
        System.out.println("Cantidad: " + stats.cantidad);
        System.out.println("Promedio: " + (stats.suma / (double) stats.cantidad));
        System.out.println("Máximo: " + stats.maximo);
        System.out.println("Mínimo: " + stats.minimo + "\n");

        // 13. Reduce - Forma reducida (Integer.sum)
        System.out.println("--- 6.13 Reduce: Usando referencias de métodos ---");
        int sumaRedonda = numeros.stream()
                .reduce(0, Integer::sum);
        System.out.println("Suma con Integer::sum: " + sumaRedonda + "\n");

        // 14. Reduce con filter
        System.out.println("--- 6.14 Reduce: Con filter ---");
        int sumaPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Suma de pares: " + sumaPares + "\n");

        // 15. Reduce - Crear colección
        System.out.println("--- 6.15 Reduce: Crear colección ---");
        List<Integer> copia = numeros.stream()
                .reduce(new java.util.ArrayList<Integer>(),
                    (lista, valor) -> {
                        lista.add(valor);
                        return lista;
                    },
                    (l1, l2) -> {
                        l1.addAll(l2);
                        return l1;
                    }
                );
        System.out.println("Copia de lista: " + copia);
    }

    static class Producto {
        String nombre;
        int precio;

        Producto(String nombre, int precio) {
            this.nombre = nombre;
            this.precio = precio;
        }
    }

    static class Estadisticas {
        int suma = 0;
        int cantidad = 0;
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
    }
}
