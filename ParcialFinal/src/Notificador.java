import javax.swing.JLabel;

public class Notificador implements Observable {//Observable
	Juego juego;
	JLabel jugador;
	MoverFondo moverFondo;
	
	public Notificador(JLabel jugador, Juego juego) {//90 46
		this.jugador = jugador;
		this.juego = juego;
	}

	@Override
	public void addObserver(JLabel jugador) {
		if (juego.poder != null && (jugador.getX() < (juego.poder.getX() + 90) && (jugador.getX() + 62) > juego.poder.getX() && (juego.poder.getY() + 46) > jugador.getY() && juego.poder.getY() < jugador.getY() + 112)){
			juego.poder.setLocation(5000, 5000);
			juego.update();
			
		} 
		
	}

	@Override
	public void notificar() {
		// TODO Auto-generated method stub
		
	}


}
