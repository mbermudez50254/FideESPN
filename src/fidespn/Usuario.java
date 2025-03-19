/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fidespn;

/**
 *
 * @author pau
 */
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Usuario implements Serializable {
    protected String nombre;
    protected String correo;
    protected String contrasena;
    protected String tipo;
    protected ArrayList<Partido> partidosFavoritos = new ArrayList<>();
    private int intentosFallidos = 0;
    private boolean bloqueado = false;

    public Usuario(String nombre, String correo, String contrasena, String tipo) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    public boolean login(String correo, String contrasena) {
        if (bloqueado) {
            System.out.println("⛔ Cuenta bloqueada. Intenta más tarde.");
            return false;
        }

        if (this.correo.equals(correo) && this.contrasena.equals(contrasena)) {
            intentosFallidos = 0; // Reiniciar intentos si el login es exitoso
            System.out.println("✅ Inicio de sesión exitoso.");
            return true;
        } else {
            intentosFallidos++;
            System.out.println("❌ Credenciales incorrectas. Intento " + intentosFallidos + " de 3.");

            if (intentosFallidos >= 3) {
                bloqueado = true;
                System.out.println("⛔ Has excedido el número de intentos. Tu cuenta está bloqueada temporalmente.");
            }
            return false;
        }
    }

    public String getNombre() { 
        return nombre;
    }

    public String getTipo() { 
        return tipo;
    }
}