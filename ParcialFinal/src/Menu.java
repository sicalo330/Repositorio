import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Menu extends JFrame {
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
					Menu frame = new Menu();
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
	public Menu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre del juego");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(332, 37, 173, 58);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Jugar");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	Menu ventanaPrincipal = Menu.this;//Lo último hace referencia a la instancia actual, es cómo decirle a Java que ventanaPrincipal es la instancia actual
		        Juego juego = new Juego();
		        juego.setVisible(true);//Hace visible la ventana para la sección de zapatos de hombre deportivo
		        ventanaPrincipal.setVisible(false);//Hace invisible a la ventana principal pero no lo borra, esto para poder volver después de ser necesario
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(343, 348, 162, 45);
		contentPane.add(btnNewButton);
		
		JLabel fondoMenu = new JLabel("");
		fondoMenu.setIcon(new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\fondoMenu.png"));
		fondoMenu.setBounds(0, 0, 861, 556);
		contentPane.add(fondoMenu);
	}
}
