import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class Control implements ActionListener, KeyListener {
	Prueba prueba;
    boolean derecha = false;
    boolean izquierda = false;
    boolean subir = false;
    boolean bajar = false;
    boolean disparar = false;
    boolean bomba = false;
    Timer timer = new Timer(1, this); // Cada 10 milisegundos se activará el ActionListener
    
    
    public Control(Prueba prueba) {
        this.prueba = prueba;
    }
    
    public void actionPerformed(ActionEvent evento) {
         prueba.bala.setLocation(prueba.bala.getX() + 5, prueba.bala.getY());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No se necesita implementar este método en este caso
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            subir = true;
            prueba.subir();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            derecha = true;
            prueba.derecha();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            izquierda = true;
            prueba.izquierda();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            bajar = true;
            prueba.bajar();
        }
        if (e.getKeyCode() == KeyEvent.VK_Z) {
        	disparar = true;
        	prueba.disparar();
        	timer.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            subir = false;
            prueba.subir();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            derecha = false;
            prueba.derecha();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            izquierda = false;
            prueba.izquierda();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            bajar = false;
            prueba.bajar();
        }
        if (e.getKeyCode() == KeyEvent.VK_Z) {
        	disparar = false;
        	prueba.disparar();
        }
    }
}

