/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author jared
 */
public class RolItem {
    public int id;
    public String nombre;

    public RolItem(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public String getNombre() {
    return nombre;
}


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
