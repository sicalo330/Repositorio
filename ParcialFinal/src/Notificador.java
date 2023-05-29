import javax.swing.JLabel;

public class Notificador implements Item {//Observable
	Prueba prueba;
	JLabel item;
	
	public Notificador(JLabel item, Prueba prueba) {
		this.item = item;
		this.prueba = prueba;
	}

	@Override
	public void addObserver(JLabel item) {
		if (item.getX() < (prueba.vida.getX() + 62) && (item.getX() + 62) > prueba.vida.getX() && (prueba.vida.getY() + 100) > item.getY() && prueba.vida.getY() < item.getY() + 112) {
			System.out.println("Item adquirido");
			prueba.update();
			
		} else {
			System.out.println("Aún no");
		}
		
	}

	@Override
	public void removeObserver(JLabel item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificar() {
		// TODO Auto-generated method stub
		
	}


}
