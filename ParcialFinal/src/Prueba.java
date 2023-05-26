import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Prueba extends JFrame {
	Control control;
	MoverFondo moverFondo;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPane_1;
	public JLabel personaje;
	private final JLabel enemigo = new JLabel("");
	

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

	    personaje = new JLabel("");
	    personaje.setIcon(new ImageIcon("C:\\Users\\noah_\\Downloads\\Nave.png"));
	    personaje.setBounds(59, 339, 259, 112);
	    contentPane_1.add(personaje);
	    System.out.println("Posición del personaje: " + personaje.getY() + "," + personaje.getX());
	    
	    enemigo.setBounds(626, 318, 113, 105);
	    contentPane_1.add(enemigo);
	    enemigo.setIcon(new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\Enemigo genérico.png"));
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
			personaje.setLocation(personaje.getX(), personaje.getY() - 20);
			//System.out.println("Subiendo");
		}
	}

	public void izquierda() {
		if (control.izquierda == true) {
			personaje.setLocation(personaje.getX() - 20, personaje.getY());
			//System.out.println("izquierda");
		}
	}

	public void derecha() {
		if (control.derecha == true) {
			personaje.setLocation(personaje.getX() + 20, personaje.getY());
			//System.out.println("derecha");
		}
		// TODO: update character position and/or change image
	}

	public void bajar() {
		if (control.bajar == true) {
			personaje.setLocation(personaje.getX(), personaje.getY() + 20);
			//System.out.println("bajando");
		}
		// TODO: update character position and/or change image
	}

	public void verificarColision() {
		if (enemigo.getX() < (personaje.getX() + 96) && (enemigo.getX() + 96) > personaje.getX()
				&& (personaje.getY() + 96) > enemigo.getY()) {
			//System.out.println("Colisión");
		} else {
			//System.out.println("No hay colisión");
		}
	}
}
