# devco-semillero-tienda-videojuegos
Proyecto para el semillero de devco de tienda de videojuegos de API backend con Java y Spring Boot para la aplicacion, pruebas fluidas con AssertJ y siguiendo una arquitectura hexagonal

Para ejecutar el proyecto, clonar el repisotio de git y en una terminal ejecutar dentro de la carpeta del proyecto
~~~
./gradlew bootRun
~~~
Para ejecutar las pruebas correr. El reporte de pruebas se encuentra en el archivo /build/reports/index.html y la cobertura de pruebas se encuentra en el archivo /build/jacocoHtml/index.html
~~~
./gradlew test
~~~

El proyecto cuenta con los siguientes endpoints API en localhost:8080/api
## User
GET /user : ver todos los usuarios
GET /user/{id} : ver un usuario
POST /user/register : registrarse, la API recibe las siguientes variables. Se recibe la id ya que de momento se usa una base de datos en memoria
```
{"id": 0, "fName": "fName", "lName": "lName"}
```
PUT /user/{id} : actualizar el nombre del usuario, la API recibe las siguientes variables. Se recibe la id ya que de momento no se tiene un DTO sin id
```
{"id": 0, "fName": "fName", "lName": "lName"}
```
DELETE /user/{id} : borrar usuario

## Videogame
GET /videogame : ver todos los videojuego
GET /videgame/{id} : ver un videojuego
POST /videogame/add : agregar un videojuego al catalogo, a API recibe las siguientes variables. Se recibe la id ya que de momento se usa una base de datos en memoria
```
{"id": 0, "name": "name", "console": 0, "stock": 0}
```
PUT /videogame/{id} : actualizar un videojuego, la API recibe las siguientes variables. Se recibe la id ya que de momento no se tiene un DTO sin id
```
{"id": 0, "name": "name", "console": 0, "stock": 0}
```
PUT /videogame/stock/{id} : aumentar las existencias de un videojuego, la API recibe un numero en formato de texto
PUT /videogame/sell/{id} : reducir existencias de un videojuego por venta, la API recibe un numero en formato de texto. Haria falta recibir la id del usuario para generar la transaccion
DELETE /videogame/{id} : borrar videojuego
