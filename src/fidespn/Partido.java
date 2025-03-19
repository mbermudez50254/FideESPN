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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Partido implements Serializable {
    private final String equipo1;
    private final String equipo2;
    private final String fecha;
    private final String hora;
    private final ArrayList<Evento> eventos = new ArrayList<>();
    private transient ScheduledExecutorService scheduler;

    public Partido(String equipo1, String equipo2, String fecha, String hora) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fecha = fecha;
        this.hora = hora;
        iniciarActualizacionEventos();
    }

    private void iniciarActualizacionEventos() {
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            if (!eventos.isEmpty()) {
                System.out.println("🔄 Eventos actualizados en " + equipo1 + " vs " + equipo2);
            }
        }, 0, 5, TimeUnit.SECONDS); // Ejecuta cada 5 segundos
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
        System.out.println("⚽ Nuevo evento: " + evento.mostrarEvento());
    }

    public String getEquipo1() { return equipo1; }
    public String getEquipo2() { return equipo2; }
    public ArrayList<Evento> getEventos() { return eventos; }

    public void detenerActualizacion() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
        }
    }

    void setCorresponsal(Corresponsal corresponsal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getFecha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getCorresponsal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

