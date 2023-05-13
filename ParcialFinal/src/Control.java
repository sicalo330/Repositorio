import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control implements ActionListener, KeyListener {
	Prueba prueba;
	boolean derecha = false;
	boolean izquierda = false;
	boolean subir = false;
	public Control(Prueba prueba) {
		this.prueba = prueba;
	}
	
	public void actionPerformed(ActionEvent evento) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {// Se dispara cuando el usuario tipea una tecla en el teclado, es decir, cuando la tecla se mantiene presionada el tiempo suficiente para que se repita o se genere un carácte
		
	}

	@Override
	public void keyPressed(KeyEvent e) {//Captura qué tecla se presiona
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(prueba.bajando ==  true) {
				subir = false;
				prueba.subir();
			}
			if(prueba.piso == true) {
				subir = true;
				prueba.subir();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			derecha = true;
			prueba.derecha();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			izquierda = true;
			prueba.izquierda();
		}
		System.out.println(e.getKeyCode());// arriba = 38, abajo = 40, derecha = 39, isquierda = 37
		
	}//La anormalidad del movimiento del personaje es el hecho de que captura dos veces la tecla, cuando lo pulso y cuando dejo de hacerlo

	@Override
	public void keyReleased(KeyEvent e) {//Se dispara cuando el usuario suelta una tecla en el teclado
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			prueba.bajando = true;
			subir = false;
			prueba.subir();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			derecha = false;
			prueba.derecha();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			izquierda = false;
			prueba.izquierda();
		}
		System.out.println(e.getKeyCode());
	}
}
