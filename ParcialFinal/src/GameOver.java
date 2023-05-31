import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton volverMenu = new JButton("Menú");
		volverMenu.setBounds(168, 152, 89, 23);
		contentPane.add(volverMenu);
		volverMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	GameOver gameOverPrincipal = GameOver.this;//Lo último hace referencia a la instancia actual, es cómo decirle a Java que ventanaPrincipal es la instancia actual
		        Menu menu = new Menu();
		        menu.setVisible(true);//Hace visible la ventana para la sección de zapatos de hombre deportivo
		        gameOverPrincipal.setVisible(false);//Hace invisible a la ventana principal pero no lo borra, esto para poder volver después de ser necesario
			}
		});
		
		JLabel lblNewLabel = new JLabel("Fin del juego");
		lblNewLabel.setBounds(168, 11, 92, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
	}

}
