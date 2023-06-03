import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class Final extends JFrame {

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
					Final frame = new Final();
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
	public Final() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Menú");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(278, 392, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 0, 657, 506);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\fondoVictoria.jpg"));
		contentPane.add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	Final finalPrincipal = Final.this;//Lo último hace referencia a la instancia actual, es cómo decirle a Java que ventanaPrincipal es la instancia actual
		        Menu menu = new Menu();
		        menu.setVisible(true);//Hace visible la ventana para la sección de zapatos de hombre deportivo
		        finalPrincipal.setVisible(false);//Hace invisible a la ventana principal pero no lo borra, esto para poder volver después de ser necesario
			}
		});
		
	}
}
