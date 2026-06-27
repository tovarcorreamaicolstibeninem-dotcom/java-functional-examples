package com.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Tema 1: Lambdas y Expresiones Funcionales
 * 
 * Las expresiones lambda son funciones anónimas que implementan
 * un método de una interfaz funcional. Simplifican la escritura
 * de código funcional en Java.
 */
public class Lambdas {

    public static void main(String[] args) {
        System.out.println("=== 1. LAMBDAS Y EXPRESIONES FUNCIONALES ===\n");

        // 1. Lambda básica con parámetros
        System.out.println("--- 1.1 Lambda con parámetros ---");
        Operacion suma = (a, b) -> a + b;
        System.out.println("Suma de 5 + 3 = " + suma.ejecutar(5, 3));

        // 2. Lambda con un solo parámetro
        System.out.println("\n--- 1.2 Lambda con un parámetro ---");
        Transformar duplicar = x -> x * 2;
        System.out.println("Duplicar 10 = " + duplicar.transformar(10));

        // 3. Lambda sin parámetros
        System.out.println("\n--- 1.3 Lambda sin parámetros ---");
        Saludo saludo = () -> "¡Hola, Bienvenido a Java Funcional!";
        System.out.println(saludo.saludar());

        // 4. Lambda con cuerpo de múltiples líneas
        System.out.println("\n--- 1.4 Lambda con múltiples líneas ---");
        Operacion multiplicar = (a, b) -> {
            int resultado = a * b;
            System.out.println("Multiplicando " + a + " × " + b);
            return resultado;
        };
        System.out.println("Resultado = " + multiplicar.ejecutar(4, 5));

        // 5. Lambda en forEach
        System.out.println("\n--- 1.5 Lambda en forEach ---");
        List<String> nombres = Arrays.asList("Ana", "Bruno", "Carlos", "Diana");
        System.out.println("Procesando nombres:");
        nombres.forEach(nombre -> System.out.println("  - " + nombre));

        // 6. Lambda con condicionales
        System.out.println("\n--- 1.6 Lambda con condicionales ---");
        Validador esPositivo = numero -> numero > 0;
        System.out.println("¿Es 15 positivo? " + esPositivo.validar(15));
        System.out.println("¿Es -5 positivo? " + esPositivo.validar(-5));

        // 7. Referencias a métodos
        System.out.println("\n--- 1.7 Referencias a métodos ---");
        List<String> palabras = Arrays.asList("java", "funcional", "ejemplos");
        System.out.println("Imprimiendo con referencia a método:");
        palabras.forEach(System.out::println);

        // 8. Lambda comparando
        System.out.println("\n--- 1.8 Lambda con comparación ---");
        Comparador maximo = (a, b) -> a > b ? a : b;
        System.out.println("Máximo entre 25 y 18 = " + maximo.comparar(25, 18));
    }

    // Interfaces Funcionales
    @FunctionalInterface
    interface Operacion {
        int ejecutar(int a, int b);
    }

    @FunctionalInterface
    interface Transformar {
        int transformar(int x);
    }

    @FunctionalInterface
    interface Saludo {
        String saludar();
    }

    @FunctionalInterface
    interface Validador {
        boolean validar(int numero);
    }

    @FunctionalInterface
    interface Comparador {
        int comparar(int a, int b);
    }
}
