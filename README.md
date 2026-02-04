# AA4_GestionHotel

# Sistema de Gestión Hotelera (MVC)

Este proyecto es una aplicación de consola en Java diseñada para gestionar las reservas, habitaciones y facturación de un hotel. El sistema implementa el patrón de arquitectura **Modelo-Vista-Controlador (MVC)** para separar la lógica de negocio de la interfaz de usuario.

## Características

El sistema permite realizar las siguientes operaciones a través de un menú interactivo:

* Hacer Reserva: Registro de nuevos huéspedes validando fechas y disponibilidad.
* Gestión de Habitaciones: Soporte para diferentes tipos (Simple, Doble, Suite) con precios y reglas específicas.
* Consultar Reservas: Verificación de disponibilidad y estado por ID y fecha.
* Cancelaciones: Permite anular reservas existentes.
* Facturación: Generación de tickets detallados con el desglose del coste total según las noches y el tipo de habitación.

## Tecnologías y Conceptos POO

El proyecto ha sido desarrollado en **Java** puro, poniendo en práctica conceptos clave de la Programación Orientada a Objetos:

* Arquitectura MVC: Separación clara entre `Modelo` (Hotel, Reserva), `Vista` (HotelView) y `Controlador` (ControlHotel).
* Polimorfismo e Herencia: Uso de una clase abstracta `Habitacion` y clases hijas (`HabitacionSimple`, `HabitacionDoble`, `HabitacionSuite`) para el cálculo dinámico de precios.
* Interfaces: Implementación de la interfaz `Facturable`.
* Manejo de Fechas: Uso de la API `java.time.LocalDate` para cálculos precisos de estancias.
* Validaciones: Control de errores en entrada de datos (DNI, fechas incoherentes, etc.).

## Estructura del Proyecto

├── controlador/
│   └── ControlHotel.java      # Punto de entrada (main) y lógica de flujo
├── modelo/
│   ├── Hotel.java             # Gestor principal de listas y lógica de negocio
│   ├── Reserva.java           # Objeto de datos de la reserva
│   ├── Cliente.java           # Datos del huésped
│   ├── Ticket.java            # Generador de reportes de venta
│   ├── Habitacion.java        # Clase abstracta base
│   ├── HabitacionSimple.java
│   ├── HabitacionDoble.java
│   └── HabitacionSuite.java
│   └── Facturable.java        # Interfaz para cálculo de precios
│   └── ResultadoOperacion.java # Wrapper para respuestas de éxito/fallo
├── vista/
│   └── HotelView.java         # Interfaz de usuario por consola (Scanner)
## 4. Funcionalidades principales
- Gestión de habitaciones
- Gestión de clientes
- Reservas
- Estados de reserva y habitación

## 5. Uso de IA
Se ha utilizado IA como apoyo para resolver dudas y mejorar el diseño, sobre todo en el apartado de métodos como calculos o uso de otras clases para complementar la principal/otras

## 6. Limitaciones y mejoras futuras
- No hay persistencia
- Posible mejora: implementar una versión automática de la fecha,para que el usuario no la tenga que poner exacta.
