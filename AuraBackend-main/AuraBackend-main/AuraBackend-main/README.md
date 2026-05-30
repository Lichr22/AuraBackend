# 🪷 AURA

**Aura** es una aplicación desarrollada en Java diseñada para ayudar a las mujeres a monitorear y comprender sus ciclos menstruales. Mediante el uso de Inteligencia Artificial, la aplicación ofrece predicciones y recomendaciones personalizadas, además de permitir compartir el seguimiento del ciclo con una pareja de manera segura.

## ⚙️ Estructura del Dominio (Clases Principales)

El proyecto está modelado con Programación Orientada a Objetos en Java, abarcando los siguientes módulos principales:

* 👤 **Gestión de Usuarios:**
    * `Usuario`: Manejo de credenciales, roles y vinculación.
    * `PerfilMenstrual`: Datos base del ciclo y uso de anticonceptivos.
* 📅 **Seguimiento del Ciclo y Síntomas:**
    * `Ciclo`: Historial de fechas de inicio, fin y duración.
    * `RegistroDiario`: Entrada diaria de peso, temperatura y calidad de sueño.
    * `RegistroFlujo`, `Sintoma` y `DetalleSintomaDiario`: Monitoreo específico de condiciones físicas diarias.
* ❤️ **Salud y Bienestar:**
    * `ActividadSexual`: Registro de relaciones y métodos de protección.
* 🤖 **Motor de Inteligencia Artificial:**
    * `Prediccion`: Cálculo de ventana fértil y próxima menstruación.
    * `RecomendacionIA`: Tips y sugerencias generadas según los registros diarios.
* 👫 **Modo Pareja:**
    * `VinculoPareja` y `PermisosCompartidos`: Gestión de accesos para que la pareja pueda ver fases del ciclo, síntomas o recibir notificaciones.

## 💻 Tecnologías Utilizadas
* **Lenguaje:** Java

## 🚀 Cómo ejecutar el proyecto
1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu IDE de preferencia (IntelliJ IDEA, Eclipse, NetBeans).
3. Compila y ejecuta la clase principal (ajusta según tu estructura).