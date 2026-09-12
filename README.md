# Sistema de Gestión de Stock

Sistema de gestión de inventario desarrollado en Java utilizando Programación Orientada a Objetos.

## Descripción

Este proyecto permite administrar productos de un inventario mediante una aplicación de consola.

El sistema permite:

* Agregar productos
* Listar productos
* Buscar productos por ID
* Modificar productos
* Eliminar productos
* Aumentar el stock
* Disminuir el stock
* Mostrar productos sin stock

## Tecnologías utilizadas

* Java 17
* IntelliJ IDEA
* Programación Orientada a Objetos
* ArrayList
* Git

## Estructura del proyecto

```text
src/
└── stock/
    ├── Main.java
    ├── Producto.java
    └── Inventario.java
```

### Producto

Representa un producto del inventario.

Contiene:

* ID
* Nombre
* Precio
* Stock

### Inventario

Se encarga de administrar los productos y realizar las operaciones del sistema.

### Main

Contiene el menú principal y permite al usuario interactuar con el sistema desde la consola.

## Funcionalidades

### Agregar producto

Permite ingresar un nuevo producto indicando su ID, nombre, precio y cantidad de stock.

### Buscar producto

Permite buscar un producto mediante su ID.

### Modificar producto

Permite modificar el nombre y precio de un producto existente.

### Control de stock

Permite aumentar o disminuir la cantidad disponible de un producto.

### Productos sin stock

Permite visualizar los productos cuyo stock es igual a cero.

## Próximas mejoras

* Validación de datos ingresados
* Evitar IDs duplicados
* Evitar precios y stocks negativos
* Persistencia de datos
* Tests unitarios con JUnit
* Base de datos
* API REST con Spring Boot
* Interfaz web

## Autor

Proyecto desarrollado como parte de mi formación en Ingeniería en Sistemas de Información.
