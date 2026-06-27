package com.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Tema 2: Streams API
 * 
 * Los Streams representan una secuencia de elementos que soportan
 * operaciones funcionales como filter, map, reduce, etc.
 * Permiten procesamiento declarativo de colecciones.
 */
public class StreamsAPI {

    public static void main(String[] args) {
        System.out.println("=== 2. STREAMS API ===\n");

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> productos = Arrays.asList("Laptop", "Mouse", "Teclado", "Monitor", "Webcam");

        // 1. Filter - Filtrar elementos
        System.out.println("--- 2.1 Filter: Números pares ---");
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Pares: " + pares);

        // 2. Map - Transformar elementos
        System.out.println("\n--- 2.2 Map: Duplicar números ---");
        List<Integer> duplicados = numeros.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Duplicados: " + duplicados);

        // 3. Encadenamiento: Filter + Map
        System.out.println("\n--- 2.3 Filter + Map: Pares y al cuadrado ---");
        List<Integer> paresAlCuadrado = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Pares al cuadrado: " + paresAlCuadrado);

        // 4. ForEach - Iterar funcionalmente
        System.out.println("\n--- 2.4 ForEach: Imprimir productos ---");
        productos.stream()
                .forEach(p -> System.out.println("  • " + p));

        // 5. Sorted - Ordenar elementos
        System.out.println("\n--- 2.5 Sorted: Ordenar alfabéticamente ---");
        List<String> productosOrdenados = productos.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Ordenados: " + productosOrdenados);

        // 6. Sorted personalizado - Ordenar por longitud
        System.out.println("\n--- 2.6 Sorted personalizado: Por longitud ---");
        List<String> porLongitud = productos.stream()
                .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                .collect(Collectors.toList());
        System.out.println("Por longitud: " + porLongitud);

        // 7. Distinct - Eliminar duplicados
        System.out.println("\n--- 2.7 Distinct: Eliminar duplicados ---");
        List<Integer> conDuplicados = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        List<Integer> sinDuplicados = conDuplicados.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Sin duplicados: " + sinDuplicados);

        // 8. Count - Contar elementos
        System.out.println("\n--- 2.8 Count: Contar elementos ---");
        long cantidad = numeros.stream()
                .filter(n -> n > 5)
                .count();
        System.out.println("Números mayores a 5: " + cantidad);

        // 9. Collect - Diferentes colecciones
        System.out.println("\n--- 2.9 Collect a diferentes tipos ---");
        String productosJoin = productos.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Productos unidos: " + productosJoin);

        // 10. IntStream - Operaciones con números
        System.out.println("\n--- 2.10 IntStream: Operaciones numéricas ---");
        int suma = IntStream.rangeClosed(1, 10)
                .sum();
        System.out.println("Suma de 1 a 10: " + suma);

        // 11. Limit - Limitar resultados
        System.out.println("\n--- 2.11 Limit: Primeros 3 productos ---");
        productos.stream()
                .limit(3)
                .forEach(p -> System.out.println("  • " + p));

        // 12. Skip - Saltar elementos
        System.out.println("\n--- 2.12 Skip: Saltar primeros 2 productos ---");
        productos.stream()
                .skip(2)
                .forEach(p -> System.out.println("  • " + p));

        // 13. AllMatch, AnyMatch, NoneMatch
        System.out.println("\n--- 2.13 Match operations ---");
        boolean todosMayoresQueCero = numeros.stream()
                .allMatch(n -> n > 0);
        System.out.println("¿Todos mayores a 0? " + todosMayoresQueCero);

        boolean hayMayorA7 = numeros.stream()
                .anyMatch(n -> n > 7);
        System.out.println("¿Hay alguno mayor a 7? " + hayMayorA7);

        boolean ningunoMenorACero = numeros.stream()
                .noneMatch(n -> n < 0);
        System.out.println("¿Ninguno es menor a 0? " + ningunoMenorACero);
    }
}
