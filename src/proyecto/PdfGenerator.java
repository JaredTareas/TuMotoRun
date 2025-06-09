/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileOutputStream;

/**
 *
 * @author jared
 */
public class PdfGenerator {
     // Clase interna para agregar fondo de color
    static class FondoColor extends PdfPageEventHelper {
        private BaseColor color;

        public FondoColor(BaseColor color) {
            this.color = color;
        }

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte canvas = writer.getDirectContentUnder();
            Rectangle rect = document.getPageSize();
            canvas.setColorFill(color);
            canvas.rectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight());
            canvas.fill();
        }
    }

    public static String crearPDF(String correo, String nombre, String apellidoP, String apellidoM, String fecha, String genero, String rol) {
        String nombreArchivo = "registro_" + correo + ".pdf";
        try {
            Document documento = new Document();

            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(nombreArchivo));
            writer.setPageEvent(new FondoColor(new BaseColor(200, 220, 255))); // Azul cielo clarito

            documento.open();
            
           // Asegúrate de usar barras dobles en la ruta de Windows
Image logo = Image.getInstance("C:\\Users\\jared\\OneDrive\\Documentos\\NetBeansProjects\\pryecto\\src\\proyecto\\iconologin.jpg");
logo.scaleToFit(80, 80);
logo.setAbsolutePosition(documento.leftMargin(), documento.getPageSize().getHeight() - logo.getScaledHeight() - 10);
documento.add(logo);
            
            

            // Fuentes
            Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, new BaseColor(255, 140, 0)); // Naranja
            Font subTituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
            Font textoNormal = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

            // Crear párrafo para el título con borde
            Paragraph titulo = new Paragraph("REGISTRO DE USUARIO\n", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);

            // Para hacer el borde al título usamos un PdfPCell dentro de una tabla de 1 celda
            PdfPTable tablaTitulo = new PdfPTable(1);
            tablaTitulo.setWidthPercentage(50); // ancho del cuadro (ajusta si quieres)
            tablaTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);

            PdfPCell celdaTitulo = new PdfPCell();
            celdaTitulo.setBorderWidth(2f); // grosor del borde
            celdaTitulo.setBorderColor(new BaseColor(255, 140, 0)); // mismo naranja del texto
            celdaTitulo.setPadding(10f);
            celdaTitulo.setBackgroundColor(new BaseColor(255, 250, 240)); // fondo clarito, opcional
            celdaTitulo.setPhrase(titulo);

            tablaTitulo.addCell(celdaTitulo);

            documento.add(tablaTitulo);

            // Subtítulo
            Paragraph subtitulo = new Paragraph("TuMotoRun - La mejor tienda de motos\n\n", subTituloFont);
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(subtitulo);

            // Datos del usuario
            documento.add(new Paragraph("Correo: " + correo, textoNormal));
            documento.add(new Paragraph("Nombre: " + nombre, textoNormal));
            documento.add(new Paragraph("Apellido Paterno: " + apellidoP, textoNormal));
            documento.add(new Paragraph("Apellido Materno: " + apellidoM, textoNormal));
            documento.add(new Paragraph("Fecha de Nacimiento: " + fecha, textoNormal));
            documento.add(new Paragraph("Género: " + genero, textoNormal));
            
            Font fontRol = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Font.BOLD, BaseColor.BLUE);
Paragraph rolParrafo = new Paragraph("Rol: " + rol + "\n", fontRol);
rolParrafo.setSpacingBefore(10f);
rolParrafo.setSpacingAfter(10f);
documento.add(rolParrafo);

            // Contacto
            Paragraph contacto = new Paragraph("¿Dudas? Contacta al administrador:\n", subTituloFont);
            contacto.setSpacingBefore(15);
            documento.add(contacto);

            documento.add(new Paragraph("👑 Jaredsito: 9513571146", textoNormal));
           

            documento.close();
            return nombreArchivo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
