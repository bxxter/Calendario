
# 📅 Componente Calendario - Java

Componente en Java para crear un calendario interactivo con opción de selección de fechas. Este componente tiene una interfaz gráfica basada en JPanel, que permite visualizar un calendario y seleccionar una fecha en especifico.

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

| Método | Descripción | Modificable desde | Valores Esperados / Comportamiento |
|--------|-------------|-------------------|---------------------------|
| `setFondoDias(Color color)` | Establece el fondo del panel que muestra los días del calendario. | Código y GUI | Acepta un objeto `java.awt.Color`. |
| `setFuenteDias(Font fuente)` | Establece la fuente de los días. | Código y GUI | Acepta un objeto `java.awt.Font`. Se puede usar para personalizar el estilo y tamaño de letra de los botones de los días. |
| `setColorTextoDias(Color color)` | Establece el color del texto de los días. | Código y GUI | Acepta un objeto `java.awt.Color`. |
| `setAlineacionTexto(int alineacion)` | Establece la alineación del texto en los botones de los días. | Solo código | Usa constantes de `SwingConstants`, como `SwingConstants.LEFT`, `CENTER`, `RIGHT`. |
| `setRangoAnios(int desde, int hasta)` | Establece el rango de años que se pueden seleccionar. | Código y GUI | Se pasan dos enteros: año inicial y año final. |
| `setFinesDeSemanaHabilitados(boolean habilitados)` | Permite habilitar o deshabilitar los fines de semana en el calendario. | Código y GUI | `true` habilita la selección de sábados y domingos, `false` los deshabilita. En la GUI esta disponible como checkbox en propiedades. |
| `getFechaSeleccionada()` | Devuelve la fecha seleccionada por el usuario. | Código | Devuelve un `java.time.LocalDate`. Se usa para obtener la selección hecha por el usuario. No aplicable en GUI como propiedad directa. |
| `actualizarCalendario()` | Actualiza la vista del calendario según el mes y año actuales. | Código | Refresca internamente la vista con los parámetros actuales de mes/año. Se usa tras cambios dinámicos. |

> 💡 Nota: Para editar las propiedades del componente Calendario directamente en diseño, te recomendamos usar NetBeans como IDE, gracias a su Palette Manager integrado que facilita agregar y configurar componentes visualmente.

## 📦 Instalación
1. Clona el repositorio:
```bash
git clone https://github.com/tu-usuario/calendario.git
```
2. **Abre NetBeans** y ve al menú **Tools → Palette → Swing/AWT Components → Palette Manager**.
3. Haz clic en **“Add from JAR…”**, navega hasta el JAR compilado (`Calendario.jar`) y selecciónalo.
4. En el asistente elige el componente **`Calendario`**, y escoge la categoría o carpeta de la paleta donde deseas que aparezca.
5. **Confirma** y cierra el Palette Manager.  
6. Ahora, en la ventana de diseño de cualquier `JFrame` o `JPanel`, abre la paleta, localiza el nuevo componente **“Calendario”** y arrastra al formulario.

¡Y listo! El componente aparecerá en tu formulario, y podrás personalizarlo completamente desde la GUI.


## 🛠 Uso/Ejemplo

### Crear y personalizar el calendario

```java
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class Main {
    public static void main(String[] args) {
        // Crear el objeto Calendario
        Calendario calendario = new Calendario();
        
        // Configurar las propiedades del calendario
        calendario.setFondoDias(Color.LIGHT_GRAY);  // Establecer fondo de los días
        calendario.setFuenteDias(new Font("Arial", Font.PLAIN, 14));  // Establecer fuente de los días
        calendario.setColorTextoDias(Color.BLACK);  // Establecer color de texto de los días
        calendario.setAlineacionTexto(SwingConstants.CENTER);  // Establecer alineación de texto en botones
        calendario.setRangoAnios(1900, 2100);  // Establecer rango de años
        calendario.setFinesDeSemanaHabilitados(false);  // Deshabilitar fines de semana
        
        // Crear un JFrame para mostrar el calendario
        JFrame frame = new JFrame("Calendario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(calendario);  // Agregar el calendario al frame
        frame.pack();  // Ajustar el tamaño del frame al calendario
        frame.setVisible(true);  // Hacer visible el frame
    }
}
```

## ⚙ Ejemplo de Implementación

### Video Explicativo

[![Video Explicativo](https://img.youtube.com/vi/22HPfeeyHaY/0.jpg)](https://youtu.be/22HPfeeyHaY)

### Screenshots
![Frame Calendario](https://i.imgur.com/5iTWy7U.png)

![Frame implementacion](https://i.imgur.com/SRuUohp.png)

## 🚀 Construido con
* ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

## Autores
| [<img src="https://avatars.githubusercontent.com/u/166089639?v=4" width=115><br><sub>Azael Chavez Lorenzo</sub>](https://github.com/bxxter) | [<img src="https://avatars.githubusercontent.com/u/205721466?v=4" width=115><br><sub>Fernando Arias Canton</sub>](https://github.com/Bazendu) |  
| :---: | :---: |

