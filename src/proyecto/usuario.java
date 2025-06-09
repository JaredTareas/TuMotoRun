/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author jared
 */
public class usuario {
    private String correo;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String genero;
    private String contrasena;
    
      public usuario(String correo, String nombre, String apellidoPaterno, String apellidoMaterno, 
                   String fechaNacimiento, String genero, String contrasena) {
        this.correo = correo;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.contrasena = contrasena;
    }
   public String getCorreo() { return correo; }
    public String getNombre() { return nombre; }
    public String getApellidoPaterno() { return apellidoPaterno; }
    public String getApellidoMaterno() { return apellidoMaterno; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getGenero() { return genero; }
    public String getContraseña() { return contrasena; } // OJO: Corrección del método
    @Override
    public String toString() {
        return "Usuario{" + "correo=" + correo + ", nombre=" + nombre + 
               ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + 
               ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + '}';
    }
    
    
}
