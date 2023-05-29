import javax.swing.JLabel;

public interface Item{//Observable
	void addObserver(JLabel item);
	void removeObserver(JLabel item);
	void notificar();
}
