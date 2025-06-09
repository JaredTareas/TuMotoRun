/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;


import java.sql.Statement;
import java.sql.Connection;
import conexion.conexionMysql; 
import java.awt.Color;
import java.awt.Image;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author jared
 */
public class bienvenida extends javax.swing.JFrame {
     private ArrayList<usuario> listaUsuarios;
     

     conexion.conexionMysql con = new conexion.conexionMysql();
   Connection conectar = con.conexion(); 
    
    
    public bienvenida() {
         this.listaUsuarios = listaUsuarios;
       
        initComponents();
          
        cargarProductos(); 
        cargarProductosCombo();
cargarClientesEnTabla();
cargarVentas();
        
        txtap.setName("txtap");
txtam.setName("txtam");
txtCalle.setName("txtCalle");
txtcolonia.setName("txtcolonia");
txtCP.setName("txtCP");
txtCurp.setName("txtCurp");
jComboBox1.setName("jComboBox1");
txtSerie.setName("txtSerie");
txtprecionueva.setName("txtprecionueva");
lblImagen.setName("lblImagen");
txtCliente.setName("txtCliente");

     

        // Configurar comportamiento al cerrar
    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    
    // Agregar listener para el evento de cerrar
    addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            confirmarSalida();
        }
    });
}
    public bienvenida(String nombre, String rol){
        initComponents();
        lblUsuario.setText(nombre + " - " + rol);
        
           if (rol.equalsIgnoreCase("Vendedor")) {
      botonBonito1.setVisible(false);
    botonBonito2.setVisible(false);
botonBonito3.setVisible(false);
botonBonito4.setVisible(false);
        cargarProductos(); 
        cargarProductosCombo();
cargarClientesEnTabla();
cargarVentas();
    txtap.setName("txtap");
txtam.setName("txtam");
txtCalle.setName("txtCalle");
txtcolonia.setName("txtcolonia");
txtCP.setName("txtCP");
txtCurp.setName("txtCurp");
jComboBox1.setName("jComboBox1");
txtSerie.setName("txtSerie");
txtprecionueva.setName("txtprecionueva");
lblImagen.setName("lblImagen");
txtCliente.setName("txtCliente");
    }
           setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    
    // Agregar listener para el evento de cerrar
    addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            confirmarSalida();
        }
    }); 
    
      if (rol.equalsIgnoreCase("Administrador")) {
        botonBonito1.setEnabled(true);
        botonBonito2.setEnabled(true);
        botonBonito3.setEnabled(true);
        botonBonito4.setEnabled(true);
        cargarProductos(); 
        cargarProductosCombo();
        cargarVentas();
cargarClientesEnTabla();
    txtap.setName("txtap");
txtam.setName("txtam");
txtCalle.setName("txtCalle");
txtcolonia.setName("txtcolonia");
txtCP.setName("txtCP");
txtCurp.setName("txtCurp");
jComboBox1.setName("jComboBox1");
txtSerie.setName("txtSerie");
txtprecionueva.setName("txtprecionueva");
lblImagen.setName("lblImagen");
txtCliente.setName("txtCliente");
    }
           setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    
    // Agregar listener para el evento de cerrar
    addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            confirmarSalida();
        }
    });
    
     if (rol.equalsIgnoreCase("Administrador de productos")) {
        botonBonito1.setEnabled(true);
        botonBonito2.setEnabled(true);
        botonBonito3.setEnabled(true);
        btnGuardar.setEnabled(false);
        botonGenerarPDF1.setEnabled(false);
        botonBonito4.setVisible(false);
        botonBonito5.setVisible(false);
        botonBonito6.setVisible(false);
       
        cargarProductos(); 
        cargarProductosCombo();
        
        
cargarClientesEnTabla();
    
    }
           setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    
    // Agregar listener para el evento de cerrar
    addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            confirmarSalida();
        }
    });
    
    
    
           
    }

