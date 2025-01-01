# Proyecto: Consumo de JIKAN API

Este proyecto es una aplicación desarrollada en **Spring Boot** que consume la **JIKAN API** para acceder a información relacionada con anime. Es parte del **Bootcamp Java Developer - 18** de [Kodigo.org](https://kodigo.org/), impartido principalmente por el coach **Oscar Lemus** y el mentor **Eduardo Calles**.

## Tecnologías y herramientas utilizadas

- **Lenguaje de programación:** Java
- **Framework:** Spring Boot
- **Gestor de dependencias:** Maven
- **Entorno de desarrollo:** IntelliJ IDEA
- **JDK:** OpenJDK 23
- **Dependencias adicionales:**
  - Lombok
  - Swagger para documentación de API
  - JUnit 5 para pruebas unitarias
  - Mockito para pruebas de integración
  - Insomnia para pruebas de endpoints

## Características principales

- **Consumo de JIKAN API:** Acceso a información sobre anime, manga y personajes.
- **Documentación de API:** Generada con Swagger para facilitar la interacción con los endpoints expuestos.
- **Pruebas:** Implementación de pruebas unitarias y de integración con JUnit 5 y Mockito.
- **Control de versiones:** Uso de Git y GitHub para la gestión del código fuente.

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instaladas las siguientes herramientas:

- Java OpenJDK 23 o superior
- Maven
- IntelliJ IDEA (opcional, pero recomendado)

## Configuración e instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/nombre-del-repo.git
   ```

2. Ve al directorio del proyecto:
   ```bash
   cd nombre-del-repo
   ```

3. Compila el proyecto y descarga las dependencias con Maven:
   ```bash
   mvn clean install
   ```

4. Configura el archivo `application.properties` con los valores necesarios, como la URL base de la JIKAN API.

5. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```

## Uso

1. Accede a la documentación de la API en Swagger visitando:
   ```
   http://localhost:8080/swagger-ui.html
   ```

2. Utiliza herramientas como Insomnia o Postman para probar los endpoints disponibles.

3. Consulta el código fuente para explorar las implementaciones de consumo de la API y la lógica de negocio.

## Estructura del proyecto

El proyecto sigue la estructura estándar de Spring Boot:

```
src/
├── main/
│   ├── java/
│   │   └── org/kodigo/JikanAPIREST/
│   │       ├── controllers/
│   │       ├── dtos/
│   │       ├── entities/
│   │       ├── exceptions/
│   │       ├── repositories/
│   │       └── services/
│   └── resources/
│       ├── application.properties
├── test/
│   └── java/
│       └── org/kodigo/JikanAPIREST/
```
## Colaboradores
Deseas colaborar con este proyecto?
Aqui encontraras algunas pautas para que tu contribucion sea reconocida [Contribuidores](CONTRIBUTING.md).
## Créditos

Este proyecto fue desarrollado como parte del Bootcamp Java Developer - 18 de [Kodigo.org](https://kodigo.org/). Agradecimientos especiales a:

- **Oscar Lemus** (Coach)
- **Eduardo Calles** (Mentor)

## Reconocimientos Especiales

Este proyecto no sería posible sin el apoyo de [Kodigo.org](https://kodigo.org), que brinda oportunidades de formación y crecimiento profesional para desarrolladores en formación. Agradecemos a todos los involucrados por su dedicación y esfuerzo en el desarrollo de esta aplicación.


## Licencia

Este proyecto está bajo la licencia [MIT](LICENSE).
