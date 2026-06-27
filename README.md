# Java - Ejemplos Funcionales 🚀

Repositorio con ejemplos prácticos de **programación funcional en Java** explorando 5+ temas clave.

## 📋 Temas Investigados

### 1. **Lambdas y Expresiones Funcionales**
Introducción a las expresiones lambda y cómo simplificar el código funcional.
- Archivo: `src/main/java/com/examples/Lambdas.java`

### 2. **Streams API**
Procesamiento de colecciones de datos de forma declarativa y funcional.
- Archivo: `src/main/java/com/examples/StreamsAPI.java`

### 3. **Interfaces Funcionales**
Creación y uso de interfaces funcionales personalizadas con `@FunctionalInterface`.
- Archivo: `src/main/java/com/examples/InterfacesFuncionales.java`

### 4. **Composición de Funciones**
Técnicas para componer funciones y crear pipelines de procesamiento.
- Archivo: `src/main/java/com/examples/ComposicionFunciones.java`

### 5. **Optional - Manejo de Nulidad**
Uso de `Optional` para evitar `NullPointerException` de forma funcional.
- Archivo: `src/main/java/com/examples/OptionalManejo.java`

### 6. **Reduce y Agregación**
Operaciones de agregación y acumulación con `reduce()`.
- Archivo: `src/main/java/com/examples/ReduceAgregacion.java`

---

## 🎯 Estructura del Proyecto

```
java-functional-examples/
├── README.md
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── examples/
│   │               ├── Lambdas.java
│   │               ├── StreamsAPI.java
│   │               ├── InterfacesFuncionales.java
│   │               ├── ComposicionFunciones.java
│   │               ├── OptionalManejo.java
│   │               └── ReduceAgregacion.java
│   └── test/
│       └── java/
│           └── com/
│               └── examples/
│                   └── FunctionalExamplesTest.java
└── pom.xml
```

---

## 📚 Descripción de Ejemplos

### 1️⃣ **Lambdas.java**
Ejemplos básicos de expresiones lambda:
- Lambdas con parámetros
- Lambdas sin parámetros
- Referencias a métodos
- Ciclos funcionales

### 2️⃣ **StreamsAPI.java**
Operaciones con Streams:
- `filter()` - Filtrar elementos
- `map()` - Transformar elementos
- `forEach()` - Iterar funcionalmente
- `collect()` - Agregar resultados
- `sorted()` - Ordenar elementos

### 3️⃣ **InterfacesFuncionales.java**
Interfaces funcionales personalizadas:
- Crear interfaces con `@FunctionalInterface`
- Implementar con lambdas
- Interfaces predefinidas: `Function`, `Predicate`, `Consumer`, `Supplier`

### 4️⃣ **ComposicionFunciones.java**
Composición de funciones:
- `andThen()` - Ejecutar funciones en secuencia
- `compose()` - Combinar funciones
- Pipelines de transformación
- Funciones de orden superior

### 5️⃣ **OptionalManejo.java**
Manejo seguro de valores nulos:
- `of()` - Crear Optional con valor
- `ofNullable()` - Crear Optional que puede ser vacío
- `orElse()` - Valor por defecto
- `ifPresent()` - Ejecutar si está presente
- `map()` - Transformar Optional

### 6️⃣ **ReduceAgregacion.java**
Operaciones de reducción:
- `reduce()` - Sumar, multiplicar, concatenar
- `sum()`, `max()`, `min()`
- Agregaciones complejas
- IntStream vs Stream

---

## 🚀 Cómo Usar

### Requisitos
- Java 8 o superior
- Maven (opcional)

### Compilar y Ejecutar

```bash
# Clonar el repositorio
git clone https://github.com/tovarcorreamaicolstibeninem-dotcom/java-functional-examples.git
cd java-functional-examples

# Compilar con Maven
mvn clean compile

# Ejecutar ejemplos
javac -d bin src/main/java/com/examples/*.java
java -cp bin com.examples.Lambdas
java -cp bin com.examples.StreamsAPI
java -cp bin com.examples.InterfacesFuncionales
java -cp bin com.examples.ComposicionFunciones
java -cp bin com.examples.OptionalManejo
java -cp bin com.examples.ReduceAgregacion
```

---

## 💡 Conceptos Clave

| Concepto | Descripción |
|----------|------------|
| **Lambda** | Función anónima que implementa un método de una interfaz funcional |
| **Stream** | Secuencia de elementos que soporta operaciones funcionales |
| **Interfaz Funcional** | Interfaz con un solo método abstracto |
| **Composición** | Combinación de funciones para crear operaciones complejas |
| **Optional** | Contenedor que puede o no contener un valor no nulo |
| **Reduce** | Operación que agrega elementos en un único resultado |

---

## 📖 Recursos Adicionales

- [Java Functional Programming - Oracle Docs](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
- [Stream API Guide](https://docs.oracle.com/javase/9/docs/api/java/util/stream/Stream.html)
- [Optional Class](https://docs.oracle.com/javase/9/docs/api/java/util/Optional.html)

---

## 👨‍💻 Autor

Ejemplos de programación funcional en Java - 2026

## 📝 Licencia

MIT License - Libre para usar y modificar

