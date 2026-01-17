# 📋 Sistema de Tareas

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Gson](https://img.shields.io/badge/Gson-JSON-4285F4?style=for-the-badge&logo=google&logoColor=white)
![Status](https://img.shields.io/badge/Status-Activo-success?style=for-the-badge)

## 📖 Descripción

**Sistema de Tareas** es una aplicación de consola robusta y eficiente desarrollada en **Java 21**. Su objetivo es optimizar la gestión de actividades diarias permitiendo a los usuarios crear, priorizar y realizar un seguimiento del estado de sus tareas.

A diferencia de gestores simples, este proyecto implementa **persistencia de datos en formato JSON** utilizando la librería GSON, asegurando que la información se conserve entre ejecuciones. Su arquitectura modular separa claramente la lógica de negocio, el modelo de datos y la interfaz de usuario.


## 🛠️ Tech Stack

El proyecto utiliza un stack tecnológico moderno y estándar en la industria:

* **Lenguaje:** [Java 21](https://www.oracle.com/java/technologies/downloads/#java21) (LTS)
* **Gestor de Dependencias:** [Apache Maven](https://maven.apache.org/)
* **Serialización de Datos:** [Google Gson 2.10.1](https://github.com/google/gson) para manejo de JSON
* **Arquitectura:** Diseño en capas (Service Layer Pattern) para desacoplar la lógica de `App.java` de las entidades y persistencia.

## 📋 Prerrequisitos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

* **Java Development Kit (JDK) 21** o superior.
* **Apache Maven** (para la gestión de dependencias y compilación).

## 🚀 Instalación y Uso

Sigue estos pasos para desplegar el proyecto en tu entorno local:

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/CodesJosh/Sistema_de_tareas.git
    cd sistema-de-tareas
    ```

2.  **Compilar el proyecto e instalar dependencias:**
    Maven descargará automáticamente la librería GSON definida en el `pom.xml`.
    ```bash
    mvn clean install
    ```

3.  **Ejecutar la aplicación:**
    Dado que la clase principal `App` se encuentra en el paquete por defecto, usa el siguiente comando:
    ```bash
    mvn exec:java -Dexec.mainClass="App"
    ```

### 🕹️ Funcionalidades del Menú
Una vez iniciada la aplicación, podrás:
* **Nueva Tarea:** Ingresa un título y un nivel de prioridad (1-5).
* **Listar Tareas:** Visualiza todas las tareas con su ID, estado (Pendiente/Completada) y prioridad.
* **Completar Tarea:** Cambia el estado de una tarea a "Completada" mediante su ID.
* **Eliminar Tarea:** Borra permanentemente una tarea del registro JSON.

## 📂 Estructura del Proyecto

El código sigue una estructura organizada que facilita la escalabilidad:

```text
sistema-de-tareas/
├── data/
│   └── tareas.json          # Archivo de persistencia de datos (JSON)
├── src/
│   └── main/
│       └── java/
│           ├── model/       # Entidades del dominio
│           │   ├── Entidad.java
│           │   └── Tarea.java
│           ├── service/     # Lógica de negocio
│           │   ├── ITareaService.java (Interface)
│           │   └── TareaService.java (Implementación)
│           └── App.java     # Punto de entrada (Main)
├── pom.xml                  # Configuración de Maven y dependencias
└── README.md
