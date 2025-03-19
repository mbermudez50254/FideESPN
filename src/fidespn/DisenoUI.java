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

public class DisenoUI {
    public static final Color FONDO = new Color(30, 30, 30);
    public static final Color TEXTO = new Color(255, 215, 0);
    public static final Color BOTON = new Color(50, 150, 250);

    public static void aplicarEstilo(JFrame frame) {
        frame.getContentPane().setBackground(FONDO);
        frame.getContentPane().setLayout(new BorderLayout()); // 🔹 Aplicamos BorderLayout correctamente
        frame.setResizable(false);
    }

    public static JLabel crearTitulo(String texto) {
        JLabel label = new JLabel(texto);
        label.setForeground(TEXTO);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        return label;
    }

    public static JLabel crearEtiqueta(String texto) {
        JLabel label = new JLabel(texto);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        return label;
    }

    public static JTextField crearCampoTexto(int columnas) {
        JTextField campo = new JTextField(columnas);
        campo.setFont(new Font("Arial", Font.PLAIN, 14));
        return campo;
    }

    public static JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setBackground(BOTON);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createRaisedBevelBorder());
        return boton;
    }
}


