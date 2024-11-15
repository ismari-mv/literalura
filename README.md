**Literalura**

Literalura es una aplicación de consola que permite gestionar libros y autores. Está diseñada para conectarse a una base de datos PostgreSQL, realizar consultas avanzadas y manejar datos de manera eficiente.

**Características**

Gestión de Libros

**Buscar libros por idioma**

Guardar libros en la base de datos.
Manejar excepciones si no se encuentran libros registrados o si hay errores en los datos.

**Gestión de Autores**
Mostrar la lista de autores registrados.
Buscar autores vivos en un año determinado.
Manejar excepciones si no se encuentran autores que cumplan los criterios de búsqueda.
Requisitos previos
Antes de ejecutar el proyecto, asegúrate de tener instalados:

Java 17 o superior
Maven
PostgreSQL
Spring Boot 3.x
Instalación

Clona el repositorio en tu máquina local:
bash
Copiar código
git clone https://github.com/tu-usuario/literalura.git
Configura la base de datos PostgreSQL:

Crea una base de datos llamada literalura.

Actualiza el archivo application.properties en el directorio src/main/resources con tus credenciales:

properties
Copiar código
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

Construye el proyecto con Maven:
bash
Copiar código
mvn clean install

Ejecuta la aplicación:
bash
Copiar código
mvn spring-boot:run
Uso
Al iniciar la aplicación, verás un menú principal que permite realizar las siguientes acciones:

**Mostrar lista de autores registrados.
Buscar autores vivos por un año específico.
Buscar libros por idioma.
Salir del programa.
Sigue las instrucciones en pantalla para interactuar con la aplicación.

##Tecnologías utilizadas
Java: Lenguaje de programación principal.
Spring Boot: Framework para simplificar el desarrollo de aplicaciones Java.
Hibernate: ORM para interactuar con la base de datos.
PostgreSQL: Sistema de gestión de bases de datos relacional.
