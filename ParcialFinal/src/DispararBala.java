import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DispararBala implements Disparar {//Componente concreto(BASE)
	Control control;
	Prueba prueba;
	
	@Override
	public void disparo() {
		
		if(control.disparar) {
	        JLabel label = new JLabel("");
	        label.setBounds(prueba.personaje.getX() + 259, prueba.personaje.getY() - 40, 100, 200);//x,y, ancho, altura respectivamente
	        ImageIcon icon = new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\Bala.png");
	        label.setIcon(icon);
	        prueba.getContentPane().add(label);
	        prueba.revalidate();
	        prueba.repaint();
		}
	}

	@Override
	public void bomba() {
		if(control.bomba) {
	        JLabel label = new JLabel("");
	        label.setBounds(prueba.personaje.getX() + 259, prueba.personaje.getY() - 40, 100, 200);//x,y, ancho, altura respectivamente
	        ImageIcon icon = new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\Bala.png");
	        label.setIcon(icon);
	        prueba.getContentPane().add(label);
	        prueba.revalidate();
	        prueba.repaint();
		}
		
	}
}
