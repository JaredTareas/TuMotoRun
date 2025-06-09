

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.io.InputStream;

/**
 *
 * @author jared
 */
class BotonBonito extends JButton{
    // Rutas de los iconos que se pueden usar en el botón
    private final String[] rutasIconos = {
        "icono1.png", "icono2.png", "icono3.png",
        "icono4.png", "icono5.png", "icono6.png"
    };
    private int indiceIcono = 0; // Índice del icono actual

    // Rutas de los sonidos que se pueden reproducir al hacer clic
    private final String[] rutasSonidos = {
        "click.wav", "click2.wav"
    };
    private int indiceSonido = 0; // Índice del sonido actual

    // Colores para el fondo del botón
    private Color colorInicio = new Color(124, 8, 249);
    private Color colorFin = new Color(40, 36, 44);
    private Color colorFinHover = new Color(135, 206, 250);
    private int radioBorde = 20; // Radio de los bordes redondeados

    // Variables para la animación de hover
    private float interpolador = 0f; // Interpolador para el efecto de hover
    private Timer animacionHover; // Timer para la animación de hover
    private boolean mouseEncima = false; // Estado del mouse sobre el botón

    // Variables para la animación de clic
    private float escala = 1.0f; // Escala del botón durante la animación
    private Timer animacionClick; // Timer para la animación de clic
    private int etapaRebote = 0; // Etapa actual de la animación de rebote

    private boolean sonidoActivo = true; // Estado del sonido
    private String rutaSonido = null; // Ruta de sonido personalizada (opcional)

