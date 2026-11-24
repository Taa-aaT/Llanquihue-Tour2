![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🧭 Llanquihue Tour App

## 👤 Autora del proyecto

- **Nombre completo:** Tabata Zuleta Lazo
- **Carrera:** Analista Programador Computacional

---

## 📘 Descripción general

Llanquihue Tour es una aplicación de consola desarrollada en Java para la asignatura **Desarrollo Orientado a Objetos I**. Representa una agencia turística ficticia de la Región de Los Lagos y permite consultar y administrar tours y trabajadores relacionados con la empresa.

El programa carga los datos desde archivos de texto y los almacena en colecciones `ArrayList`. El menú permite listar y filtrar tours, agregar tours, listar trabajadores, añadir trabajadores y eliminar trabajadores por RUT. Las clases de modelo validan los datos ingresados y los gestores guardan los cambios en los archivos correspondientes.

---

## 🧱 Estructura del proyecto

```text
LlanquihueTourApp/
├── src/
│   └── main/
│       ├── java/
│       │   ├── data/
│       │   │   ├── GestorTours.java
│       │   │   └── GestorTrabajadores.java
│       │   ├── model/
│       │   │   ├── Tour.java
│       │   │   └── Trabajadores.java
│       │   └── ui/
│       │       ├── Main.java
│       │       └── Menu.java
│       └── resources/
│           ├── tours.txt
│           └── trabajadores.txt
├── pom.xml
└── README.md
```

### Descripción breve de las clases

| Clase | Paquete | Descripción |
|---|---|---|
| `Main` | `ui` | Inicia la aplicación, carga los datos y muestra el menú principal. |
| `Menu` | `ui` | Presenta las opciones por consola y coordina las acciones de tours y trabajadores. |
| `Tour` | `model` | Representa un tour con nombre, ciudad, tipo y precio. Incluye validaciones y formato de visualización. |
| `Trabajadores` | `model` | Representa a un trabajador con nombre, rol y RUT. Incluye validaciones y formato de visualización. |
| `GestorTours` | `data` | Lee los tours desde `tours.txt` y guarda nuevos registros. |
| `GestorTrabajadores` | `data` | Lee, agrega y elimina trabajadores en `trabajadores.txt`. |

---

## ✨ Funcionalidades

### Tours

- Mostrar el listado completo de tours.
- Filtrar por tipo, destino o precio.
- Buscar tours por precio exacto o por rango.
- Agregar tours y guardar los datos en `tours.txt`.

### Trabajadores y entidades relacionadas

- Mostrar el listado de trabajadores y sus roles.
- Agregar trabajadores a `trabajadores.txt`.
- Eliminar trabajadores mediante su RUT.

---

## ⚙️ Requisitos y ejecución

- JDK compatible con la versión configurada en `pom.xml`.
- IntelliJ IDEA u otro entorno compatible con Maven.

Para ejecutar el proyecto:

1. Clona el repositorio:

   ```bash
   git clone https://github.com/Taa-aaT/Llanquihue-Tour2.git
   ```

2. Abre la carpeta del proyecto en IntelliJ IDEA y espera a que Maven cargue la configuración.
3. Verifica que `tours.txt` y `trabajadores.txt` estén en `src/main/resources/`.
4. Ejecuta `Main.java`, ubicado en el paquete `ui`.
5. Usa las opciones que aparecen en la consola.

---

## 📄 Formato de los archivos

### `tours.txt`

Cada línea contiene cuatro campos separados por punto y coma:

```text
nombre del tour;ciudad;tipo;precio
```

Ejemplo:

```text
Ruta Costanera;Llanquihue;Cultural;25000
```

El precio debe ser un número entero positivo, sin puntos ni signo `$`. Los tipos permitidos son `Cultural`, `Lacustre`, `Naturaleza` y `Gastronomico`.

### `trabajadores.txt`

Cada línea contiene tres campos separados por punto y coma:

```text
nombre;rol;rut
```

Ejemplo:

```text
Fernando Fernandez;Guía turístico;15765768-7
```

El nombre y el rol no pueden estar vacíos. El RUT debe respetar el formato validado por la aplicación.

---

## 🔗 Repositorio y entrega

**Repositorio GitHub:** https://github.com/Taa-aaT/Llanquihue-Tour2

**Fecha de entrega:** 23/11/2026

---

© Duoc UC | Desarrollo Orientado a Objetos I