// Método para confirmar salida
private void confirmarSalida() {
    int respuesta = JOptionPane.showConfirmDialog(
        this,
        "¿Está seguro de que desea salir?",
        "Confirmar Salida",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );
    
    if (respuesta == JOptionPane.YES_OPTION) {
        System.exit(0); // Cerrar la aplicación
    }
    // Si responde NO, no hace nada y la ventana permanece abierta
    }
    public void cargarProductos() {
    DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();
    modelo.setRowCount(0); // Limpia la tabla

    String sql = "SELECT * FROM productos";

    try {
        conexion.conexionMysql con = new conexion.conexionMysql();
        Connection conectar = con.conexion();

        Statement st = conectar.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Object[] fila = {
                rs.getString("codigo"),
                rs.getString("descripcion"),
                rs.getString("marca_modelo"),
                rs.getDouble("precio"),
                rs.getInt("stock")
            };
            modelo.addRow(fila);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar productos: " + e.getMessage());
    }
}
    
   public boolean actualizarStock(String codigoProducto) {
    try {
        conexion.conexionMysql con = new conexion.conexionMysql();
        Connection conectar = con.conexion();
        String sql = "UPDATE productos SET stock = stock - 1 WHERE codigo = ? AND stock > 0";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1, codigoProducto);
        int filas = ps.executeUpdate();
        ps.close();
        conectar.close();
        
        return filas > 0; // true si se actualizó, false si no hay stock
    } catch (Exception e) {
        return false; // Error en la actualización
    }
}
    
    
    
 private void guardarVenta() {
    String nombre = txtCliente.getText();
    String producto = (String) jComboBox1.getSelectedItem(); 
    String numSerie = txtSerie.getText();
    String curp = txtCurp.getText(); 
    double precio = Double.parseDouble(txtprecionueva.getText());

    try {
        conexion.conexionMysql con = new conexion.conexionMysql();
        Connection conectar = con.conexion();

        String sql = "INSERT INTO ventas (nombre_cliente, curp_cliente, producto, num_serie, precio, fecha) " +
                     "VALUES (?, ?, ?, ?, ?, NOW())";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, curp);       // Aquí va la CURP
        ps.setString(3, producto);
        ps.setString(4, numSerie);
        ps.setDouble(5, precio);     // El precio va en la posición 5

        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Venta guardada con éxito.");
        ps.close();
        conectar.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar venta: " + e.getMessage());
    }
     cargarVentas();
}
    
    
    
    
   private void cargarVentas() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ID");
    modelo.addColumn("Cliente");
    modelo.addColumn("CURP");    
    modelo.addColumn("Producto");
    modelo.addColumn("Serie");
    modelo.addColumn("Precio");
    modelo.addColumn("Fecha");

    double totalVentas = 0;

    try {
        conexion.conexionMysql con = new conexion.conexionMysql();
        Connection conectar = con.conexion();

        Statement st = conectar.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM ventas");

        while (rs.next()) {
            double precio = rs.getDouble("precio");
            totalVentas += precio;

            modelo.addRow(new Object[] {
                rs.getInt("id_venta"),
                rs.getString("nombre_cliente"),
                rs.getString("curp_cliente"),
                rs.getString("producto"),
                rs.getString("num_serie"),
                precio,
                rs.getTimestamp("fecha")
            });
        }

        TablaVentas.setModel(modelo);
        lblTotalVentas.setText("Total de ventas: $" + String.format("%.2f", totalVentas));

        rs.close();
        st.close();
        conectar.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar ventas: " + e.getMessage());
    }
}
   
   private void cargarImagen(String rutaImagen) {
    try {
        if (rutaImagen != null && !rutaImagen.isEmpty()) {
            // Crear ImageIcon con la ruta de la imagen
            ImageIcon imagen = new ImageIcon(rutaImagen);
            
            // Redimensionar para que se ajuste al JLabel
            Image img = imagen.getImage();
            Image imgEscalada = img.getScaledInstance(
                lblImagen.getWidth(), 
                lblImagen.getHeight(), 
                Image.SCALE_SMOOTH
            );
            
            ImageIcon imagenFinal = new ImageIcon(imgEscalada);
            lblImagen.setIcon(imagenFinal);
            lblImagen.setText(""); // Limpiar cualquier texto
        } else {
            // Si no hay ruta de imagen
            lblImagen.setIcon(null);
            lblImagen.setText("Sin imagen");
        }
    } catch (Exception e) {
        System.out.println("Error al cargar imagen: " + e.getMessage());
        lblImagen.setIcon(null);
        lblImagen.setText("Imagen no encontrada");
    }
}
   
   
   
   
   
   
   
   
   private void buscarClientePorCURP() {
    // Solicitar la CURP al usuario
    String curpBuscar = JOptionPane.showInputDialog(this, 
        "Ingresa la CURP del cliente a buscar:", 
        "Buscar Cliente", 
        JOptionPane.QUESTION_MESSAGE);
    
    if (curpBuscar != null && !curpBuscar.trim().isEmpty()) {
        try {
            conexion.conexionMysql con = new conexion.conexionMysql();
            Connection conectar = con.conexion();
            
            if (conectar != null) {
                String sql = "SELECT * FROM clientes WHERE curp = ?";
                PreparedStatement ps = conectar.prepareStatement(sql);
                ps.setString(1, curpBuscar.trim().toUpperCase());
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    // Cliente encontrado - llenar los campos
                    String curpEncontrada = rs.getString("curp");
                    txtCurp.setText(curpEncontrada);
                    txtCliente.setText(rs.getString("Cliente"));
                    txtap.setText(rs.getString("ApellidoPaterno"));
                    txtam.setText(rs.getString("ApellidoMaterno"));
                    txtCalle.setText(rs.getString("Calle"));
                    txtcolonia.setText(rs.getString("colonia"));
                    txtCP.setText(rs.getString("CP"));
                    
                    // Para el ComboBox del producto
                    String producto = rs.getString("ProductoAdquirido");
                    if (producto != null) {
                        jComboBox1.setSelectedItem(producto);
                    }
                    
                    // Para el precio
                    double precio = rs.getDouble("precio");
                    txtprecionueva.setText(String.valueOf(precio));
                    
                    // SELECCIONAR EN LA TABLA
                    seleccionarClienteEnTabla(curpEncontrada);
                    
                    JOptionPane.showMessageDialog(this, 
                        "Cliente encontrado: " + rs.getString("Cliente"),
                        "Éxito", 
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "No se encontró ningún cliente con la CURP: " + curpBuscar,
                        "Cliente no encontrado", 
                        JOptionPane.WARNING_MESSAGE);
                }
                
                rs.close();
                ps.close();
                conectar.close();
                
            } else {
                JOptionPane.showMessageDialog(this, "No hay conexión a la base de datos.");
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al buscar cliente: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
   
   
   
   
   private void buscarVentaPorSerie() {
    // Solicitar la serie al usuario
    String serieBuscar = JOptionPane.showInputDialog(this, 
        "Ingresa el número de serie del producto:", 
        "Buscar Venta", 
        JOptionPane.QUESTION_MESSAGE);
    
    if (serieBuscar != null && !serieBuscar.trim().isEmpty()) {
        try {
            conexion.conexionMysql con = new conexion.conexionMysql();
            Connection conectar = con.conexion();
            
            if (conectar != null) {
                String sql = "SELECT * FROM ventas WHERE num_serie = ?";
                PreparedStatement ps = conectar.prepareStatement(sql);
                ps.setString(1, serieBuscar.trim().toUpperCase());
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    // Venta encontrada - llenar los campos
                    
                    // Obtener la serie
                    String serieEncontrada = rs.getString("num_serie");
                    txtSerie.setText(serieEncontrada);
                    
                    // Llenar los campos con los nombres correctos de las columnas:
                    txtCliente.setText(rs.getString("nombre_cliente"));
                    
                    // Otros campos que puedas tener:
                    // txtCurp.setText(rs.getString("curp_cliente"));
                    // txtFecha.setText(rs.getString("fecha"));
                    
                    // Para el ComboBox del producto
                    String producto = rs.getString("producto");
                    if (producto != null) {
                        jComboBox1.setSelectedItem(producto);
                    }
                    
                    // Para el precio
                    double precio = rs.getDouble("precio");
                    txtprecionueva.setText(String.valueOf(precio));
                    
                    // SELECCIONAR EN LA TABLA - Pasar la serie encontrada
                    seleccionarVentasEnTabla(serieEncontrada);
                    
                    JOptionPane.showMessageDialog(this, 
                        "Venta encontrada para: " + rs.getString("nombre_cliente"),
                        "Éxito", 
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "No se encontró ninguna venta con serie: " + serieBuscar,
                        "Venta no encontrada", 
                        JOptionPane.WARNING_MESSAGE);
                }
                
                rs.close();
                ps.close();
                conectar.close();
                
            } else {
                JOptionPane.showMessageDialog(this, "No hay conexión a la base de datos.");
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al buscar venta: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

   
   
   
    
    private void seleccionarVentasEnTabla(String serieBuscada) {
    DefaultTableModel modelo = (DefaultTableModel) TablaVentas.getModel();
    
    // Buscar la fila que contiene la serie
    for (int i = 0; i < modelo.getRowCount(); i++) {
        String serieEnTabla = modelo.getValueAt(i, 4).toString(); // Columna 4 = num_serie
        
        if (serieEnTabla.equals(serieBuscada)) {
            // Seleccionar la fila - CORREGIDO
            TablaVentas.setRowSelectionInterval(i, i); // Era (i, 0)
            
            // Hacer scroll para que la fila sea visible
            TablaVentas.scrollRectToVisible(TablaVentas.getCellRect(i, 0, true));
            
            // Dar foco a la tabla
            TablaVentas.requestFocus();
            
            break;
        }
    }
}
    
   
   
   
   
   
   private void seleccionarClienteEnTabla(String curpBuscada) {
    // Cambia "tablaClientes" por el nombre real de tu JTable
    DefaultTableModel modelo = (DefaultTableModel) tablaClientes.getModel();
    
    // Buscar la fila que contiene la CURP
    for (int i = 0; i < modelo.getRowCount(); i++) {
        String curpEnTabla = modelo.getValueAt(i, 0).toString(); // Asumiendo que CURP está en columna 0
        
        if (curpEnTabla.equals(curpBuscada)) {
            // Seleccionar la fila
            tablaClientes.setRowSelectionInterval(i, i);
            
            // Hacer scroll para que la fila sea visible
            tablaClientes.scrollRectToVisible(tablaClientes.getCellRect(i, 0, true));
            
            // Dar foco a la tabla
            tablaClientes.requestFocus();
            
            break;
        }
    }
}

   
   

    

    
    
    
    
    private void cargarProductosCombo() {
    try {
        conexion.conexionMysql con = new conexion.conexionMysql();
        Connection conectar = con.conexion();
        
        // Limpiar el ComboBox
        jComboBox1.removeAllItems();
        
        // Agregar opción por defecto
        jComboBox1.addItem("-- Seleccionar Producto --");
        
        // Consulta SQL
        String sql = "SELECT codigo, marca_modelo FROM productos ORDER BY marca_modelo";
        PreparedStatement pst = conectar.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        // Llenar el ComboBox
        while (rs.next()) {
            String codigo = rs.getString("codigo");
            String marcaModelo = rs.getString("marca_modelo");
            String item = marcaModelo + " - " + codigo;
            jComboBox1.addItem(item);
        }
        
        rs.close();
        pst.close();
        conectar.close();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar productos: " + e.getMessage());
    }
    }

private void cargarClientesEnTabla() {
    try {
        conexion.conexionMysql con = new conexion.conexionMysql();
        Connection conectar = con.conexion();

        String sql = "SELECT * FROM clientes";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CURP");
        model.addColumn("Cliente");
        model.addColumn("Apellido Paterno");
        model.addColumn("Apellido Materno");
        model.addColumn("Calle");
        model.addColumn("Colonia");
        model.addColumn("CP");
        model.addColumn("Producto");
        model.addColumn("Precio");

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("curp"),
                rs.getString("Cliente"),
                rs.getString("ApellidoPaterno"),
                rs.getString("ApellidoMaterno"),
                rs.getString("Calle"),
                rs.getString("colonia"),
                rs.getString("CP"),
                rs.getString("ProductoAdquirido"),
                rs.getDouble("precio")
            });
        }

        tablaClientes.setModel(model);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al cargar tabla: " + ex.getMessage());
        ex.printStackTrace();
    }
}




    
    public void limpiarCampos() {
    txtCodigo.setText("");
    txtDescripcion.setText("");
    txtMarcaModelo.setText("");
    txtPrecio.setText("");
    txtStock.setText("");
}
    
      

    
    
    
    public void eliminarProducto() {
    int filaSeleccionada = tablaProductos.getSelectedRow();

    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(null, "Selecciona un producto para eliminar.");
        return;
    }

    // Confirmación
    int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este producto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

    if (confirmacion == JOptionPane.YES_OPTION) {
        String codigo = tablaProductos.getValueAt(filaSeleccionada, 0).toString(); // Asumiendo que la primera columna es el código

        String sql = "DELETE FROM productos WHERE codigo = ?";

        try {
            conexion.conexionMysql con = new conexion.conexionMysql();
            Connection conectar = con.conexion();

            PreparedStatement ps = conectar.prepareStatement(sql);
            ps.setString(1, codigo);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
                cargarProductos(); // Vuelve a cargar la tabla
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar producto: " + e.getMessage());
        }
    }
}


    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new BotonBonito();
        jPanel1 = new javax.swing.JPanel();
        tabbedPanePrincipal = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtMarcaModelo = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        botonBonito2 = new BotonBonito();
        botonBonito1 = new BotonBonito();
        botonBonito3 = new BotonBonito();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        botonBonito5 = new BotonBonito();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtap = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtam = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtcolonia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCP = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCurp = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtprecionueva = new javax.swing.JTextField();
        lblImagen = new javax.swing.JLabel();
        btnsubirimg = new javax.swing.JButton();
        botonGenerarPDF1 = new componente.BotonGenerarPDF();
        botonBonito7 = new BotonBonito();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaVentas = new javax.swing.JTable();
        lblTotalVentas = new javax.swing.JLabel();
        botonBonito6 = new BotonBonito();
        jPanel6 = new javax.swing.JPanel();
        botonBonito4 = new BotonBonito();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/cliente (1).png"))); // NOI18N
        btnGuardar.setText("Guardar Cliente");
        btnGuardar.setColorInicio(new java.awt.Color(153, 255, 204));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setSonidoActivo(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        tabbedPanePrincipal.setBackground(new java.awt.Color(204, 255, 204));
        tabbedPanePrincipal.setForeground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setBackground(new java.awt.Color(102, 255, 204));
        jLabel2.setForeground(new java.awt.Color(51, 255, 204));
        jLabel2.setText("CODIGO");

        jLabel3.setForeground(new java.awt.Color(51, 255, 204));
        jLabel3.setText("DESCRIPCION");

        jLabel4.setForeground(new java.awt.Color(51, 255, 204));
        jLabel4.setText("MARCA Y MODELO");

        jLabel5.setForeground(new java.awt.Color(51, 255, 204));
        jLabel5.setText("PRECIO");

        jLabel6.setForeground(new java.awt.Color(51, 255, 204));
        jLabel6.setText("STOCK ");

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        tablaProductos.setBackground(new java.awt.Color(204, 204, 255));
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "MARCA Y MODELO", "PECIO", "STOCK"
            }
        ));
        tablaProductos.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tablaProductos.setSelectionForeground(new java.awt.Color(0, 255, 102));
        jScrollPane1.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(30);
            tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(30);
            tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        botonBonito2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icono2.png"))); // NOI18N
        botonBonito2.setText("Eliminar");
        botonBonito2.setColorFin(new java.awt.Color(0, 0, 0));
        botonBonito2.setColorFinHover(new java.awt.Color(255, 51, 51));
        botonBonito2.setColorInicio(new java.awt.Color(204, 51, 0));
        botonBonito2.setSonidoActivo(false);
        botonBonito2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBonito2ActionPerformed(evt);
            }
        });

        botonBonito1.setText("Añadir");
        botonBonito1.setColorFinHover(new java.awt.Color(204, 255, 204));
        botonBonito1.setColorInicio(new java.awt.Color(0, 255, 0));
        botonBonito1.setSonidoActivo(false);
        botonBonito1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBonito1ActionPerformed(evt);
            }
        });

        botonBonito3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icono5.png"))); // NOI18N
        botonBonito3.setText("Editar");
        botonBonito3.setColorFin(new java.awt.Color(51, 255, 204));
        botonBonito3.setColorInicio(new java.awt.Color(0, 204, 204));
        botonBonito3.setSonidoActivo(false);
        botonBonito3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBonito3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(botonBonito1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonBonito2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(botonBonito3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtMarcaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(64, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarcaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBonito1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBonito2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBonito3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tabbedPanePrincipal.addTab("PRODUCTOS", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 204, 153));

        jLabel16.setText("Clientes ");

        tablaClientes.setBackground(new java.awt.Color(204, 255, 153));
        tablaClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 255)));
        tablaClientes.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido paterno", "Apellido materno", "Calle", "Colonia", "C.P", "Curp", "producto adquirido"
            }
        ));
        tablaClientes.setSelectionBackground(new java.awt.Color(0, 255, 204));
        tablaClientes.setSelectionForeground(new java.awt.Color(153, 0, 255));
        jScrollPane2.setViewportView(tablaClientes);

        botonBonito5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icono4.png"))); // NOI18N
        botonBonito5.setText("Buscar cliente");
        botonBonito5.setColorFinHover(new java.awt.Color(204, 204, 255));
        botonBonito5.setColorInicio(new java.awt.Color(255, 51, 255));
        botonBonito5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBonito5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonBonito5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonBonito5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedPanePrincipal.addTab("CLIENTES", jPanel3);

        jLabel1.setText("Datos del producto a vender");

        jLabel7.setText("Nombre:");

        jLabel8.setText("Apellido Paterno:");

        jLabel9.setText("Apellido Materno:");

        jLabel10.setText(" Calle :");

        jLabel11.setText("Colonia");

        jLabel12.setText("Curp:");

        jLabel13.setText("C.P:");

        jLabel14.setText("Datos del Cliente ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel15.setText("Numero de serie:");

        jLabel18.setText("Precio");

        txtprecionueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecionuevaActionPerformed(evt);
            }
        });

        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnsubirimg.setText("Subir Fotofrafia del producto");
        btnsubirimg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubirimgActionPerformed(evt);
            }
        });

        botonGenerarPDF1.setBackground(new java.awt.Color(153, 0, 153));
        botonGenerarPDF1.setForeground(new java.awt.Color(255, 255, 255));
        botonGenerarPDF1.setText("Generar Comprobante");
        botonGenerarPDF1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        botonGenerarPDF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarPDF1ActionPerformed(evt);
            }
        });

        botonBonito7.setIcon(null);
        botonBonito7.setText("Limpiar datos");
        botonBonito7.setColorFin(new java.awt.Color(255, 153, 153));
        botonBonito7.setColorFinHover(new java.awt.Color(255, 51, 51));
        botonBonito7.setColorInicio(new java.awt.Color(255, 51, 0));
        botonBonito7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBonito7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtam, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtap, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtprecionueva, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(98, 98, 98))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnsubirimg)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtcolonia, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(botonGenerarPDF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(29, 29, 29)
                                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonBonito7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel1))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcolonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(botonGenerarPDF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 67, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(txtprecionueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsubirimg)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonBonito7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67))))))
        );

        tabbedPanePrincipal.addTab("NUEVA VENTA", jPanel4);

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        TablaVentas.setBackground(new java.awt.Color(255, 204, 204));
        TablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(TablaVentas);

        lblTotalVentas.setForeground(new java.awt.Color(51, 255, 204));

        botonBonito6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/icono4.png"))); // NOI18N
        botonBonito6.setText("Buscar Venta");
        botonBonito6.setColorFin(new java.awt.Color(255, 102, 0));
        botonBonito6.setColorInicio(new java.awt.Color(204, 153, 0));
        botonBonito6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBonito6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(botonBonito6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBonito6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tabbedPanePrincipal.addTab("VENTAS", jPanel5);

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        botonBonito4.setIcon(null);
        botonBonito4.setText("PRESIONA AQUI PARA REGISTRAR UN NUEVO USUARIO");
        botonBonito4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBonito4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(botonBonito4, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(botonBonito4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPanePrincipal.addTab("Registrar Usuario", jPanel6);

        jButton1.setBackground(new java.awt.Color(0, 204, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/abre-la-cerradura (1).png"))); // NOI18N
        jButton1.setText("Nueva Venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/cliente (1).png"))); // NOI18N
        jButton2.setText("Clientes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 204));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/motocicleta (2).png"))); // NOI18N
        jButton3.setText("Productos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 102, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/etiqueta-de-precio (1).png"))); // NOI18N
        jButton4.setText("Ventas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        lblUsuario.setBackground(new java.awt.Color(0, 102, 102));
        lblUsuario.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(204, 255, 204));
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/usuariorol.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabbedPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(161, 161, 161))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addComponent(tabbedPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tabbedPanePrincipal.setSelectedIndex(3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tabbedPanePrincipal.setSelectedIndex(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tabbedPanePrincipal.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tabbedPanePrincipal.setSelectedIndex(2);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            conexion.conexionMysql con = new conexion.conexionMysql();
            Connection conectar = con.conexion();

            if (conectar != null) {
                String sql = "INSERT INTO clientes (curp, Cliente, ApellidoPaterno, ApellidoMaterno, Calle, colonia, CP, ProductoAdquirido, precio) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conectar.prepareStatement(sql);
                ps.setString(1, txtCurp.getText());
                ps.setString(2, txtCliente.getText());
                ps.setString(3, txtap.getText());
                ps.setString(4, txtam.getText());
                ps.setString(5, txtCalle.getText());
                ps.setString(6, txtcolonia.getText());
                ps.setString(7, txtCP.getText());
                ps.setString(8, jComboBox1.getSelectedItem().toString());
                ps.setDouble(9, Double.parseDouble(txtprecionueva.getText()));

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente guardado correctamente.");
                cargarClientesEnTabla(); // Refresca la tabla
            } else {
                JOptionPane.showMessageDialog(null, "No hay conexión a la base de datos.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnsubirimgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubirimgActionPerformed
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String ruta = fc.getSelectedFile().getAbsolutePath();
            ImageIcon imagen = new ImageIcon(ruta);
            lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
            lblImagen.setText("");
        }
    }//GEN-LAST:event_btnsubirimgActionPerformed

    private void txtprecionuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecionuevaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecionuevaActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (jComboBox1.getSelectedItem() != null) {
        String seleccionado = jComboBox1.getSelectedItem().toString();
        if (!seleccionado.equals("-- Seleccionar Producto --")) {
            String[] partes = seleccionado.split(" - ");
            String codigo = partes[partes.length - 1];
            
            try {
                conexion.conexionMysql con = new conexion.conexionMysql();
                Connection conectar = con.conexion();
                String sql = "SELECT * FROM productos WHERE codigo = ?";
                PreparedStatement pst = conectar.prepareStatement(sql);
                pst.setString(1, codigo);
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    String descripcion = rs.getString("descripcion");
                    String marcaModelo = rs.getString("marca_modelo");
                    double precio = rs.getDouble("precio");
                    int stock = rs.getInt("stock");
                    String rutaImagen = rs.getString("ruta_imagen"); // Nueva línea para la imagen
                    
                    txtprecionueva.setText(String.valueOf(precio));
                    
                    // ¡Cargar la imagen automáticamente!
                    cargarImagen(rutaImagen);
                    
                    System.out.println("Producto seleccionado:");
                    System.out.println("Código: " + codigo);
                    System.out.println("Descripción: " + descripcion);
                    System.out.println("Marca/Modelo: " + marcaModelo);
                    System.out.println("Precio: $" + precio);
                    System.out.println("Stock: " + stock);
                }
                rs.close();
                pst.close();
                conectar.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al obtener datos del producto: " + e.getMessage());
            }
        }
    }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void botonBonito3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBonito3ActionPerformed
          int filaSeleccionada = tablaProductos.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(null, "Selecciona un producto para editar.");
        return;
    }
    
    // Cargar los datos del producto seleccionado en los campos de arriba
    String codigoOriginal = tablaProductos.getValueAt(filaSeleccionada, 0).toString();
    String descripcionOriginal = tablaProductos.getValueAt(filaSeleccionada, 1).toString();
    String marcaOriginal = tablaProductos.getValueAt(filaSeleccionada, 2).toString();
    String precioOriginal = tablaProductos.getValueAt(filaSeleccionada, 3).toString();
    String stockOriginal = tablaProductos.getValueAt(filaSeleccionada, 4).toString();
    
    // Llenar los campos con los datos del producto
    txtCodigo.setText(codigoOriginal);
    txtDescripcion.setText(descripcionOriginal);
    txtMarcaModelo.setText(marcaOriginal);
    txtPrecio.setText(precioOriginal);
    txtStock.setText(stockOriginal);
    
    // Cambiar el texto del botón a "Actualizar"
    botonBonito1.setText("Actualizar");
    
    // Mensaje informativo
    JOptionPane.showMessageDialog(null, 
        "Producto cargado para editar.\nModifica los campos y presiona 'Actualizar'.");
    }//GEN-LAST:event_botonBonito3ActionPerformed

    private void botonBonito1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBonito1ActionPerformed
         // Verificar si estamos en modo edición o modo agregar
    boolean esActualizacion = botonBonito1.getText().equals("Actualizar");
    
    String mensaje = esActualizacion ? 
        "¿Está seguro de que desea actualizar este producto?" : 
        "¿Está seguro de que desea agregar este producto?";
    
    int respuesta = JOptionPane.showConfirmDialog(
        null,
        mensaje,
        esActualizacion ? "Confirmar Actualización" : "Confirmar Agregar Producto",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );
    
    if (respuesta == JOptionPane.YES_OPTION) {
        conexionMysql con = new conexionMysql();
        Connection conectar = con.conexion();
        try {
            String sql;
            if (esActualizacion) {
                // SQL para actualizar
                sql = "UPDATE productos SET descripcion = ?, marca_modelo = ?, precio = ?, stock = ? WHERE codigo = ?";
            } else {
                // SQL para insertar
                sql = "INSERT INTO productos (codigo, descripcion, marca_modelo, precio, stock) VALUES (?, ?, ?, ?, ?)";
            }
            
            PreparedStatement ps = conectar.prepareStatement(sql);
            
            if (esActualizacion) {
                // Parámetros para UPDATE
                ps.setString(1, txtDescripcion.getText());
                ps.setString(2, txtMarcaModelo.getText());
                ps.setDouble(3, Double.parseDouble(txtPrecio.getText()));
                ps.setInt(4, Integer.parseInt(txtStock.getText()));
                ps.setString(5, txtCodigo.getText()); // WHERE codigo = ?
            } else {
                // Parámetros para INSERT
                ps.setString(1, txtCodigo.getText());
                ps.setString(2, txtDescripcion.getText());
                ps.setString(3, txtMarcaModelo.getText());
                ps.setDouble(4, Double.parseDouble(txtPrecio.getText()));
                ps.setInt(5, Integer.parseInt(txtStock.getText()));
            }
            
            ps.executeUpdate();
            
            String mensajeExito = esActualizacion ? 
                "Producto actualizado correctamente." : 
                "Producto añadido correctamente.";
            
            JOptionPane.showMessageDialog(null, mensajeExito);
            cargarProductos();
            limpiarCampos();
            
            // Volver el botón a su estado original
            botonBonito1.setText("Añadir");
            
        } catch (Exception e) {
            String mensajeError = esActualizacion ? 
                "Error al actualizar producto: " : 
                "Error al añadir producto: ";
            JOptionPane.showMessageDialog(null, mensajeError + e.getMessage());
        }
    }
    }//GEN-LAST:event_botonBonito1ActionPerformed

    private void botonBonito2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBonito2ActionPerformed
        eliminarProducto();
    }//GEN-LAST:event_botonBonito2ActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void botonBonito4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBonito4ActionPerformed
             Usuarios ventanaRegistro = new Usuarios(listaUsuarios); // Asegúrate de pasar la lista de usuarios
    ventanaRegistro.setVisible(true); // Hacer visible la ventana de registro
    this.dispose(); // Cerrar la ventana de inicio de sesión
    }//GEN-LAST:event_botonBonito4ActionPerformed

    private void botonGenerarPDF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarPDF1ActionPerformed
      // 🔥 PRIMERO: VALIDAR STOCK ANTES DE HACER CUALQUIER COSA
    String itemSeleccionado = jComboBox1.getSelectedItem().toString();
    
    if (itemSeleccionado.equals("-- Seleccionar Producto --")) {
        JOptionPane.showMessageDialog(this, "Por favor selecciona un producto válido.");
        return;
    }
    
    String[] partes = itemSeleccionado.split(" - ");
    if (partes.length != 2) {
        JOptionPane.showMessageDialog(this, "Error: No se pudo identificar el código del producto.");
        return;
    }
    
    String codigo = partes[1].trim();
    
    // ⚠️ VALIDAR STOCK SILENCIOSAMENTE
    if (!actualizarStock(codigo)) {
       
      JOptionPane.showMessageDialog(this, 
    "ERROR: NO SE PUEDE GUARDAR AL CLIENTE NI LA VENTA\n" +
    "POR FALTA DE INVENTARIO EN ESTOS MOMENTOS");

JOptionPane.showMessageDialog(this, 
    "EL PDF SE GENERA EN AUTOMÁTICO PARA UNA LISTA DE ESPERA DEL PRODUCTO.\n" +
    "EN CUANTO TENGAMOS INVENTARIO SE LE PODRÁ ENTREGAR SU COMPROBANTE.");
        return; 
    }
    
  
    cargarProductos();
    
    // 💾 Guardar cliente
    try {
        conexion.conexionMysql con = new conexion.conexionMysql();
        Connection conectar = con.conexion();
        if (conectar != null) {
            String sql = "INSERT INTO clientes (curp, Cliente, ApellidoPaterno, ApellidoMaterno, Calle, colonia, CP, ProductoAdquirido, precio) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conectar.prepareStatement(sql);
            ps.setString(1, txtCurp.getText());
            ps.setString(2, txtCliente.getText());
            ps.setString(3, txtap.getText());
            ps.setString(4, txtam.getText());
            ps.setString(5, txtCalle.getText());
            ps.setString(6, txtcolonia.getText());
            ps.setString(7, txtCP.getText());
            ps.setString(8, jComboBox1.getSelectedItem().toString());
            ps.setDouble(9, Double.parseDouble(txtprecionueva.getText()));
            ps.executeUpdate();
            ps.close();
            conectar.close();
            
            JOptionPane.showMessageDialog(null, "Cliente guardado correctamente.");
            cargarClientesEnTabla();
        } else {
            JOptionPane.showMessageDialog(null, "No hay conexión a la base de datos.");
            return;
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al guardar cliente: " + ex.getMessage());
        ex.printStackTrace();
        return;
    }
    
    // 📄 Guardar venta
    guardarVenta();

    }//GEN-LAST:event_botonGenerarPDF1ActionPerformed

    private void botonBonito5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBonito5ActionPerformed
        // TODO add your handling code here:
          buscarClientePorCURP();
    }//GEN-LAST:event_botonBonito5ActionPerformed

    private void botonBonito6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBonito6ActionPerformed
          buscarVentaPorSerie();
    }//GEN-LAST:event_botonBonito6ActionPerformed

    private void botonBonito7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBonito7ActionPerformed
       txtCliente.setText("");
       txtCP.setText("");
       txtap.setText("");
       txtam.setText("");
        txtCalle.setText("");
         txtcolonia.setText("");
         txtCurp.setText("");
         jComboBox1.setSelectedIndex(0);
          txtSerie.setText("");
           txtprecionueva.setText("");
           lblImagen.setIcon(null);
           
           
    }//GEN-LAST:event_botonBonito7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bienvenida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaVentas;
    private BotonBonito botonBonito1;
    private BotonBonito botonBonito2;
    private BotonBonito botonBonito3;
    private BotonBonito botonBonito4;
    private BotonBonito botonBonito5;
    private BotonBonito botonBonito6;
    private BotonBonito botonBonito7;
    private componente.BotonGenerarPDF botonGenerarPDF1;
    private BotonBonito btnGuardar;
    private javax.swing.JButton btnsubirimg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblTotalVentas;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTabbedPane tabbedPanePrincipal;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtMarcaModelo;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtam;
    private javax.swing.JTextField txtap;
    private javax.swing.JTextField txtcolonia;
    private javax.swing.JTextField txtprecionueva;
    // End of variables declaration//GEN-END:variables
}
