/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fidespn;

/**
 *
 * @author pau
 */
public class Gol extends Evento {
    public Gol(String jugador, String minuto) {
        super("Gol", jugador, minuto);
    }

    @Override
    public String mostrarEvento() {
        return "⚽ Gol de " + jugador + " en el minuto " + minuto;
    }
}

