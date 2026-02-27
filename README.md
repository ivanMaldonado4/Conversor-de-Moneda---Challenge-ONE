# Conversor-de-Moneda---Challenge-ONE

## Descripción del proyecto

Este proyecto es una aplicación de consola desarrollada en Java que permite convertir montos entre distintas monedas utilizando una API de cotizaciones en tiempo real.

El programa obtiene las tasas de cambio desde la API de
ExchangeRate-API
y procesa la información en formato JSON mediante la biblioteca Gson.


## Funcionalidades

El programa permite:

* Convertir un monto entre dos monedas elegidas por el usuario.
* Consultar el listado de códigos de monedas disponibles.
* Mostrar un menú de opciones para interactuar con el sistema.

## Tecnologías utilizadas

* Java
* Biblioteca Gson
* HttpClient, HttpRequest y HttpResponse

## Cómo usarlo

Al ejecutar el programa se muestra el siguiente menú:

```
=== Conversor de monedas ===

Menu:
1-Convertir moneda
2-Mostrar codigos disponibles
3-Salir
```

### Opción 1 – Convertir moneda

1. Ingresá el código de la moneda base (por ejemplo: `USD`).
2. Ingresá el código de la moneda destino (por ejemplo: `ARS`).
3. Ingresá el monto a convertir.
4. El programa mostrará el resultado de la conversión.

### Opción 2 – Mostrar códigos disponibles

Muestra por pantalla todos los códigos de monedas soportados junto con su descripción.

### Opción 3 – Salir

Finaliza la ejecución del programa.


## Objetivo del proyecto

Este proyecto tiene como objetivo practicar:

* Construcción de un cliente HTTP en Java.
* Envío de solicitudes a una API externa.
* Lectura y análisis de respuestas en formato JSON.
* Filtrado de datos obtenidos desde la API.
* Conversión de valores entre monedas.
* Interacción con el usuario mediante consola.

## Autor

Proyecto desarrollado por Iván Maldonado, como parte del challenge propuesto por Alura Latam, orientado a la práctica de consumo de APIs, manejo de solicitudes HTTP y procesamiento de datos en Java.

