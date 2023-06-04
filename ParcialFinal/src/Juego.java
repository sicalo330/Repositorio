import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.lang.Math;
import java.awt.Color;

public class Juego extends JFrame implements Observador { // Observador
    Control control;
    MoverCosas moverCosas;
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
    public JLabel poder = null; // Item del juego
    public int limite = 0;
    public boolean aux;
    public boolean terminar = false;
    public double vidaEnemigo = 100.0;
    public double quitarVida = 0.1;
    public int aparicion;
    public int x;
    public int y;
    private int amplitud = 20; // Ajusta la amplitud del movimiento senoidal
    private double tiempo = 0; // Variable de tiempo para controlar el movimiento


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Juego frame = new Juego();
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
    public Juego() {

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        moverCosas = new MoverCosas(this);
        moverCosas.start();

        control = new Control(this);
        this.addKeyListener(control);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 731, 551);
        contentPane_1 = new JPanel();
        contentPane_1.setBackground(new Color(255, 255, 255));
        contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane_1);
        contentPane_1.setLayout(null);

        nave = new JLabel("");
        nave.setIcon(new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\nuevaNave.png"));
        nave.setBounds(10, 353, 82, 52);
        contentPane_1.add(nave);

        enemigo.setBounds(468, 199, 113, 105);
        contentPane_1.add(enemigo);
        enemigo.setIcon(new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\Enemigo genérico.png"));

        notificador = new Notificador(nave, this);
        notificador.addObserver(nave);
    }

    public void UbicarNave() {
    	if(nave.getX()< -30) {
    		nave.setLocation(690, nave.getY());
    	}
    	if(nave.getX()>690) {
    		nave.setLocation(-30, nave.getY());
    	}
    	if(nave.getY()< -30) {
    		nave.setLocation(nave.getX(), 533);
    	}
    	if(nave.getY()> 533) {
    		nave.setLocation(nave.getX(), -30);
    	}
    }

    public void moverEnemigos() {
        int velocidad = 2;
        int posY = (int) (enemigo.getY() + amplitud * Math.sin(tiempo));
        enemigo.setLocation(enemigo.getX() - velocidad, posY);
        tiempo += 0.1;
        if(enemigo.getX() < -30) {
        	enemigo.setLocation(690, posY);
        }
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
            if (bala == null || bala.getX() > 800) { // Verifica si no hay una bala existente o si la bala actual ha salido de la pantalla
                bala = new JLabel(""); // Crea un nuevo objeto JLabel para representar la bala
                ImageIcon icon = new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\BalaReducida.png");
                bala.setBounds(nave.getX() + 90, nave.getY() - 70, 100, 200);
                bala.setIcon(icon);
                contentPane_1.add(bala);
                revalidate();
                repaint();
            }
        }
    }

    public void verificar() {
        this.aparicion = (int)(Math.random() * 100);
        this.x = (int)(Math.random() * 400);
        this.y = (int)(Math.random() * 400);
        if(aparicion == 1 && (poder == null || poder.getX()>=5000)) {
        	poder = new JLabel("");
        	ImageIcon iconPoder = new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\item_poder.png");
        	poder.setBounds(this.x, this.y, 90, 46);
            poder.setIcon(iconPoder);
            contentPane_1.add(poder);
            revalidate();
            repaint();
        }
        if (enemigo.getX() < (nave.getX() + 82) && (enemigo.getX() + 82) > nave.getX() && (nave.getY() + 52) > enemigo.getY() && (enemigo.getY() + 105) > nave.getY()) {
             Juego juego = Juego.this; GameOver gameOver = new GameOver();
             gameOver.setVisible(true); juego.setVisible(false); this.terminar = true;
             moverCosas.run();
             
        }
        if (bala != null && bala.getX() + 100 > enemigo.getX() && bala.getX() < enemigo.getX() + 100 && bala.getY() + 100 > enemigo.getY() && bala.getY() < enemigo.getY() + 52) {
            this.vidaEnemigo = this.vidaEnemigo - quitarVida;;
            bala.setLocation(6000, 5000);
            if (vidaEnemigo <= 0) {
                enemigo.setLocation(5000, 5000);
                Juego ventanaJuego = Juego.this;//Lo último hace referencia a la instancia actual, es cómo decirle a Java que ventanaPrincipal es la instancia actual
		        Final ventanaFinal = new Final();
		        ventanaFinal.setVisible(true);//Hace visible la ventana para la sección de zapatos de hombre deportivo
		        ventanaJuego.setVisible(false);//Hace invisible a la ventana principal pero no lo borra, esto para poder volver después de ser necesario
            }
        }
    }

    @Override
    public void update() {
        this.quitarVida += 0.5;

    }
}

