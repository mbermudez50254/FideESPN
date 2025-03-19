/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fidespn;

/**
 *
 * @author pau
 */
import javax.swing.*;

public class LoginGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login FidESPN");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(20, 20, 80, 25);
        frame.add(lblCorreo);

        JTextField txtCorreo = new JTextField();
        txtCorreo.setBounds(100, 20, 150, 25);
        frame.add(txtCorreo);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(20, 50, 80, 25);
        frame.add(lblPass);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(100, 50, 150, 25);
        frame.add(txtPass);

        JButton btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setBounds(80, 90, 140, 25);
        frame.add(btnLogin);

        frame.setVisible(true);
    }
}

