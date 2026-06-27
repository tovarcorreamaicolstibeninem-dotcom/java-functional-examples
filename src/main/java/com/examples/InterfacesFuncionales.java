package com.examples;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Tema 3: Interfaces Funcionales
 * 
 * Una interfaz funcional es aquella con un solo método abstracto.
 * Java proporciona interfaces funcionales predefinidas en java.util.function
 * También podemos crear las nuestras con @FunctionalInterface
 */
public class InterfacesFuncionales {

    public static void main(String[] args) {
        System.out.println("=== 3. INTERFACES FUNCIONALES ===\n");

        // 1. Function - Transforma entrada a salida
        System.out.println("--- 3.1 Function: Transformación ---");
        Function<Integer, Integer> cuadrado = x -> x * x;
        System.out.println("Cuadrado de 5: " + cuadrado.apply(5));
        System.out.println("Cuadrado de 8: " + cuadrado.apply(8));

        // 2. Predicate - Validación (devuelve boolean)
        System.out.println("\n--- 3.2 Predicate: Validación ---");
        Predicate<Integer> esPositivo = n -> n > 0;
        Predicate<String> esMayorA5Chars = s -> s.length() > 5;
        
        System.out.println("¿5 es positivo? " + esPositivo.test(5));
        System.out.println("¿-3 es positivo? " + esPositivo.test(-3));
        System.out.println("¿'Hola' tiene más de 5 caracteres? " + esMayorA5Chars.test("Hola"));
        System.out.println("¿'Programación' tiene más de 5 caracteres? " + esMayorA5Chars.test("Programación"));

        // 3. Consumer - Consume valores sin retornar
        System.out.println("\n--- 3.3 Consumer: Consumidor ---");
        Consumer<String> imprimirMayuscula = s -> System.out.println("  " + s.toUpperCase());
        imprimirMayuscula.accept("java funcional");
        imprimirMayuscula.accept("lambdas");
        imprimirMayuscula.accept("streams");

        // 4. Supplier - Proporciona valores sin recibir parámetros
        System.out.println("\n--- 3.4 Supplier: Proveedor ---");
        Supplier<Integer> numeroAleatorio = () -> (int) (Math.random() * 100);
        System.out.println("Número aleatorio 1: " + numeroAleatorio.get());
        System.out.println("Número aleatorio 2: " + numeroAleatorio.get());
        System.out.println("Número aleatorio 3: " + numeroAleatorio.get());

        // 5. BiFunction - Dos parámetros, devuelve un valor
        System.out.println("\n--- 3.5 BiFunction: Dos parámetros ---");
        java.util.function.BiFunction<Integer, Integer, Integer> suma = (a, b) -> a + b;
        System.out.println("Suma de 10 + 20 = " + suma.apply(10, 20));

        // 6. BiPredicate - Dos parámetros, devuelve boolean
        System.out.println("\n--- 3.6 BiPredicate: Dos parámetros con validación ---");
        java.util.function.BiPredicate<Integer, Integer> sonIguales = (a, b) -> a.equals(b);
        System.out.println("¿5 y 5 son iguales? " + sonIguales.test(5, 5));
        System.out.println("¿5 y 3 son iguales? " + sonIguales.test(5, 3));

        // 7. BiConsumer - Consume dos valores
        System.out.println("\n--- 3.7 BiConsumer: Consumidor con dos parámetros ---");
        java.util.function.BiConsumer<String, Integer> mostrarRepetido = 
            (palabra, veces) -> {
                for (int i = 0; i < veces; i++) {
                    System.out.print(palabra + " ");
                }
                System.out.println();
            };
        mostrarRepetido.accept("Java", 3);
        mostrarRepetido.accept("Funcional", 2);

        // 8. UnaryOperator - Transforma un tipo en el mismo tipo
        System.out.println("\n--- 3.8 UnaryOperator: Operación unaria ---");
        java.util.function.UnaryOperator<Integer> incrementar = x -> x + 1;
        System.out.println("Incrementar 9: " + incrementar.apply(9));
        System.out.println("Incrementar 99: " + incrementar.apply(99));

        // 9. BinaryOperator - Dos parámetros del mismo tipo
        System.out.println("\n--- 3.9 BinaryOperator: Operación binaria ---");
        java.util.function.BinaryOperator<Integer> maximo = (a, b) -> a > b ? a : b;
        System.out.println("Máximo entre 15 y 20: " + maximo.apply(15, 20));
        System.out.println("Máximo entre 50 y 30: " + maximo.apply(50, 30));

        // 10. Interfaz Funcional Personalizada
        System.out.println("\n--- 3.10 Interfaz Funcional Personalizada ---");
        Calculadora restar = (a, b) -> a - b;
        Calculadora multiplicar = (a, b) -> a * b;
        Calculadora dividir = (a, b) -> a / b;

        System.out.println("10 - 3 = " + restar.calcular(10, 3));
        System.out.println("10 × 3 = " + multiplicar.calcular(10, 3));
        System.out.println("10 ÷ 3 = " + dividir.calcular(10, 3));

        // 11. Composición de Predicados
        System.out.println("\n--- 3.11 Composición de Predicados ---");
        Predicate<Integer> esPar = n -> n % 2 == 0;
        Predicate<Integer> esMayorA5 = n -> n > 5;
        
        Predicate<Integer> esParYMayorA5 = esPar.and(esMayorA5);
        Predicate<Integer> esParOmalYorA5 = esPar.or(esMayorA5);
        Predicate<Integer> noEsPar = esPar.negate();

        System.out.println("¿8 es par Y mayor a 5? " + esParYMayorA5.test(8));
        System.out.println("¿3 es par Y mayor a 5? " + esParYMayorA5.test(3));
        System.out.println("¿3 es par O mayor a 5? " + esParOmalYorA5.test(3));
        System.out.println("¿5 no es par? " + noEsPar.test(5));
    }

    // Interfaz Funcional Personalizada
    @FunctionalInterface
    interface Calculadora {
        int calcular(int a, int b);
    }
}
