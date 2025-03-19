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

public class Administrador extends Usuario {
    private final ArrayList<Partido> partidosGestionados = new ArrayList<>();

    public Administrador(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena, "administrador");
    }

    public void crearPartido(Partido partido) {
        partidosGestionados.add(partido);
        System.out.println("✅ Partido creado: " + partido.getEquipo1() + " vs " + partido.getEquipo2());
    }

    public void asignarCorresponsal(Partido partido, Corresponsal corresponsal) {
        partido.setCorresponsal(corresponsal);
        corresponsal.asignarPartido(partido);
    }
}

