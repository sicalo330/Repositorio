import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Prueba extends JFrame implements Jugador { // Observador
    Control control;
    MoverFondo moverFondo;
    Notificador notificador;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel contentPane_1;
    public JLabel nave;
    public JLabel bala;
    public final JLabel enemigo = new JLabel("");
    public JLabel vida; // Item del juego
    public int limite = 0;
    public boolean aux;
    public boolean terminar = false;
    public double vidaEnemigo = 2.0;
    public double quitarVida = 1.0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Prueba frame = new Prueba();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error en la ejecución");
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Prueba() {
        vida = new JLabel(); // Inicialización de la variable vida

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        moverFondo = new MoverFondo(this);
        moverFondo.start();

        control = new Control(this);
        this.addKeyListener(control);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 731, 551);
        contentPane_1 = new JPanel();
        contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane_1);
        contentPane_1.setLayout(null);

        nave = new JLabel("");
        nave.setIcon(new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\nuevaNave.png"));
        nave.setBounds(10, 353, 82, 52);
        contentPane_1.add(nave);
        System.out.println("Posición del personaje: " + nave.getY() + "," + nave.getX());

        enemigo.setBounds(689, 324, 113, 105);
        contentPane_1.add(enemigo);
        enemigo.setIcon(new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\Enemigo genérico.png"));

        vida = new JLabel("");
        vida.setIcon(new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\Vida.png"));
        vida.setBounds(109, 88, 62, 52);
        contentPane_1.add(vida);

        notificador = new Notificador(nave, this);
        notificador.addObserver(nave);
    }

    public void moverFondo() {
        JLabel fondo = (JLabel) contentPane_1.getComponent(2);
        fondo.setLocation(fondo.getX() - 2, fondo.getY());
    }

    public void moverEnemigos() {
        enemigo.setLocation(enemigo.getX() - 5, enemigo.getY());
    }

    public void subir() {
        if (control.subir == true) {
            nave.setLocation(nave.getX(), nave.getY() - 20);
            // System.out.println("Subiendo");
        }
    }

    public void izquierda() {
        if (control.izquierda == true) {
            nave.setLocation(nave.getX() - 20, nave.getY());
            // System.out.println("izquierda");
        }
    }

    public void derecha() {
        if (control.derecha == true) {
            nave.setLocation(nave.getX() + 20, nave.getY());
            // System.out.println("derecha");
        }
        // TODO: update character position and/or change image
    }

    public void bajar() {
        if (control.bajar == true) {
            nave.setLocation(nave.getX(), nave.getY() + 20);
            // System.out.println("bajando");
        }
        // TODO: update character position and/or change image
    }

    public void disparar() {
        if (control.disparar) {
            bala = new JLabel("");// Creo un label
            bala.setBounds(nave.getX() + 90, nave.getY() - 70, 100, 200);
            ImageIcon icon = new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\BalaReducida.png");
            bala.setIcon(icon);
            contentPane_1.add(bala);
            revalidate();
            repaint();
        }
    }

    public void verificarColision() {
        if (enemigo.getX() < (nave.getX() + 82) && (enemigo.getX() + 82) > nave.getX()
                && (nave.getY() + 52) > enemigo.getY() && (enemigo.getY() + 105) > nave.getY()) {
            System.out.println("Colisión");
            /*
             * Prueba juego = Prueba.this; GameOver gameOver = new GameOver();
             * gameOver.setVisible(true); juego.setVisible(false); this.terminar = true;
             * moverFondo.run();
             */
        }
        if (bala != null && bala.getX() + 100 > enemigo.getX() && bala.getX() < enemigo.getX() + 113 && bala.getY() + 200 > enemigo.getY() && bala.getY() < enemigo.getY() + 105) {
            System.out.println(vidaEnemigo);
            this.vidaEnemigo = this.vidaEnemigo - quitarVida;
            System.out.println(vidaEnemigo);
            this.aux = false;
            this.limite -= 1;
            if (vidaEnemigo <= 0) {
                enemigo.setLocation(5000, 5000);
            }
        }
    }

    @Override
    public void update() {
        System.out.println("La nave obtiene 1 de vida");

    }
}

