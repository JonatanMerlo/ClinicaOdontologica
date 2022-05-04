# ClinicaOdontologica
El proyecto es una API RESTful que ofrece un ABM de pacientes, odontologos y turnos. Fue armado con Maven y Spring Boot durante el transcurso de la cursada. Las dependencias se encuentran en el pom.xml.
## Overview
Para examinarlo rápidamente: Usa un sistema de login: con el usuario admin@admin.com y la contraseña admin se tiene acceso a todos los endpoints
La base de datos será creada en la dirección jdbc:h2:~/dbClinicaOdontologica.
## Partes del proyecto
### Repository
Spring Boot y JPA nos ofrecen Hibernate como ORM para la persistencia de datos de forma que crea automáticamente la base de datos y las consultas (también fueron creadas algunas consultas personalizadas utilizando HQL). Fue usado en la capa repository.
### Controller
La capa controller se encarga de conectar al service con las peticiones que reciba desde el cliente. Con los distintos @RequestMapping mapeamos el Controller a los distintos endpoints de la API, y con ResponseEntity devolvemos respuestas HTTP.
### Vistas
En realidad, el proyecto es 90% una API RESTful. El otro 10% utiliza el patrón MVC. Tiene también tres endpoints especiales: /turno, /paciente y /odontologo. Esos endpoints devuelven un ModelAndView (de Servlet), que son vistas realizadas con Thymeleaf.
### Login
Con Spring Security se implementó un sistema de autenticación que protege al servicio. Para logearse como admin, usar el usuario admin@admin.com y la contraseña admin. 
### Testing
Se utilizó JUnit, integrado con Spring Test, para automatizar testeos unitarios y de integración (con MockMvc). Con maven test, los podemos ejecutar en conjunto.
### Excepciones
La anotación @RestControllerAdvice nos permite definir varios @ExceptionHanlder globales que resolverán las excepciones de toda la API. 
