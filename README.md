# API RPG en Spring Boot

- En thymeleaf, encontrara activas todas las funciones , crea cuenta como administrador en registro  desde localhost/auth/login.
- Con esta configuracion peudes crear tu primer usurio administador desde interfaz, luego lo desactivas en el html..

## Descripción del Proyecto

Este proyecto es una API desarrollada en **Spring Boot** que gestiona un sistema de roles (RPG) para usuarios, personajes, misiones, habilidades, inventarios, monstruos, mapas y más. La API está diseñada para ser utilizada en un entorno de juego donde los usuarios pueden crear personajes, realizar misiones, combatir monstruos, adquirir habilidades y gestionar su inventario.

Además de la API RESTful, el proyecto incluye un **panel de administración** construido con **Thymeleaf**, que permite a los administradores gestionar usuarios, personajes, misiones, monstruos y otros elementos del juego. El sistema también cuenta con un **control de acceso** basado en roles, que restringe el acceso a ciertas funcionalidades según el tipo de usuario.

### Tecnologías Utilizadas

- **Spring Boot**: Framework principal para el desarrollo de la API.
- **Spring Data JPA**: Para la gestión de la persistencia de datos y la interacción con la base de datos.
- **Thymeleaf**: Para la generación de vistas HTML del panel de administración.
- **Spring Web**: Para la creación de endpoints RESTful.
- **MySQL**: Base de datos relacional para almacenar toda la información del sistema.
- **Springdoc OpenAPI**: Para la documentación automática de la API usando Swagger.
- **Lombok**: Para reducir el código boilerplate (getters, setters, constructores, etc.).
- **Spring Security**: Para el control de acceso y autenticación de usuarios.
- **IA**: Se utilizó inteligencia artificial para la revisión de código, generación de datos de prueba y optimización.

---

## Funcionalidades Principales

### 1. Control de Acceso

El sistema implementa un control de acceso basado en roles, donde los usuarios tienen permisos específicos según su tipo:

- **Administradores**: Tienen acceso completo al panel de administración y pueden gestionar todos los aspectos del juego.
- **Jugadores**: Pueden crear y gestionar sus personajes, realizar misiones, combatir monstruos y gestionar su inventario.
- **Invitados**: Solo pueden ver información pública, como la lista de misiones disponibles o los monstruos del juego.

#### Roles Definidos

- **ROLE_ADMIN**: Acceso completo al sistema.
- **ROLE_USER**: Acceso limitado a funcionalidades de jugador.
- **ROLE_GUEST**: Solo acceso de lectura.

#### Autenticación

- Los usuarios deben iniciar sesión para acceder a las funcionalidades restringidas.
- La autenticación se realiza mediante **Spring Security** con soporte para formularios de inicio de sesión y autenticación básica.
- En thymeleaf, encontrara activas todas las finciones , crea cuenta como administrador.

### 2. Panel de Administración con Thymeleaf

El panel de administración está construido con **Thymeleaf**, un motor de plantillas para generar vistas HTML en el servidor. Este panel permite a los administradores gestionar:

- **Usuarios**: Crear, editar, eliminar y ver detalles de usuarios.
- **Personajes**: Gestionar los personajes de los jugadores.
- **Misiones**: Crear y asignar misiones a los jugadores.
- **Monstruos**: Configurar monstruos y sus habilidades.
- **Mapas**: Gestionar mapas y sus efectos.
- **Items**: Administrar objetos y sus propiedades.

#### Características del Panel

- **Interfaz intuitiva**: Diseño responsive y fácil de usar.
- **Validación de datos**: Los formularios incluyen validación en el frontend y backend.
- **Seguridad**: Solo los usuarios con el rol **ROLE_ADMIN** pueden acceder al panel.

### 3. API RESTful

La API proporciona endpoints para interactuar con el sistema desde aplicaciones externas, como un cliente de juego móvil o web. Algunos de los endpoints principales incluyen:

- **Usuarios**: Registro, inicio de sesión y gestión de perfiles.
- **Personajes**: Creación, edición y eliminación de personajes.
- **Misiones**: Obtención de misiones, inicio y finalización.
- **Monstruos**: Combate contra monstruos y obtención de recompensas.
- **Inventario**: Gestión de objetos y equipamiento.

### 4. Base de Datos

La base de datos está diseñada para soportar todas las funcionalidades del sistema. Algunas de las tablas principales incluyen:

- **usuarios**: Almacena la información de los usuarios.
- **personajes**: Contiene los datos de los personajes creados por los usuarios.
- **misiones**: Almacena las misiones disponibles en el juego.
- **monstruos**: Contiene los monstruos y sus estadísticas.
- **habilidades**: Almacena las habilidades disponibles para personajes y monstruos.
- **inventario_personaje**: Gestiona los objetos en el inventario de los personajes.

---

## Instalación y Ejecución

### Requisitos Previos

