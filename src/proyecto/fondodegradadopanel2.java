/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import javax.swing.JPanel;

/**
 *
 * @author jared
 */
public class fondodegradadopanel2 extends JPanel {
    public fondodegradadopanel2() {
        // Esto permite que el JPanel se redibuje correctamente cuando cambie de tamaño
        setOpaque(false);
    }
       @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Colores del degradado
       Color color2 = new Color(0,0,0); 
       Color color1 = new Color(21, 9, 81);  
       
       // Morado intenso
        // Crear el degradado vertical
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
    
}
