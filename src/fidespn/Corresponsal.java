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

public class Corresponsal extends Usuario {
    private ArrayList<Partido> partidosAsignados = new ArrayList<>();

    public Corresponsal(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena, "corresponsal");
    }

    public void reportarEvento(Partido partido, Evento evento) {
        if (partidosAsignados.contains(partido)) {
            partido.agregarEvento(evento);
            System.out.println("Evento reportado: " + evento.mostrarEvento());
        } else {
            System.out.println("No tienes permiso para reportar este partido.");
        }
    }

    public void asignarPartido(Partido partido) {
        if (!partidosAsignados.contains(partido)) {
            partidosAsignados.add(partido);
        }
    }
}

