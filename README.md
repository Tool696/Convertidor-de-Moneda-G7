# Convertidor de Divisas - Java Application

Este proyecto es un convertidor de divisas desarrollado en Java, que utiliza la API de [ExchangeRate](https://www.exchangerate-api.com/) para obtener las tasas de cambio en tiempo real entre varias monedas. El programa permite convertir entre pesos colombianos, pesos mexicanos, pesos argentinos, dólares estadounidenses, euros y rublos, proporcionando una interfaz de usuario interactiva para seleccionar las monedas y realizar las conversiones.

## Requisitos

Para ejecutar este proyecto necesitarás:

- **Java Development Kit (JDK) 17 o superior.**
- **Librerías JSON** para procesar los datos obtenidos de la API:
    - `json-20210307.jar`
    - `gson-2.11.0-javadoc.jar`

## Instalación

1. Clona el repositorio o descarga los archivos del proyecto.
2. Incluye las librerías necesarias (`json-20210307.jar` y `gson-2.11.0-javadoc.jar`) en el classpath del proyecto.
3. En el archivo `ExchangeRateAPI.java`, reemplaza la variable `API_KEY` con tu clave API de ExchangeRate.

## Funcionamiento del Programa

El programa permite al usuario:

1. Seleccionar una moneda de origen.
2. Ingresar una cantidad numérica para convertir.
3. Seleccionar la moneda de destino.
4. El programa realiza una solicitud HTTP a la API de ExchangeRate para obtener la tasa de conversión.
5. La cantidad convertida se muestra al usuario.

### Ejemplo de Conversión

Si el usuario selecciona como moneda de origen el **Peso Colombiano (COP)**, como moneda de destino el **Peso Mexicano (MXN)** y convierte **1000 COP**, el programa devolverá un resultado basado en la tasa de cambio actual (por ejemplo, **216.36 MXN**).

## Principales Componentes

- **ExchangeRateAPI.java:** Esta clase gestiona la conexión con la API de ExchangeRate. Usa el endpoint adecuado según las monedas seleccionadas, realiza la solicitud GET, y procesa la respuesta JSON para extraer la tasa de cambio.
- **ConvertirMonedas.java:** Contiene los métodos que gestionan la lógica de conversión para cada par de monedas soportadas. Estos métodos llaman a `ExchangeRateAPI` para obtener la tasa y luego calculan el valor convertido.
- **Principal.java:** Contiene el método `main` que gestiona la interacción con el usuario a través de cuadros de diálogo, donde el usuario selecciona las monedas y proporciona la cantidad a convertir.

## Errores Comunes

1. **Error de Conexión (404):** Si el enlace a la API no es válido o hay un problema de conexión, el programa muestra un mensaje de error en un cuadro de diálogo y en la consola.
2. **Error al Obtener la Tasa de Cambio:** Si la respuesta de la API no contiene la tasa de cambio, se muestra un mensaje de error informando que no se pudo obtener la tasa.

## Mejora Propuestas

- Ampliar el soporte para otras monedas.
- Implementar una funcionalidad offline que almacene tasas de cambio recientes.
- Crear una interfaz gráfica más avanzada.

## Autor

Desarrollado por: Jean Paul Serrato Violeth
