/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fidespn;

/**
 *
 * @author pau
 */
public abstract class Evento {
    protected String tipo;
    protected String jugador;
    protected String minuto;

    public Evento(String tipo, String jugador, String minuto) {
        this.tipo = tipo;
        this.jugador = jugador;
        this.minuto = minuto;
    }

    public abstract String mostrarEvento();
}

