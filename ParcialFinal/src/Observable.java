import javax.swing.JLabel;

public interface Observable{
	void addObserver(JLabel item);
	void notificar();
}
