# 📚 Sistema Escolar – Gestión de Registros y Control de Salas

## 📌 Descripción General

**Sistema Escolar** es una aplicación web desarrollada con arquitectura MVC utilizando Spring Boot y Thymeleaf, orientada a la gestión de usuarios (alumnos), salas y registros diarios de actividades dentro de un colegio.

El sistema permite administrar la ocupación de espacios físicos mediante un control estructurado de entradas y salidas, manteniendo trazabilidad completa a través de bitácoras.

---

## 🎯 Objetivo del Sistema

Proveer un mecanismo centralizado para:

- Registrar alumnos (usuarios del sistema).
- Administrar salas del colegio.
- Controlar el uso de salas mediante registros diarios.
- Calcular automáticamente el tiempo de ocupación.
- Mantener trazabilidad de cambios mediante bitácoras.
- Facilitar la consulta de información mediante paginación y filtros.

---

## 🏗️ Módulos Principales

### 👤 1. Gestión de Usuarios (Alumnos)

Permite:

- Crear nuevos alumnos.
- Editar información.
- Listar usuarios.
- Eliminar registros.
- Administrar estado activo/inactivo.

Incluye operaciones CRUD completas.

---

### 🏫 2. Gestión de Salas

Permite:

- Registrar nuevas salas.
- Editar datos de la sala.
- Activar o desactivar disponibilidad.
- Eliminar registros.
- Listar salas disponibles.

Cada sala puede ser utilizada por un alumno durante un periodo determinado.

Incluye operaciones CRUD completas.

---

### 📋 3. Registro Diario de Actividades

Es el núcleo del sistema.

Permite registrar:

- Usuario (alumno).
- Sala utilizada.
- Horario de entrada.
- Horario de salida.
- Cálculo automático de horas totales ocupando la sala.

Cuando el usuario finaliza su estancia:

- Se registra la hora de salida.
- Se calcula la diferencia entre entrada y salida.
- Se determina el tiempo total de uso.

---

## ⏱️ Cálculo de Horas Totales

El sistema contempla:

- Registro de `Horario de Entrada`
- Registro de `Horario de Salida`
- Cálculo automático del tiempo total en horas y minutos
- Control de cierre de estancia

Esto permite medir ocupación real de las instalaciones.

---

## 🔎 Funcionalidades de Consulta

La tabla de actividades incluye:

- 🔍 Campo de búsqueda dinámica
- 📄 Paginador de resultados
- 📊 Filtros de información
- 🔄 Ordenamiento por columnas
- 🧾 Acciones CRUD disponibles desde la tabla

Esto permite administrar grandes volúmenes de registros de forma eficiente.

---

## 🗂️ Bitácoras y Trazabilidad

El sistema contempla bitácoras para:

- Registrar creación de registros.
- Registrar modificaciones.
- Registrar eliminaciones.
- Registrar cambios de estado.

Cada acción queda auditada para garantizar trazabilidad y control histórico de información.

---

## 🏛️ Arquitectura

El proyecto sigue una arquitectura por capas:

- `Controller` – Manejo de peticiones HTTP
- `Service` – Lógica de negocio
- `Repository` – Acceso a datos (JPA)
- `Model` – Entidades del dominio
- `Templates` – Vistas con Thymeleaf
- Base de datos relacional

---

## 🛠️ Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Thymeleaf
- Bootstrap
- Base de datos relacional (JPA/Hibernate)

---

## 🔐 Características Técnicas Relevantes

- Separación clara de responsabilidades (MVC).
- Validaciones de integridad de datos.
- Manejo de Optional en consultas.
- Redirecciones seguras post-operación.
- Estructura modular por entidad.
- Diseño responsive con Bootstrap.
- Integración de layout reutilizable (base, navbar, sidebar).

---

## 📈 Beneficios del Sistema

- Control eficiente de uso de instalaciones.
- Transparencia y trazabilidad.
- Gestión estructurada de alumnos y espacios.
- Reducción de errores manuales.
- Base sólida para futuras mejoras (reportes, métricas, dashboard).

---

## 🚀 Posibles Mejoras Futuras

- Reportes estadísticos de uso de salas.
- Dashboard administrativo con métricas.
- Exportación de registros a PDF o Excel.
- Autenticación y roles (admin / usuario).
- Control de concurrencia en reservas.

---

## 📌 Conclusión

Sistema Escolar es una solución integral para la administración de usuarios, salas y control de actividades dentro de un entorno educativo, proporcionando trazabilidad, control horario y herramientas de consulta eficientes mediante paginación y búsqueda dinámica.