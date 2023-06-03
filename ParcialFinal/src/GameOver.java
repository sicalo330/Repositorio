import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class GameOver extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOver frame = new GameOver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameOver() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton volverMenu = new JButton("Menú");
		volverMenu.setBackground(Color.BLACK);
		volverMenu.setForeground(Color.WHITE);
		volverMenu.setBounds(306, 327, 89, 23);
		contentPane.add(volverMenu);
		
		JLabel fondoGameOver = new JLabel("");
		fondoGameOver.setIcon(new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\fondoGameOver.png"));
		fondoGameOver.setBounds(0, 0, 694, 427);
		contentPane.add(fondoGameOver);
		volverMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	GameOver gameOverPrincipal = GameOver.this;//Lo último hace referencia a la instancia actual, es cómo decirle a Java que ventanaPrincipal es la instancia actual
		        Menu menu = new Menu();
		        menu.setVisible(true);//Hace visible la ventana para la sección de zapatos de hombre deportivo
		        gameOverPrincipal.setVisible(false);//Hace invisible a la ventana principal pero no lo borra, esto para poder volver después de ser necesario
			}
		});
	}

}
