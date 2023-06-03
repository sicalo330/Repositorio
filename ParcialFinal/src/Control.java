import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class Control implements ActionListener, KeyListener {
	Juego juego;
    boolean derecha = false;
    boolean izquierda = false;
    boolean subir = false;
    boolean bajar = false;
    boolean disparar = false;
    boolean bomba = false;
    Timer timer = new Timer(1, this); // Cada 10 milisegundos se activará el ActionListener
    
    
    public Control(Juego juego) {
        this.juego = juego;
    }
    
    public void actionPerformed(ActionEvent evento) {
         juego.bala.setLocation(juego.bala.getX() + 30, juego.bala.getY());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No se necesita implementar este método en este caso
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            subir = true;
            juego.subir();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            derecha = true;
            juego.derecha();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            izquierda = true;
            juego.izquierda();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            bajar = true;
            juego.bajar();
        }
        if (e.getKeyCode() == KeyEvent.VK_Z) {
        	disparar = true;
        	juego.disparar();
        	timer.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            subir = false;
            juego.subir();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            derecha = false;
            juego.derecha();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            izquierda = false;
            juego.izquierda();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            bajar = false;
            juego.bajar();
        }
        if (e.getKeyCode() == KeyEvent.VK_Z) {
        	disparar = false;
        	juego.disparar();
        }
    }
}

