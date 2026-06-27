package com.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Tema 5: Optional - Manejo de Nulidad
 * 
 * Optional es un contenedor que puede o no contener un valor no-nulo.
 * Proporciona una forma funcional y segura de evitar NullPointerException.
 */
public class OptionalManejo {

    public static void main(String[] args) {
        System.out.println("=== 5. OPTIONAL - MANEJO DE NULIDAD ===\n");

        // 1. Crear Optional.of() - Valor presente
        System.out.println("--- 5.1 Optional.of() ---");
        Optional<String> nombre = Optional.of("Juan");
        System.out.println("Nombre presente: " + nombre.isPresent());
        System.out.println("Valor: " + nombre.get());

        // 2. Optional.empty() - Sin valor
        System.out.println("\n--- 5.2 Optional.empty() ---");
        Optional<String> vacio = Optional.empty();
        System.out.println("¿Está presente? " + vacio.isPresent());
        System.out.println("¿Está vacío? " + vacio.isEmpty());

        // 3. Optional.ofNullable() - Puede ser nulo
        System.out.println("\n--- 5.3 Optional.ofNullable() ---");
        String valor = null;
        Optional<String> opcional = Optional.ofNullable(valor);
        System.out.println("De nulo: " + opcional.isPresent());
        
        valor = "No es nulo";
        opcional = Optional.ofNullable(valor);
        System.out.println("De valor: " + opcional.isPresent());

        // 4. orElse() - Valor por defecto
        System.out.println("\n--- 5.4 orElse(): Valor por defecto ---");
        Optional<String> apellido = Optional.empty();
        String resultadoApellido = apellido.orElse("Desconocido");
        System.out.println("Apellido: " + resultadoApellido);

        // 5. orElseGet() - Proveedor de valor
        System.out.println("\n--- 5.5 orElseGet(): Supplier ---");
        Optional<String> ciudad = Optional.empty();
        String resultadoCiudad = ciudad.orElseGet(() -> generarCiudadPorDefecto());
        System.out.println("Ciudad: " + resultadoCiudad);

        // 6. orElseThrow() - Lanzar excepción
        System.out.println("\n--- 5.6 orElseThrow(): Lanzar excepción ---");
        Optional<String> email = Optional.empty();
        try {
            String resultadoEmail = email.orElseThrow(() -> 
                new IllegalArgumentException("Email no puede estar vacío"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        // 7. ifPresent() - Ejecutar si está presente
        System.out.println("\n--- 5.7 ifPresent(): Ejecutar si existe ---");
        Optional<String> telefono = Optional.of("123456789");
        telefono.ifPresent(t -> System.out.println("Teléfono encontrado: " + t));

        // 8. ifPresentOrElse() - Bifurcación
        System.out.println("\n--- 5.8 ifPresentOrElse(): Bifurcación ---");
        Optional<String> documento = Optional.empty();
        documento.ifPresentOrElse(
            d -> System.out.println("Documento: " + d),
            () -> System.out.println("Documento no proporcionado")
        );

        // 9. map() - Transformar valor
        System.out.println("\n--- 5.9 map(): Transformación ---");
        Optional<String> empresa = Optional.of("TechCorp");
        Optional<String> empresaMayuscula = empresa.map(String::toUpperCase);
        System.out.println("Empresa original: " + empresa.get());
        System.out.println("Empresa en mayúscula: " + empresaMayuscula.get());

        // 10. map() con cálculos
        System.out.println("\n--- 5.10 map(): Con cálculos ---");
        Optional<Integer> edad = Optional.of(25);
        Optional<Integer> edadEnOtros10Annos = edad.map(e -> e + 10);
        System.out.println("Edad actual: " + edad.get());
        System.out.println("Edad en 10 años: " + edadEnOtros10Annos.get());

        // 11. flatMap() - Map anidado
        System.out.println("\n--- 5.11 flatMap(): Para Optionals anidados ---");
        Optional<Persona> persona = Optional.of(new Persona("Carlos", "España"));
        Optional<String> pais = persona
                .flatMap(p -> Optional.ofNullable(p.pais));
        System.out.println("País: " + pais.orElse("No especificado"));

        // 12. filter() - Validar
        System.out.println("\n--- 5.12 filter(): Validación ---");
        Optional<Integer> numero = Optional.of(15);
        Optional<Integer> numeroMayorA10 = numero
                .filter(n -> n > 10);
        System.out.println("¿15 > 10? " + numeroMayorA10.isPresent());

        numero = Optional.of(5);
        numeroMayorA10 = numero.filter(n -> n > 10);
        System.out.println("¿5 > 10? " + numeroMayorA10.isPresent());

        // 13. Encadenamiento de operaciones
        System.out.println("\n--- 5.13 Encadenamiento completo ---");
        Optional<String> email2 = Optional.of("usuario@example.com");
        String dominio = email2
                .filter(e -> e.contains("@"))
                .map(e -> e.substring(e.indexOf("@") + 1))
                .map(String::toUpperCase)
                .orElse("DOMINIO DESCONOCIDO");
        System.out.println("Dominio de email: " + dominio);

        // 14. Working with Streams y Optional
        System.out.println("\n--- 5.14 Streams y Optional ---");
        List<String> nombres2 = Arrays.asList("Ana", "Bruno", "Carlos", "Diana");
        Optional<String> primerNombreLargo = nombres2.stream()
                .filter(n -> n.length() > 4)
                .findFirst();
        System.out.println("Primer nombre con más de 4 caracteres: " 
                + primerNombreLargo.orElse("No encontrado"));

        // 15. Valor seguro con Optional
        System.out.println("\n--- 5.15 Caso de uso real: Usuario ---");
        Usuario usuario1 = new Usuario("John", Optional.of("john@mail.com"));
        Usuario usuario2 = new Usuario("Jane", Optional.empty());
        
        mostrarInfoUsuario(usuario1);
        mostrarInfoUsuario(usuario2);
    }

    static String generarCiudadPorDefecto() {
        return "Ciudad Desconocida";
    }

    static void mostrarInfoUsuario(Usuario usuario) {
        System.out.println("Nombre: " + usuario.nombre);
        System.out.println("Email: " + usuario.email
                .map(e -> e)
                .orElse("No proporcionado"));
        System.out.println("---");
    }

    static class Persona {
        String nombre;
        String pais;

        Persona(String nombre, String pais) {
            this.nombre = nombre;
            this.pais = pais;
        }
    }

    static class Usuario {
        String nombre;
        Optional<String> email;

        Usuario(String nombre, Optional<String> email) {
            this.nombre = nombre;
            this.email = email;
        }
    }
}
