/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


/**
 *
 * @author jared
 */
public class Correo {
     public static void enviarCorreoConPDF(String destinatario, String archivoPDF) {
        final String remitente = "tumotorun@gmail.com";
        final String password = "pwilkkgxgqdgcnim";
         

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, password);
            }
        });

        try {
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(remitente));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject("Registro exitoso - PDF adjunto");

            // Parte del cuerpo
            BodyPart texto = new MimeBodyPart();
            texto.setText("Hola, tu registro fue exitoso, Bienvenido a la mejor tienda de motos ¡MotoRun!. Se adjunta tu comprobante con tus datos en PDF.");

            // Parte del archivo
            MimeBodyPart adjunto = new MimeBodyPart();
            DataSource fuente = new FileDataSource(archivoPDF);
            adjunto.setDataHandler(new DataHandler(fuente));
            adjunto.setFileName(archivoPDF);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(texto);
            multipart.addBodyPart(adjunto);

            mensaje.setContent(multipart);

            Transport.send(mensaje);
            System.out.println("Correo enviado con PDF adjunto.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
}
