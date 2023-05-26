import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control implements ActionListener, KeyListener {
    Prueba prueba;
    DispararBomba dispararBomba;
    DispararLaser dispararLaser;
    Disparar disparar_1;
    boolean derecha = false;
    boolean izquierda = false;
    boolean subir = false;
    boolean bajar = false;
    boolean disparar = false;
    boolean bomba = false;
    
    
    
    public Control(Prueba prueba) {
        this.prueba = prueba;
        this.dispararLaser = new DispararLaser(this.disparar_1,this, this.prueba);
        this.dispararBomba = new DispararBomba(this.disparar_1,this, this.prueba);
    }
    
    public void actionPerformed(ActionEvent evento) {
        
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
        	dispararLaser.disparo();
        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
        	bomba = true;
        	dispararBomba.bomba();
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
        	dispararLaser.disparo();
        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
        	bomba = false;
        	dispararBomba.bomba();
        }
    }
}

