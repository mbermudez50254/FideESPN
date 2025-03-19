/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fidespn;

/**
 *
 * @author pau
 */


import javax.swing.*;
import java.awt.*;

public class EventosGUI {
    public static void reportarEvento() {
        JFrame frame = new JFrame("📰 Reportar Evento");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(DisenoUI.FONDO);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(DisenoUI.FONDO);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Título
        JLabel titulo = DisenoUI.crearTitulo("📢 Reportar un Evento");
        panel.add(titulo, gbc);

        // ComboBox de tipo de evento
        panel.add(DisenoUI.crearEtiqueta("Seleccione el evento:"), gbc);
        String[] eventos = {"Gol", "Tarjeta Amarilla", "Tarjeta Roja"};
        JComboBox<String> tipoEvento = new JComboBox<>(eventos);
        tipoEvento.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(tipoEvento, gbc);

        // Campo de jugador
        panel.add(DisenoUI.crearEtiqueta("Jugador:"), gbc);
        JTextField jugador = DisenoUI.crearCampoTexto(15);
        panel.add(jugador, gbc);

        // Campo de minuto
        panel.add(DisenoUI.crearEtiqueta("Minuto:"), gbc);
        JTextField minuto = DisenoUI.crearCampoTexto(5);
        panel.add(minuto, gbc);

        // Botón Reportar
        JButton reportar = DisenoUI.crearBoton("✅ Reportar Evento");
        reportar.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "✅ Evento reportado: " + tipoEvento.getSelectedItem() + " de " + jugador.getText() + " en el minuto " + minuto.getText());
        });

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(reportar, gbc);

        frame.add(panel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        frame.setVisible(true);
    }
}
