/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class fondodegradado extends JPanel {
 public fondodegradado() {
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Fondo negro semi-transparente como en la imagen
     Color colorTop = new Color(0, 0, 0, 200);
Color colorBottom = new Color(40, 40, 40, 160);
        
        GradientPaint gp = new GradientPaint(
            0, 0, colorTop,
            0, getHeight(), colorBottom
        );
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
        
        // Borde sutil para darle más definición
        g2d.setColor(new Color(255, 255, 255, 40));
        g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
}

