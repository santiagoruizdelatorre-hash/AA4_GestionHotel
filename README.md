Sistema de Gestión Hotelera (Aplicación de Consola Java)
Este proyecto es una aplicación de consola en Java diseñada para gestionar las reservas de un pequeño hotel. El sistema permite interactuar con el usuario a través de un menú textual para realizar operaciones básicas de gestión hotelera, siguiendo un patrón de diseño Modelo-Vista-Controlador (MVC).

Descripción General
La aplicación simula el funcionamiento de la recepción de un hotel. Al iniciar, se precargan datos de ejemplo (habitaciones) y se presenta un menú principal. El usuario puede realizar reservas, comprobar su estado, cancelarlas y generar tickets de confirmación. El sistema maneja diferentes tipos de habitaciones, fechas y cálculos de precios mediante polimorfismo.

Arquitectura (Patrón MVC)
El proyecto está estructurado claramente siguiendo el patrón MVC, como se evidencia en el código fuente:

Controlador (ControlHotel.java): Es el punto de entrada (main). Gestiona el flujo de la aplicación, contiene el bucle principal del menú y coordina la comunicación entre la vista y el modelo. Inicializa los datos de prueba (habitaciones).

Vista (HotelView.java): Se encarga de toda la interacción con el usuario. Muestra el menú, solicita datos por consola (usando Scanner), valida entradas básicas (como fechas y números) y muestra mensajes de resultado o tickets.

Modelo (Hotel.java y clases relacionadas): Contiene la lógica de negocio y los datos. La clase principal Hotel gestiona las listas de habitaciones y reservas, y realiza las operaciones lógicas como buscar disponibilidad, crear reservas y validarlas.

Funcionalidades Principales
Basado en el menú principal mostrado en la vista y las opciones del controlador, las funcionalidades son:

Hacer reserva:

Solicita datos del cliente (Nombre, DNI, Teléfono) y fechas (Entrada, Salida).

Permite elegir entre tres tipos de habitación: "simple", "doble" o "suite".

El sistema busca una habitación disponible del tipo solicitado y crea la reserva si las fechas son válidas.

Comprobar reserva:

Permite verificar si una reserva específica (por ID) es válida para una fecha concreta, asegurando que esté dentro del rango de estancia y no esté cancelada.

Cancelar reserva:

Permite cambiar el estado de una reserva a "CANCELADA" mediante su ID.

Sacar ticket:

Genera y muestra en consola un "Ticket" detallado para las reservas confirmadas, incluyendo datos del cliente, habitación, fechas y el precio total calculado.

Estructura del Código y Características Técnicas
El proyecto demuestra varios conceptos clave de Programación Orientada a Objetos (POO) en Java:

Jerarquía de Habitaciones y Polimorfismo
Se utiliza una clase abstracta base Habitacion que implementa la interfaz Facturable. Los distintos tipos de habitación heredan de ella y sobrescriben el método calcularPrecio para aplicar diferentes tarifas.

Facturable.java (Interfaz): Define el contrato para calcular precios.

Habitacion.java (Abstracta): Define los atributos comunes (número, precio base, estado).

HabitacionSimple.java: Precio base estándar.

HabitacionDoble.java: Añade un suplemento al precio base.

HabitacionSuite.java: Añade un extra de lujo al precio base.

Gestión de Datos
Reserva.java: Vincula un Cliente, una Habitacion y un rango de fechas (LocalDate). Delega el cálculo del total a la habitación asignada.

Cliente.java: Almacena la información básica del huésped.

Ticket.java: Clase diseñada para generar un reporte textual formateado de una reserva.

Manejo de Fechas y Colecciones
Uso de la API moderna java.time.LocalDate para el manejo de fechas de entrada y salida.

Uso de java.util.ArrayList en la clase Hotel para gestionar las colecciones de habitaciones y reservas.

Auxiliares
ResultadoOperacion.java: Una clase envoltorio utilizada para devolver un estado booleano (éxito/fallo) y un mensaje descriptivo desde los métodos del modelo hacia el controlador.

Ejecución
El punto de entrada de la aplicación es el método main dentro de la clase ControlHotel.java.
