/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jared
 */
public class conexionMysql {
    Connection conectar = null;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Nuevo driver para MySQL
            conectar = DriverManager.getConnection(
                "jdbc:mysql://localhost/motos", // Tu base de datos
                "root",                                // Usuario por defecto
                ""                                     // Sin contraseña en XAMPP
            );
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Error en la conexión: " + e.getMessage());
        }
        return conectar;
    }
}
