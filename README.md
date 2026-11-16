![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧭 Llanquihue Tour APP

## 👤 Autor del proyecto

- **Nombre completo:** Tabata Zuleta Lazo
- **Carrera:** Analista Programador Computacional

---

## 📘 Descripción general del proyecto

Llanquihue Tour es un proyecto de Java para la asignatura **Desarrollo Orientado a Objetos I**. Representa una agencia turística ficticia que ofrece recorridos por Llanquihue y otras localidades cercanas de la Región de Los Lagos.

El programa lee los tours desde el archivo `tours.txt`, crea objetos de la clase `Tour` y los almacena en una colección `ArrayList`. Luego muestra el catálogo completo y aplica filtros para listar tours de naturaleza y tours con precio menor a $35.000 pesos chilenos.

Cada registro contiene cuatro datos separados por punto y coma: nombre del tour, ciudad, tipo de tour  y precio.

---

## 🧱 Estructura del proyecto

```text
LlanquihueTourApp2/
├── src/
│   └── main/
│       ├── java/
│       │   ├── data/
│       │   │   └── GestorDatos.java   # Lee el archivo y construye la colección de tours
│       │   ├── model/
│       │   │   └── Tour.java          # Modelo con los datos de cada tour
│       │   └── ui/
│       │       └── Main.java          # Punto de entrada, recorrido y filtros
│       └── resources/
│           └── tours.txt              # Datos de los tours
├── pom.xml
└── README.md
```

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

- Java compatible con la versión configurada en `pom.xml`.
- IntelliJ IDEA o un entorno compatible con proyectos Maven.

Para ejecutar el proyecto:

1. Clona el repositorio:

   ```bash
   git clone https://github.com/Taa-aaT/Llanquihue-Tour2.git
   ```

2. Abre la carpeta del proyecto en IntelliJ IDEA y espera a que Maven cargue la configuración.
3. Verifica que `tours.txt` esté en `src/main/resources/`.
4. Ejecuta `Main.java`, ubicado en el paquete `ui`.
5. Revisa la consola para ver todos los tours y los resultados de los filtros.

---

## 📄 Formato de `tours.txt`

Cada línea debe tener cuatro campos, en este orden:

```text
nombre del tour;ciudad;tipo;precio
```

Ejemplo:

```text
Ruta Costanera;Llanquihue;Cultural;25000
```

El precio se ingresa como un número entero, sin puntos ni signo `$`. El programa espera cuatro campos por línea; las líneas con formato inválido se omiten y se informa el número de línea en la consola.


---

**Repositorio GitHub:** https://github.com/Taa-aaT/Llanquihue-Tour2  
**Fecha de entrega:** 16/11/2026

---

© Duoc UC | Desarrollo Orientado a Objetos I