- Java JDK 17 o superior.
- MySQL instalado y configurado.
- IDE (IntelliJ IDEA, Eclipse, etc.) o terminal para ejecutar el proyecto.
- Postman (opcional, para probar los endpoints).
- Para exportar postman es acceder a collections, darle a los tres puntos y exportar.
- Para importar una coleccion accderemos a al workspace, en la parte superior  sale new o import e importamos.

### Pasos para Configurar y Ejecutar

1. **Clonar el Repositorio**:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd <DIRECTORIO_DEL_PROYECTO>

2. **Clonar el Repositorio**:
- Crear una base de datos en MySQL llamada api_rpg_bd.
- Configurar las credenciales de la base de datos en el archivo application.properties:

    ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/api_rpg_bd
    spring.datasource.username=<USUARIO_MYSQL>
    spring.datasource.password=<CONTRASEÑA_MYSQL>
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

3. **Compilar y Ejecutar el Proyecto**:

- Desde el IDE:
    ```bash
    Importar el proyecto como un proyecto Maven.
    Ejecutar la clase principal (ProyectoFinalLaureanoApplication).

- Desde la terminal:

    ```bash
    ./mvnw clean install
    ./mvnw spring-boot:run

4. **Acceder a la Documentación de la API**:

- Abrir el navegador y acceder a:

    ```bash
    http://localhost:8080/swagger-ui.html
    Aquí encontrarás todos los endpoints disponibles y podrás probarlos directamente.

5. **Acceder al Panel de Administración**:

- Abrir el navegador y acceder a:

    ```bash
    http://localhost:8080/admin
    Iniciar sesión con un usuario que tenga el rol ROLE_ADMIN.

6. **Explicación del Modelo de Datos**
- El modelo de datos está diseñado para gestionar un sistema de roles (RPG) con las siguientes entidades principales:

- Usuarios:

    ```bash
    Almacena la información de los usuarios, incluyendo su tipo (admin, jugador, etc.).
    
    Relacionado con la tabla tipo_usuario.

- Personajes:
- 
    ```bash
    Cada usuario puede tener varios personajes.
    
    Los personajes tienen estadísticas, habilidades, inventario y pueden pertenecer a un grupo.

- Habilidades:

    ```bash
    Los personajes y monstruos pueden tener habilidades con efectos específicos.

- Misiones:
    ```bash
    Los personajes pueden realizar misiones, que tienen recompensas y están asociadas a NPCs.

- Monstruos:
    ```bash
    Los monstruos tienen habilidades, estadísticas y pueden aparecer en mapas específicos.

- Mapas:
    ```bash
    Los mapas tienen monstruos, efectos y están relacionados con misiones.

- Inventario:
    ```bash
    Los personajes tienen un inventario donde almacenan objetos (items).

- Logros:
    ```bash
    Los personajes tienen logros basados en su progreso en el juego.

- Grupos:
    ```bash
    Los personajes pueden unirse a grupos, que tienen un líder y un tipo específico.

- NPCs:
    ```bash
    Los NPCs ofrecen misiones y venden objetos en tiendas.

7. **Cómo Importar la Colección en Postman
Exportar la Colección desde Swagger**:
    ```bash
    Accede a la documentación de Swagger en http://localhost:8080/swagger-ui.html.
    Haz clic en "Exportar" y descarga la colección en formato JSON.

- Importar en Postman:
    ```bash
    Abre Postman.
    
    Haz clic en "Importar" en la esquina superior izquierda.
    
    Selecciona el archivo JSON descargado.
    
    La colección se cargará con todos los endpoints disponibles.

- Configurar el Entorno en Postman:
    ```bash
    Crea un nuevo entorno en Postman.

    Añade una variable llamada base_url con el valor http://localhost:8080.
    
    Asigna este entorno a la colección importada.

- Probar los Endpoints:
    ```bash
    Selecciona un endpoint de la colección.

    Asegúrate de que la URL base sea correcta ({{base_url}}/api/...).
    
    Haz clic en "Send" para probar el endpoint.

8. **Estructura del Proyecto en Spring Boot
Controllers: Contienen los endpoints de la API**.

- UsuarioController: Gestiona usuarios.

- PersonajeController: Gestiona personajes.

- HabilidadController: Gestiona habilidades.

- MisionController: Gestiona misiones.

- MonstruoController: Gestiona monstruos.

- MapaController: Gestiona mapas.

- InventarioController: Gestiona inventarios.

- Models: Contienen las entidades JPA.
    ```bash
    Usuario, Personaje, Habilidad, Mision, Monstruo, etc.

- Repositories: Interfaces de Spring Data JPA para acceder a la base de datos.
    ```bash
    UsuarioRepository, PersonajeRepository, HabilidadRepository, etc.

- Services: Contienen la lógica .
    ```bash
    UsuarioService, PersonajeService, HabilidadService, etc.

- DTOs: Objetos de transferencia de datos para enviar y recibir información.
    ```bash
    UsuarioDTO, PersonajeDTO, HabilidadDTO, etc.

- Security: Configuración de seguridad (si se requiere autenticación).
