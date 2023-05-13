import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Prueba extends JFrame {
	Control control;
	boolean piso = true;
	boolean aire = false;
	boolean subiendo = false;
	boolean bajando = false;
	MoverFondo moverFondo;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPane_1;
	public JLabel personaje;
	private JLabel enemigo;

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

		JLabel lblNewLabel = new JLabel("Bienvenido al juego");
		lblNewLabel.setBounds(310, 10, 129, 65);
		contentPane_1.add(lblNewLabel);

		personaje = new JLabel("");
		personaje.setIcon(new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\Personaje genérico V2.png"));
		personaje.setBounds(153, 323, 89, 103);
		contentPane_1.add(personaje);
		//System.out.println("Posición del personaje: " + personaje.getY());//x=153 y=323
		
		enemigo = new JLabel("");
		enemigo.setIcon(new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\Enemigo genérico.png"));
		enemigo.setBounds(720, 323, 96, 103);
		contentPane_1.add(enemigo);
		enemigo.setLocation(720, 323);

		JLabel fondo = new JLabel("New label");
		fondo.setIcon(new ImageIcon("C:\\Users\\noah_\\Downloads\\WhatsApp Image 2023-05-03 at 11.53.31 AM.jpeg"));
		fondo.setBounds(10, 97, 695, 404);
		contentPane_1.add(fondo);
	}

	public void moverFondo() {
		JLabel fondo = (JLabel) contentPane_1.getComponent(2);
		fondo.setLocation(fondo.getX() - 2, fondo.getY());
	}
	
	public void moverEnemigos() {
		enemigo.setLocation(enemigo.getX()-5, enemigo.getY());
	}

	public void subir() {
		if(personaje.getY()<100) {
			bajando = true;
			piso = false;
			aire = true;
		}
		if(personaje.getY()>=323) {
			bajando = false;
			aire = false;
			piso = true;
			System.out.println("En el piso");
		}
		if(control.subir == true) {
			personaje.setLocation(personaje.getX(), personaje.getY() - 10);
			System.out.println("salto");
		}
		if(bajando == true) {
			aire = true;
			piso = false;
			personaje.setLocation(personaje.getX(), personaje.getY() + 10);
		}
		
		// TODO: update character position and/or change image
	}
	public void izquierda() {
		if(control.izquierda == true) {
			personaje.setLocation(personaje.getX() - 10, personaje.getY());
			System.out.println("izquierda");
		}
	}
	public void derecha() {
		if(control.derecha == true) {
			personaje.setLocation(personaje.getX() + 10, personaje.getY());
			System.out.println("derecha");
		}
		// TODO: update character position and/or change image
	}
	
	public void verificarColision() {
		if(enemigo.getX() < (personaje.getX()+96) && (enemigo.getX()+96)>personaje.getX() && (personaje.getY()+96)>enemigo.getY()) {//poner suma con parentesis
			//System.out.println("Colisión");
		}
		else {
			//System.out.println("No hay colisión");
		}
	}
}

