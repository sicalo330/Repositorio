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
	
	
	public void disparo() {
		if(control.disparar) {
	        JLabel label = new JLabel("");//Creo un label
	        label.setBounds(prueba.personaje.getX() + 259, prueba.personaje.getY() - 40, 100, 200);//se establece el label en x,y, ancho, altura respectivamente
	        ImageIcon icon = new ImageIcon("C:\\Users\\noah_\\OneDrive\\Escritorio\\Bala.png");//El icono del label
	        label.setIcon(icon);//Pone el icono
	        prueba.getContentPane().add(label);//Lo muestra
	        prueba.revalidate();
	        prueba.repaint();
		}
	}

}
