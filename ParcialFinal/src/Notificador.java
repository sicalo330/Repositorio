import javax.swing.JLabel;

public class Notificador implements Item {//Observable
	Prueba prueba;
	JLabel item;
	MoverFondo moverFondo;
	
	public Notificador(JLabel item, Prueba prueba) {//90 46
		this.item = item;
		this.prueba = prueba;
	}

	@Override
	public void addObserver(JLabel item) {
		if (prueba.poder != null && (item.getX() < (prueba.poder.getX() + 90) && (item.getX() + 62) > prueba.poder.getX() && (prueba.poder.getY() + 46) > item.getY() && prueba.poder.getY() < item.getY() + 112)){
			prueba.poder.setLocation(5000, 5000);
			prueba.update();
			
		} 
		
	}

	@Override
	public void notificar() {
		// TODO Auto-generated method stub
		
	}


}
