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
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FidESPNGUI {
    private static Usuario usuarioActual;

    public static void main(String[] args) {
        FidESPN.cargarDatos();
        mostrarMenuInicio();
    }

    private static void mostrarMenuInicio() {
    JFrame frame = new JFrame("FidESPN - Inicio");
    DisenoUI.aplicarEstilo(frame);
    
    // 🔹 Usamos JPanel para contener los elementos y evitar problemas con BorderLayout
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(DisenoUI.FONDO);

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = GridBagConstraints.RELATIVE;
    gbc.insets = new Insets(10, 10, 10, 10);

    panel.add(DisenoUI.crearTitulo("Bienvenido a FidESPN"), gbc);

    JButton loginButton = DisenoUI.crearBoton("Iniciar Sesión");
    JButton registerButton = DisenoUI.crearBoton("Registrar Usuario");
    JButton exitButton = DisenoUI.crearBoton("Salir");

    loginButton.addActionListener(e -> {
        frame.dispose();
        iniciarSesion();
    });
    registerButton.addActionListener(e -> registrarUsuario());
    exitButton.addActionListener(e -> System.exit(0));

    panel.add(loginButton, gbc);
    panel.add(registerButton, gbc);
    panel.add(exitButton, gbc);

    frame.getContentPane().removeAll(); // 🔹 Elimina cualquier componente previo para evitar conflictos
    frame.getContentPane().setLayout(new BorderLayout()); // 🔹 Asegura que el layout sea BorderLayout
    frame.getContentPane().add(panel, BorderLayout.CENTER); // 🔹 Agregamos correctamente el panel

    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

    private static void iniciarSesion() {
        String correo = JOptionPane.showInputDialog("Ingrese su correo:");
        String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");

        usuarioActual = FidESPN.iniciarSesion(correo, contrasena);

        if (usuarioActual != null) {
            JOptionPane.showMessageDialog(null, "✅ Bienvenido " + usuarioActual.getNombre() + " (" + usuarioActual.getTipo() + ")");
            mostrarMenuPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "❌ Correo o contraseña incorrectos.");
        }
    }

    private static void registrarUsuario() {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        String correo = JOptionPane.showInputDialog("Ingrese su correo:");
        String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");
        String[] opciones = {"Fanatico", "Corresponsal", "Administrador"};
        String tipo = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de usuario:", 
                         "Tipo de Usuario", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (FidESPN.registrarUsuario(nombre, correo, contrasena, tipo)) {
            JOptionPane.showMessageDialog(null, "✅ Usuario registrado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "❌ Error al registrar el usuario.");
        }
    }

    private static void mostrarMenuPrincipal() {
    JFrame frame = new JFrame("FidESPN - Menú Principal");
    DisenoUI.aplicarEstilo(frame);

    // 🔹 Usamos un JPanel para evitar problemas con BorderLayout
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(DisenoUI.FONDO);

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = GridBagConstraints.RELATIVE;
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.anchor = GridBagConstraints.CENTER;

    JLabel bienvenida = DisenoUI.crearTitulo("Hola, " + usuarioActual.getNombre() + " (" + usuarioActual.getTipo() + ")");
    panel.add(bienvenida, gbc);

    switch (usuarioActual.getTipo().toLowerCase()) {
        case "fanatico" -> {
            panel.add(crearBotonConAccion("Ver Partidos", e -> verPartidos()), gbc);
            panel.add(crearBotonConAccion("Entrar al Chat", e -> entrarChat()), gbc);
            }
        
        case "corresponsal" -> panel.add(crearBotonConAccion("Reportar Evento", e -> reportarEvento()), gbc);
        
        case "administrador" -> {
            panel.add(crearBotonConAccion("Gestionar Partidos", e -> gestionarPartidos()), gbc);
            panel.add(crearBotonConAccion("Asignar Corresponsales", e -> asignarCorresponsales()), gbc);
            }
    }

    JButton btnSalir = DisenoUI.crearBoton("Cerrar Sesión");
    btnSalir.addActionListener(e -> {
        frame.dispose();
        usuarioActual = null;
        mostrarMenuInicio();
    });

    panel.add(btnSalir, gbc);

    frame.getContentPane().removeAll(); // 🔹 Limpiamos cualquier componente previo
    frame.getContentPane().setLayout(new BorderLayout()); // 🔹 Aseguramos que usa BorderLayout
    frame.getContentPane().add(panel, BorderLayout.CENTER); // 🔹 Agregamos correctamente el panel

    frame.setSize(500, 350);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

    private static JButton crearBotonConAccion(String texto, java.awt.event.ActionListener accion) {
        JButton boton = DisenoUI.crearBoton(texto);
        boton.addActionListener(accion);
        return boton;
    }

    // 📅 Ver Partidos
    private static void verPartidos() {
        JFrame frame = new JFrame("📅 Partidos Disponibles");
        DisenoUI.aplicarEstilo(frame);

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Partido partido : FidESPN.getPartidos()) {
            model.addElement(partido.getEquipo1() + " vs " + partido.getEquipo2() + " - " + partido.getFecha());
        }

        JList<String> lista = new JList<>(model);
        lista.setBackground(DisenoUI.FONDO);
        lista.setForeground(Color.WHITE);
        frame.add(new JScrollPane(lista));

        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    // 💬 Chat en Vivo
    private static void entrarChat() {
        JFrame frame = new JFrame("💬 Chat en Vivo");
        DisenoUI.aplicarEstilo(frame);

        JTextArea chatArea = new JTextArea(10, 30);
        chatArea.setEditable(false);
        chatArea.setBackground(DisenoUI.FONDO);
        chatArea.setForeground(Color.WHITE);

        JTextField input = new JTextField(20);
        JButton enviar = DisenoUI.crearBoton("Enviar");

        enviar.addActionListener(e -> {
            chatArea.append(usuarioActual.getNombre() + ": " + input.getText() + "\n");
            input.setText("");
        });

        frame.add(new JScrollPane(chatArea));
        frame.add(input);
        frame.add(enviar);

        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    // 📰 Reportar Evento
    private static void reportarEvento() {
        JFrame frame = new JFrame("📰 Reportar Evento");
        DisenoUI.aplicarEstilo(frame);

        String[] eventos = {"Gol", "Tarjeta Amarilla", "Tarjeta Roja"};
        JComboBox<String> tipoEvento = new JComboBox<>(eventos);
        JTextField jugador = new JTextField(15);
        JTextField minuto = new JTextField(5);
        JButton reportar = DisenoUI.crearBoton("Reportar");

        reportar.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "✅ Evento reportado: " + tipoEvento.getSelectedItem() + " de " + jugador.getText() + " en el minuto " + minuto.getText());
        });

        frame.add(DisenoUI.crearTitulo("Seleccione el evento"));
        frame.add(tipoEvento);
        frame.add(new JLabel("Jugador:"));
        frame.add(jugador);
        frame.add(new JLabel("Minuto:"));
        frame.add(minuto);
        frame.add(reportar);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    // ⚽ Gestionar Partidos
private static void gestionarPartidos() {
    JFrame frame = new JFrame("⚽ Gestionar Partidos");
    DisenoUI.aplicarEstilo(frame);

    DefaultListModel<String> model = new DefaultListModel<>();
    for (Partido partido : FidESPN.getPartidos()) {
        model.addElement(partido.getEquipo1() + " vs " + partido.getEquipo2());
    }

    JList<String> lista = new JList<>(model);
    JButton crear = DisenoUI.crearBoton("Crear Partido");
    JButton eliminar = DisenoUI.crearBoton("Eliminar Partido");

    eliminar.addActionListener((ActionEvent e) -> {
        int index = lista.getSelectedIndex();
        if (index != -1) {
            FidESPN.eliminarPartido(index);
            model.remove(index);
        }
    });

    frame.add(new JScrollPane(lista));
    frame.add(crear);
    frame.add(eliminar);

    frame.setSize(500, 400);
    frame.setVisible(true);
}

    // 👥 Asignar Corresponsales
private static void asignarCorresponsales() {
    JFrame frame = new JFrame("📢 Asignar Corresponsales");
    DisenoUI.aplicarEstilo(frame);

    // Lista de partidos sin corresponsal
    DefaultListModel<String> modelPartidos = new DefaultListModel<>();
    ArrayList<Partido> partidos = (ArrayList<Partido>) FidESPN.getPartidos();
    for (Partido partido : partidos) {
        if (partido.getCorresponsal() == null) {
            modelPartidos.addElement(partido.getEquipo1() + " vs " + partido.getEquipo2());
        }
    }
    JList<String> listaPartidos = new JList<>(modelPartidos);

    // Lista de corresponsales sin asignación
    DefaultListModel<String> modelCorresponsales = new DefaultListModel<>();
    ArrayList<Usuario> usuarios = FidESPN.getUsuarios();
    ArrayList<Corresponsal> corresponsalesDisponibles = new ArrayList<>();
    
    for (Usuario usuario : usuarios) {
        if (usuario instanceof Corresponsal corresponsal) {
            modelCorresponsales.addElement(corresponsal.getNombre());
            corresponsalesDisponibles.add(corresponsal);
        }
    }
    JList<String> listaCorresponsales = new JList<>(modelCorresponsales);

    JButton asignar = DisenoUI.crearBoton("Asignar");

    asignar.addActionListener(e -> {
        int indexPartido = listaPartidos.getSelectedIndex();
        int indexCorresponsal = listaCorresponsales.getSelectedIndex();

        if (indexPartido != -1 && indexCorresponsal != -1) {
            Partido partidoSeleccionado = partidos.get(indexPartido);
            Corresponsal corresponsalSeleccionado = corresponsalesDisponibles.get(indexCorresponsal);

            partidoSeleccionado.setCorresponsal(corresponsalSeleccionado);
            corresponsalSeleccionado.asignarPartido(partidoSeleccionado);

            JOptionPane.showMessageDialog(frame, "✅ Corresponsal asignado con éxito.");
            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(frame, "❌ Selecciona un partido y un corresponsal.");
        }
    });

    frame.add(DisenoUI.crearTitulo("Selecciona un partido"), BorderLayout.NORTH);
    frame.add(new JScrollPane(listaPartidos), BorderLayout.WEST);
    frame.add(DisenoUI.crearTitulo("Selecciona un corresponsal"), BorderLayout.CENTER);
    frame.add(new JScrollPane(listaCorresponsales), BorderLayout.EAST);
    frame.add(asignar, BorderLayout.SOUTH);

    frame.setSize(600, 400);
    frame.setVisible(true);
    }

}