    // Constructor de la clase
    public BotonBonito() {
        super("Aceptar"); // Texto del botón
        setContentAreaFilled(false); // No rellenar el área del botón
        setFocusPainted(false); // No pintar el foco
        setForeground(Color.WHITE); // Color del texto
        setFont(new Font("Segoe UI", Font.BOLD, 16)); // Fuente del texto

        cambiarIcono(0); // Cambiar al icono inicial

        // Inicializar la animación de hover
        animacionHover = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aumentar o disminuir el interpolador según el estado del mouse
                if (mouseEncima && interpolador < 1f) {
                    interpolador += 0.05f;
                    if (interpolador > 1f) interpolador = 1f;
                    repaint(); // Redibujar el botón
                } else if (!mouseEncima && interpolador > 0f) {
                    interpolador -= 0.05f;
                    if (interpolador < 0f) interpolador = 0f;
                    repaint(); // Redibujar el botón
                }
            }
        });
        animacionHover.start(); // Iniciar la animación de hover

        // Agregar un listener para el mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseEncima = true; // El mouse está sobre el botón
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseEncima = false; // El mouse salió del botón
            }

            @Override
            public void mousePressed(MouseEvent e) {
                animacionClick(); // Iniciar la animación de clic
                reproducirSonido(); // Reproducir el sonido
            }
        });
    }

    // Método para manejar la animación de clic
    private void animacionClick() {
        etapaRebote = 0; // Reiniciar la etapa de rebote
        if (animacionClick != null && animacionClick.isRunning()) {
            animacionClick.stop(); // Detener la animación si ya está en ejecución
        }

        // Crear un nuevo Timer para la animación de clic
        animacionClick = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (etapaRebote < 10) {
                    // Primera mitad: disminuir escala
                    if (etapaRebote < 5) {
                        escala = 1.0f - 0.1f * etapaRebote;
                    } 
                    // Segunda mitad: aumentar escala
                    else {
                        escala = 0.5f + 0.1f * (etapaRebote - 5);
                    }
                } else {
                    escala = 1.0f; // Restablecer escala
                    animacionClick.stop(); // Detener animación
                }
                etapaRebote++;
                repaint(); // Redibujar para reflejar cambios
            }
        });
        animacionClick.start(); // Iniciar animación
    }

    // Método para reproducir el sonido al hacer clic
    private void reproducirSonido() {
        if (!sonidoActivo) return; // Si sonido está desactivado, no hacer nada

        String rutaAUsar = null;

        // Priorizar la ruta personalizada si está definida
        if (rutaSonido != null && !rutaSonido.trim().isEmpty()) {
            rutaAUsar = rutaSonido;
        } 
        // Si no, usar la ruta del sonido seleccionado por índice
        else if (indiceSonido >= 0 && indiceSonido < rutasSonidos.length) {
            rutaAUsar = rutasSonidos[indiceSonido];
        } else {
            return; // No hay sonido válido para reproducir
        }

        try {
            InputStream sonidoStream = getClass().getResourceAsStream("/" + rutaAUsar);
            if (sonidoStream == null) {
                System.err.println("\u26A0 No se encontró el sonido: " + rutaAUsar);
                return;
            }
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sonidoStream);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.err.println("Error al reproducir sonido: " + ex.getMessage());
        }
    }

    /**
     * Cambia el icono del botón según el índice dado.
     * @param indice índice del icono dentro de rutasIconos
     */
    public void cambiarIcono(int indice) {
        if (indice >= 0 && indice < rutasIconos.length) {
            ImageIcon icono = cargarIconoEscalado(rutasIconos[indice], 24, 24);
            setIcon(icono);
            setHorizontalTextPosition(SwingConstants.RIGHT);
            setIconTextGap(10);
            this.indiceIcono = indice;
        }
    }

    /**
     * Cambia el sonido que se reproduce al hacer clic según el índice dado.
     * @param indice índice del sonido dentro de rutasSonidos
     */
    public void cambiarSonido(int indice) {
        if (indice >= 0 && indice < rutasSonidos.length) {
            this.indiceSonido = indice;
            this.rutaSonido = null; // Anula ruta personalizada si la había
        }
    }

    // Permite establecer una ruta de sonido personalizada para la reproducción
    public void setRutaSonido(String rutaSonido) {
        this.rutaSonido = rutaSonido;
    }

    // Permite activar o desactivar la reproducción de sonidos
    public void setSonidoActivo(boolean sonidoActivo) {
        this.sonidoActivo = sonidoActivo;
    }

    // Carga un icono escalado desde un recurso 
    private ImageIcon cargarIconoEscalado(String ruta, int ancho, int alto) {
        try {
            Image img = ImageIO.read(getClass().getResource("/" + ruta));
            Image imgEscalada = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            return new ImageIcon(imgEscalada);
        } catch (IOException e) {
            System.err.println("Error cargando imagen: " + ruta);
            return null;
        }
    }

    // Pintado personalizado del botón para manejar animaciones y gradientes
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Antialiasing para suavizar gráficos
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Interpolación del color para efecto hover
        int r = (int) (colorFin.getRed() + interpolador * (colorFinHover.getRed() - colorFin.getRed()));
        int gVal = (int) (colorFin.getGreen() + interpolador * (colorFinHover.getGreen() - colorFin.getGreen()));
        int b = (int) (colorFin.getBlue() + interpolador * (colorFinHover.getBlue() - colorFin.getBlue()));
        Color colorAnimado = new Color(r, gVal, b);

        // Crear gradiente de fondo
        GradientPaint gradiente = new GradientPaint(0, 0, colorInicio, w, h, colorAnimado);
        g2.setPaint(gradiente);

        // Calcular tamaño y posición teniendo en cuenta la escala para animación de clic (rebote)
        int escalaW = (int)(w * escala);
        int escalaH = (int)(h * escala);
        int x = (w - escalaW) / 2;
        int y = (h - escalaH) / 2;

        // Pintar fondo con borde redondeado y tamaño animado
        g2.fillRoundRect(x, y, escalaW, escalaH, radioBorde, radioBorde);

        g2.dispose();

        // Dibujar texto e icono escalados con transformación para mantener centrado
        Graphics2D g2Text = (Graphics2D) g.create();
        g2Text.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2Text.scale(escala, escala);
        int tx = (int)((float)w / (2 * escala) - (float)w / 2);
        int ty = (int)((float)h / (2 * escala) - (float)h / 2);
        g2Text.translate(tx, ty);

        super.paintComponent(g2Text);
        g2Text.dispose();
    }

    // Pintado personalizado del borde del botón
    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(new Color(255, 255, 255, 100)); // Borde semitransparente blanco
        g2.setStroke(new BasicStroke(2)); // Grosor de línea
        g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, radioBorde, radioBorde);
        g2.dispose();
    }

    // Getters y setters para personalizar colores y radio del borde

    public Color getColorInicio() {
        return colorInicio;
    }

    public void setColorInicio(Color colorInicio) {
        this.colorInicio = colorInicio;
        repaint();
    }

    public Color getColorFin() {
        return colorFin;
    }

    public void setColorFin(Color colorFin) {
        this.colorFin = colorFin;
        repaint();
    }

    public Color getColorFinHover() {
        return colorFinHover;
    }

    public void setColorFinHover(Color colorFinHover) {
        this.colorFinHover = colorFinHover;
        repaint();
    }

    public int getRadioBorde() {
        return radioBorde;
    }

    public void setRadioBorde(int radioBorde) {
        this.radioBorde = radioBorde;
        repaint();
    }
}
