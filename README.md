# GrupoDos - Producto 4

## Añadir modelos:
* Crear modelo, según el ejemplo de `Restaurant`.
* Crear el repositorio, según el ejemplo de `RestaurantRepository`.
* Añadir las rutas en `securityConfig.java`.
* Crear el Controller, según el ejemplo de `RestaurantController`.
    * Primero, rutas mínimas
* Añadir datos en `DataInitializer`.
* Añadir más rutas en `securityConfig` y en el controlador.

## Descubrimiento
* Al hacer que sea un servidor REST, parece la propia libreria ya crea el CRUD, no es necesario poner las rutas en el controlador.
* Voy a quitar las rutas, a ver si sigue funcionando

* Otro descubrimiento: Al añadir el prefijo `api` desde properties, no se debe poner el prefijo en la securityconfig (e imagino que tampoco en los controladores, si los usásemos), porque es un prefijo ya global para todo el server.



