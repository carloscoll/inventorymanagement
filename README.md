
# Prueba técnica Minsait - Carlos Coll

## Getting Started

### Dependencies

- Java JDK [versión 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
- Gradle [versión 8.5](https://gradle.org/releases/).

### Installing

Primero, clona el repositorio de GitHub a tu máquina local usando el siguiente comando:

```bash
git clone https://github.com/carloscoll/inventorymanagement.git
```
Navega al directorio del proyecto clonado:

```bash
cd inventorymanagement
```

### Compiling

Para compilar el proyecto y generar el archivo JAR ejecutable, utiliza el siguiente comando de Gradle:

```bash
./gradlew clean build
```

Este comando compilará el código fuente, ejecutará los tests y creará un archivo JAR en el directorio build/libs.

### Executing

Para iniciar la aplicación, ejecuta el JAR generado con el siguiente comando:

```bash
./gradlew bootRun
```

Una vez que la aplicación esté corriendo, la API estará disponible en http://localhost:8080.

### Tests

Para ejecutar las pruebas unitarias del proyecto, usa el siguiente comando:

```bash
./gradlew test
```

Esto ejecutará todos los tests definidos en el proyecto y te mostrará un resumen de los resultados.

### Documentation

La documentación de la API se encuentra disponible en http://localhost:8080/swagger-ui/index.html