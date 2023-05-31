import javax.swing.JLabel;

public interface Item{
	void addObserver(JLabel item);
	void notificar();
}
