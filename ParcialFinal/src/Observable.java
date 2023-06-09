import javax.swing.JLabel;

public interface Observable{
	void addObserver(JLabel jugador);
	void notificar();
}
