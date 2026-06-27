package com.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Tema 4: Composición de Funciones
 * 
 * La composición permite combinar funciones para crear pipelines
 * de transformación. Métodos como andThen() y compose() permiten
 * encadenar múltiples operaciones.
 */
public class ComposicionFunciones {

    public static void main(String[] args) {
        System.out.println("=== 4. COMPOSICIÓN DE FUNCIONES ===\n");

        // 1. andThen - Ejecutar funciones en secuencia
        System.out.println("--- 4.1 andThen: Encadenar operaciones ---");
        Function<Integer, Integer> multiplicarPor2 = x -> {
            System.out.println("  Paso 1: Multiplicar " + x + " × 2");
            return x * 2;
        };
        Function<Integer, Integer> sumar10 = x -> {
            System.out.println("  Paso 2: Sumar " + x + " + 10");
            return x + 10;
        };
        
        Function<Integer, Integer> operacion1 = multiplicarPor2.andThen(sumar10);
        System.out.println("Resultado: " + operacion1.apply(5) + "\n");

        // 2. compose - Invertir el orden de composición
        System.out.println("--- 4.2 compose: Invertir orden ---");
        Function<Integer, Integer> operacion2 = sumar10.compose(multiplicarPor2);
        System.out.println("Resultado de compose: " + operacion2.apply(5) + "\n");

        // 3. Pipeline de transformaciones
        System.out.println("--- 4.3 Pipeline de transformaciones ---");
        Function<String, String> mayuscula = s -> {
            System.out.println("  Paso 1: Convertir a mayúsculas: " + s);
            return s.toUpperCase();
        };
        Function<String, String> agregarExclamacion = s -> {
            System.out.println("  Paso 2: Agregar exclamación: " + s);
            return s + "!!!";
        };
        Function<String, Integer> contar = s -> {
            System.out.println("  Paso 3: Contar caracteres: " + s);
            return s.length();
        };
        
        Function<String, String> etapa1 = mayuscula.andThen(agregarExclamacion);
        int resultado = etapa1.andThen(contar).apply("java");
        System.out.println("Cantidad de caracteres: " + resultado + "\n");

        // 4. Composición con Numbers
        System.out.println("--- 4.4 Composición con números ---");
        Function<Double, Double> raizCuadrada = Math::sqrt;
        Function<Double, Double> duplicar = x -> x * 2;
        Function<Double, Double> redondear = x -> Math.round(x * 100.0) / 100.0;
        
        Function<Double, Double> combinada = raizCuadrada
                .andThen(duplicar)
                .andThen(redondear);
        
        System.out.println("√16 × 2 redondeado = " + combinada.apply(16.0) + "\n");

        // 5. Composición de Predicados (Funciones booleanas)
        System.out.println("--- 4.5 Composición de validaciones ---");
        java.util.function.Predicate<String> noEstaVacio = s -> !s.isEmpty();
        java.util.function.Predicate<String> tieneAlMenos3Chars = s -> s.length() >= 3;
        java.util.function.Predicate<String> esAlfabetico = s -> s.matches("[a-zA-Z]+");
        
        java.util.function.Predicate<String> validador = noEstaVacio
                .and(tieneAlMenos3Chars)
                .and(esAlfabetico);
        
        String[] palabras = {"", "ab", "java", "123", "Funcional"};
        for (String palabra : palabras) {
            System.out.println("¿'" + palabra + "' es válida? " + validador.test(palabra));
        }
        System.out.println();

        // 6. Builder Pattern con Funciones
        System.out.println("--- 4.6 Builder Pattern Funcional ---");
        Function<Persona, String> generarReporte = persona -> 
            persona.nombre + " (" + persona.edad + " años) - " + persona.ciudad;
        
        Function<Persona, String> agregarEstatus = reporte -> reporte + " ✓";
        
        Persona persona = new Persona("María", 28, "Madrid");
        System.out.println(generarReporte.andThen(agregarEstatus).apply(persona) + "\n");

        // 7. Pipeline de transformación de texto
        System.out.println("--- 4.7 Pipeline de transformación de texto ---");
        Function<String, String> limpiar = String::trim;
        Function<String, String> minusculas = String::toLowerCase;
        Function<String, String> reemplazarEspacios = s -> s.replace(" ", "_");
        
        Function<String, String> procesarTexto = limpiar
                .andThen(minusculas)
                .andThen(reemplazarEspacios);
        
        System.out.println("Original: '  JAVA FUNCIONAL  '");
        System.out.println("Procesado: '" + procesarTexto.apply("  JAVA FUNCIONAL  ") + "'\n");

        // 8. Composición con listas
        System.out.println("--- 4.8 Transformación de colecciones ---");
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        
        Function<List<Integer>, List<Integer>> duplicarElementos = lista ->
            lista.stream().map(n -> n * 2).collect(java.util.stream.Collectors.toList());
        
        Function<List<Integer>, List<Integer>> filtrarPares = lista ->
            lista.stream().filter(n -> n % 2 == 0).collect(java.util.stream.Collectors.toList());
        
        Function<List<Integer>, Integer> sumarTodos = lista ->
            lista.stream().reduce(0, Integer::sum);
        
        List<Integer> resultado2 = duplicarElementos
                .andThen(filtrarPares)
                .apply(numeros);
        System.out.println("Números: " + numeros);
        System.out.println("Duplicar y filtrar pares: " + resultado2);
        System.out.println("Suma total: " + sumarTodos.apply(resultado2) + "\n");

        // 9. Referencia de método en composición
        System.out.println("--- 4.9 Referencias de método ---");
        Function<String, Integer> convertirAInt = Integer::parseInt;
        Function<Integer, Integer> elevarAlCuadrado = x -> x * x;
        Function<Integer, String> convertirAString = String::valueOf;
        
        Function<String, String> procesarNumero = convertirAInt
                .andThen(elevarAlCuadrado)
                .andThen(convertirAString);
        
        System.out.println("String '5' → Int → Cuadrado → String = '" + procesarNumero.apply("5") + "'");
    }

    static class Persona {
        String nombre;
        int edad;
        String ciudad;

        Persona(String nombre, int edad, String ciudad) {
            this.nombre = nombre;
            this.edad = edad;
            this.ciudad = ciudad;
        }
    }
}
