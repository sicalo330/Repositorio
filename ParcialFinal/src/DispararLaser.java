import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DispararLaser extends DecoradorDisparar {
	
	Control control;
	Prueba prueba;
	Disparar disparar;
	
	public DispararLaser(Disparar disparar, Control control, Prueba prueba) {
		super(disparar);
		this.prueba = prueba;
		this.control = control;
	}
	
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

}
