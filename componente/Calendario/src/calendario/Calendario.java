/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package calendario;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Calendario extends javax.swing.JPanel {

    /**
     * Creates new form Calendario
     */
    
    // Variables utilizadas para manejar el calendario
    private YearMonth mesActual;
    private boolean inicializando = false;
    private Integer diaSeleccionado = null;
    private FechaSeleccionListener seleccionListener;
    private boolean finesDeSemanaHabilitados = true;
    private int anioDesde = 1900;
    private int anioHasta = LocalDate.now().getYear();


    // Propiedades personalizables
    private Color fondoDias = Color.WHITE;
    private Font fuenteDias = new Font("SansSerif", Font.PLAIN, 12);
    private Color colorTextoDias = Color.BLACK;
    private int alineacionTexto = SwingConstants.CENTER;

    
    public Calendario() {
        initComponents();
        mesActual = YearMonth.now();
        inicializarControles();
        actualizarCalendario();
    }
    
    
    public Color getFondoDias() { 
        return fondoDias; 
    }
    
    public void setFondoDias(Color color) {
        this.fondoDias = color;
        panelDias.setBackground(color);
    }
    
    public void setFuenteDias(Font fuente) {
        this.fuenteDias = fuente;
        actualizarEstilosDias();
    }
    
    public void setColorTextoDias(Color color) {
        this.colorTextoDias = color;
        actualizarEstilosDias();
    }

    public void setAlineacionTexto(int alineacion) {
        this.alineacionTexto = alineacion;
        actualizarEstilosDias();
    }

    public void setSeleccionListener(FechaSeleccionListener listener) {
        this.seleccionListener = listener;
    }

    public void setFondoEncabezado(Color color) {
        panelEncabezado.setBackground(color);
    }

    public void setFuenteEncabezado(Font fuente) {
        comboMes.setFont(fuente);
        comboAnio.setFont(fuente);
    }
    
    // Devuelve la fecha seleccionada por el usuario
    public LocalDate getFechaSeleccionada() {
        if (diaSeleccionado == null) return null;
        int anio = (Integer) comboAnio.getSelectedItem();
        int mes = comboMes.getSelectedIndex() + 1;
        return LocalDate.of(anio, mes, diaSeleccionado);
    }
    
    // Establece el rango de años que son mostrados en el calendario
    public void setRangoAnios(int desde, int hasta) {
        comboAnio.removeAllItems();
        if (desde <= hasta) {
            for (int i = desde; i <= hasta; i++) comboAnio.addItem(i);
        } else {
            for (int i = desde; i >= hasta; i--) comboAnio.addItem(i);
        }
        comboAnio.setSelectedItem(mesActual.getYear());
    }

    // Establece el año de inicio del rango de años
    public void setAnioDesde(int desde) {
        this.anioDesde = desde;
        rellenarAnios();
    }

    // Establece el año final del rango de años
    public void setAnioHasta(int hasta) {
        this.anioHasta = hasta;
        rellenarAnios();
    }
    
    // Permite habilitar o deshabilitar los fines de semana en el calendario
    public boolean isFinesDeSemanaHabilitados() {
        return finesDeSemanaHabilitados;
    }
    
    public void setFinesDeSemanaHabilitados(boolean habilitados) {
        this.finesDeSemanaHabilitados = habilitados;
        actualizarCalendario();
    }
    
    // Configura los controles iniciales del calendario (mes y año)
    private void inicializarControles() {
        inicializando = true;

        comboMes.removeAllItems();
        for (Month mes : Month.values()) {
            comboMes.addItem(mes.getDisplayName(TextStyle.FULL, Locale.getDefault()));
        }
        comboMes.setSelectedIndex(mesActual.getMonthValue() - 1); // Selecciona el mes actual
 
        int anioActual = LocalDate.now().getYear();
        for (int i = anioActual; i >= 1900; i--) {
            comboAnio.addItem(i);
        }
        comboAnio.setSelectedItem(mesActual.getYear()); // Selecciona el año actual

        inicializando = false;
    }
    
    // Actualiza los años disponibles en el combo de año en caso de que se haya configurado un rango
    private void rellenarAnios() {
        comboAnio.removeAllItems();
        if (anioDesde <= anioHasta) {
            for (int i = anioDesde; i <= anioHasta; i++) comboAnio.addItem(i);
        } else {
            for (int i = anioDesde; i >= anioHasta; i--) comboAnio.addItem(i);
        }
        comboAnio.setSelectedItem(mesActual.getYear());
    }

    // Actualiza la vista del calendario según el mes y año actuales
    private void actualizarCalendario() {
        panelDias.removeAll();
        panelDias.setLayout(new GridLayout(0, 7, 5, 5));

        DayOfWeek[] diasOrdenados = {
        DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY,
        DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY,
        DayOfWeek.SATURDAY
        };

        for (DayOfWeek dia : diasOrdenados) {
            JLabel lbl = new JLabel(dia.getDisplayName(TextStyle.SHORT, Locale.getDefault()), SwingConstants.CENTER);
            lbl.setFont(lbl.getFont().deriveFont(Font.BOLD));
            panelDias.add(lbl);
        }

        LocalDate primerDia = mesActual.atDay(1);
        int offset = (primerDia.getDayOfWeek().getValue() % 7);

        for (int i = 0; i < offset; i++) {
            panelDias.add(new JLabel(""));
        }

        // Añade los botones para cada día del mes
        for (int i = 1; i <= mesActual.lengthOfMonth(); i++) {
            final int dia = i;
            JButton btnDia = new JButton(String.valueOf(i));
            btnDia.setMargin(new Insets(2, 2, 2, 2));
            btnDia.addActionListener(e -> {
                diaSeleccionado = dia;
                if (seleccionListener != null) {
                    seleccionListener.onFechaSeleccionada(getFechaSeleccionada());
                }
            });
            aplicarEstiloBoton(btnDia);

            // Deshabilita fines de semana si la opción está activada
            if (!finesDeSemanaHabilitados) {
                LocalDate fecha = mesActual.atDay(dia);
                DayOfWeek dow = fecha.getDayOfWeek();
                if (dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY) {
                    btnDia.setEnabled(false);
                }
            }

            panelDias.add(btnDia);
        }

        panelDias.revalidate();
        panelDias.repaint();
    }

    private void actualizarEstilosDias() {
        for (Component comp : panelDias.getComponents()) {
            if (comp instanceof JButton btn) {
                aplicarEstiloBoton(btn);
            }
        }
    }

    // Aplica el estilo a un botón de día
    private void aplicarEstiloBoton(JButton btn) {
        btn.setFont(fuenteDias);
        btn.setForeground(colorTextoDias);
        btn.setHorizontalAlignment(alineacionTexto);
    }

    // Cambia el mes actual en el calendario
    private void cambiarMes(int cantidad) {
        mesActual = mesActual.plusMonths(cantidad);
        inicializando = true;
        comboMes.setSelectedIndex(mesActual.getMonthValue() - 1);
        comboAnio.setSelectedItem(mesActual.getYear());
        inicializando = false;
        actualizarCalendario();
    }

    // Actualiza el calendario cuando se cambia la fecha (mes o año)
    private void cambiarFecha() {
        int mes = comboMes.getSelectedIndex() + 1;
        Integer anio = (Integer) comboAnio.getSelectedItem();
        if (anio != null) {
            mesActual = YearMonth.of(anio, mes);
            actualizarCalendario();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEncabezado = new javax.swing.JPanel();
        btnAnterior = new javax.swing.JButton();
        comboMes = new javax.swing.JComboBox<>();
        comboAnio = new javax.swing.JComboBox<>();
        btnSiguiente = new javax.swing.JButton();
        panelDias = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(400, 300));
        setLayout(new java.awt.BorderLayout());

        btnAnterior.setText("<<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        panelEncabezado.add(btnAnterior);

        comboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        comboMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMesActionPerformed(evt);
            }
        });
        panelEncabezado.add(comboMes);

        comboAnio.setModel(new javax.swing.DefaultComboBoxModel<>());
        comboAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnioActionPerformed(evt);
            }
        });
        panelEncabezado.add(comboAnio);

        btnSiguiente.setText(">>");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        panelEncabezado.add(btnSiguiente);

        add(panelEncabezado, java.awt.BorderLayout.PAGE_START);

        panelDias.setLayout(new java.awt.GridLayout(1, 7));
        add(panelDias, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        cambiarMes(-1);

    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        cambiarMes(1);
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void comboMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMesActionPerformed
        // TODO add your handling code here:
        if (!inicializando) cambiarFecha();
    }//GEN-LAST:event_comboMesActionPerformed

    private void comboAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnioActionPerformed
        // TODO add your handling code here:
        if (!inicializando) cambiarFecha();
    }//GEN-LAST:event_comboAnioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<Integer> comboAnio;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JPanel panelDias;
    private javax.swing.JPanel panelEncabezado;
    // End of variables declaration//GEN-END:variables
}
