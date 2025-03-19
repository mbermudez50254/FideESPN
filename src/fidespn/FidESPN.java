/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fidespn;

/**
 *
 * @author pau
 */


import java.io.*;
import java.util.ArrayList;

public class FidESPN {
    private static final String ARCHIVO_USUARIOS = "usuarios.dat";
    private static final String ARCHIVO_PARTIDOS = "partidos.dat";
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Partido> partidos = new ArrayList<>();

    // ✅ Cargar usuarios y partidos al iniciar la app
    public static void cargarDatos() {
        usuarios = cargarLista(ARCHIVO_USUARIOS);
        partidos = cargarLista(ARCHIVO_PARTIDOS);
    }

    // ✅ Guardar usuarios y partidos al cerrar la app
    public static void guardarDatos() {
        guardarLista(usuarios, ARCHIVO_USUARIOS);
        guardarLista(partidos, ARCHIVO_PARTIDOS);
    }

    // 📌 Método genérico para guardar datos en un archivo
    private static void guardarLista(Object lista, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar datos en " + archivo);
        }
    }

    // 📌 Método genérico para cargar datos desde un archivo
    private static <T> ArrayList<T> cargarLista(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ArrayList<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    // ✅ Método para iniciar sesión
    public static Usuario iniciarSesion(String correo, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.login(correo, contrasena)) {
                return u;
            }
        }
        return null; // ❌ Usuario no encontrado
    }

    // ✅ Método para registrar un nuevo usuario
    public static boolean registrarUsuario(String nombre, String correo, String contrasena, String tipo) {
        for (Usuario u : usuarios) {
            if (u.correo.equals(correo)) {
                return false; // ❌ Ya existe un usuario con este correo
            }
        }

        Usuario nuevoUsuario;
        switch (tipo.toLowerCase()) {
            case "fanatico":
                nuevoUsuario = new Fanatico(nombre, correo, contrasena);
                break;
            case "corresponsal":
                nuevoUsuario = new Corresponsal(nombre, correo, contrasena);
                break;
            case "administrador":
                nuevoUsuario = new Administrador(nombre, correo, contrasena);
                break;
            default:
                return false;
        }

        usuarios.add(nuevoUsuario);
        guardarDatos();
        return true;
    }

    // ✅ Obtener lista de usuarios
    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    // ✅ Obtener lista de partidos
    public static ArrayList<Partido> getPartidos() {
        return partidos;
    }

    // ✅ Método para agregar un nuevo partido
    public static void agregarPartido(Partido partido) {
        partidos.add(partido);
        guardarDatos();
    }

    // ✅ Método para eliminar un partido
    public static void eliminarPartido(int index) {
        if (index >= 0 && index < partidos.size()) {
            partidos.remove(index);
            guardarDatos();
        }
    }

    // ✅ Método `main()` para ejecutar el programa
    public static void main(String[] args) {
        // Cargar datos al iniciar la aplicación
        cargarDatos();

        // Iniciar la interfaz gráfica
        FidESPNGUI.main(args);
    }
}
