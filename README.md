
# 📅 Componente Calendario - Java

Componente en Java para crear y mostrar un calendario interactivo con opción de selección de fechas. Este componente tiene una interfaz gráfica basada en JPanel, que permite visualizar un calendario mes a mes y seleccionar un día.

## 🚀 Características
* ✅ Vista mensual del calendario.
* ✅ Selección de día con interacción.
* ✅ Personalización de estilos (colores, fuentes).
* ✅ Habilitar/deshabilitar fines de semana.
* ✅ Cambio de mes y año con botones desplegables.

## 📖 Documentación

### 📌 Clase Calendario

La clase `Calendario` extiende `JPanel` y proporciona los métodos necesarios para configurar y mostrar un calendario. Además, permite personalizar el estilo de los días, la cabecera y manejar la selección de fechas.

### 📌 Métodos Principales

| Método | Descripción |
|--------|-------------|
| `setFondoDias(Color color)` | Establece el fondo de los días del calendario. |
| `setFuenteDias(Font fuente)` | Establece la fuente de los días. |
| `setColorTextoDias(Color color)` | Establece el color del texto de los días. |
| `setAlineacionTexto(int alineacion)` | Establece la alineación del texto en los botones de los días. |
| `setSeleccionListener(FechaSeleccionListener listener)` | Establece un listener que se ejecuta al seleccionar una fecha. |
| `setRangoAnios(int desde, int hasta)` | Establece el rango de años que se pueden seleccionar. |
| `setFinesDeSemanaHabilitados(boolean habilitados)` | Permite habilitar o deshabilitar los fines de semana en el calendario. |
| `getFechaSeleccionada()` | Devuelve la fecha seleccionada por el usuario. |
| `actualizarCalendario()` | Actualiza la vista del calendario según el mes y año actuales. |

## 📦 Instalación
1. Clona el repositorio:
```bash
git clone https://github.com/tu-usuario/calendario-componente.git
```
2. En tu proyecto de Java, agrega el archivo `Calendario.jar` a las librerías:
   - En NetBeans: haz clic derecho sobre la carpeta "Libraries" dentro de tu proyecto *Projects -> Libraries -> Add JAR/Folder* y selecciona `Calendario.jar`.
3. Importa el componente en tu código con:
```java
import calendario.Calendario;
```

## 🛠 Uso/Ejemplo

### Crear y personalizar el calendario

```java
Calendario calendario = new Calendario();
calendario.setFondoDias(Color.LIGHT_GRAY);  // Establecer fondo de los días
calendario.setFuenteDias(new Font("Arial", Font.PLAIN, 14));  // Establecer fuente de los días
calendario.setColorTextoDias(Color.BLACK);  // Establecer color de texto de los días
calendario.setAlineacionTexto(SwingConstants.CENTER);  // Establecer alineación de texto en botones
calendario.setRangoAnios(1900, 2100);  // Establecer rango de años
calendario.setFinesDeSemanaHabilitados(false);  // Deshabilitar fines de semana
```

### Selección de fecha

```java
calendario.setSeleccionListener(new FechaSeleccionListener() {
    @Override
    public void onFechaSeleccionada(LocalDate fecha) {
        System.out.println("Fecha seleccionada: " + fecha);
    }
});
```

## ⚙ Ejemplo de Implementación

### Video Explicativo

[![Video Explicativo](https://youtu.be/22HPfeeyHaY)

### Screenshots



## 🚀 Construido con
* ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

## Autores

| [<img src="https://avatars.githubusercontent.com/u/166089639?v=4" width=115><br><sub>Azael Chavez Lorenzo</sub>](https://github.com/bxxter) |
| :---: |

