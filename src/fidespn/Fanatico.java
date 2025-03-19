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

public class Fanatico extends Usuario {
    private ArrayList<String> equiposFavoritos = new ArrayList<>();

    public Fanatico(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena, "fanatico");
    }

    public void agregarEquipoFavorito(String equipo) {
        if (!equiposFavoritos.contains(equipo)) {
            equiposFavoritos.add(equipo);
        }
    }

    public ArrayList<String> getEquiposFavoritos() {
        return equiposFavoritos;
    }
}


