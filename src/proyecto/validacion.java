/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author jared
 */
public class validacion {
     private ArrayList<usuario> listaUsuarios;

    
    public validacion(ArrayList<usuario> listaUsuarios) {
          this.listaUsuarios = listaUsuarios;
    }

    public static boolean validacionContra(String contrasena) {
        return contrasena.length() == 8;
    }

    public static boolean validarCorreo(String correo) {
        if (correo == null) return false;

        correo = correo.toLowerCase();
        String dominios = "(gmail\\.com|outlook\\.com|yahoo\\.com|hotmail\\.com|itoaxaca\\.mx|itoaxaca\\.edu\\.mx)";
        String regex = "^[a-zA-Z0-9._%+-]+@" + dominios + "$";

        return correo.matches(regex);
    }

    public static boolean esSoloLetras(String contrasena) {
        return contrasena.matches("[a-zA-Z]+");
    }

    
    public boolean validarCredencial(String correo, String contrasena) {
    for (usuario usuario : listaUsuarios) {
        if (usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contrasena)) {
            return true;
        }
    }
    return false; 
}

   
    public void agregarUsuario(usuario usuario) {
        listaUsuarios.add(usuario);
    }
    
    
}
