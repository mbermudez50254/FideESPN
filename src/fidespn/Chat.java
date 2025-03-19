/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fidespn;

/**
 *
 * @author pau
 */
import java.util.ArrayList;

public class Chat {
    private final ArrayList<String> mensajes = new ArrayList<>();
    private final ArrayList<Fanatico> participantes = new ArrayList<>();
    private final Partido partido;

    public Chat(Partido partido) {
        this.partido = partido;
    }

    public void agregarUsuario(Fanatico fanatico) {
        if (fanatico.getEquiposFavoritos().contains(partido.getEquipo1()) ||
            fanatico.getEquiposFavoritos().contains(partido.getEquipo2())) {
            participantes.add(fanatico);
            System.out.println("✅ " + fanatico.getNombre() + " se unió al chat.");
        } else {
            System.out.println("❌ No puedes entrar a este chat, no sigues a estos equipos.");
        }
    }

    public void enviarMensaje(Fanatico fanatico, String mensaje) {
        if (participantes.contains(fanatico)) {
            mensajes.add(fanatico.getNombre() + ": " + mensaje);
        } else {
            System.out.println("❌ No puedes enviar mensajes si no estás en el chat.");
        }
    }

    public ArrayList<String> getMensajes() {
        return mensajes;
    }
}


