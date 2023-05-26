import javax.swing.JLabel;

public class MoverFondo extends Thread {
    Prueba prueba;
    JLabel moverFondo;

    public MoverFondo(Prueba prueba){
        this.prueba = prueba;
    }

    public void setMoverFondo(JLabel moverFondo) {
        this.moverFondo = moverFondo;
    }

    public void run() {
        try {
            while(true) {
            	Thread.sleep(10);
            	prueba.subir();
                prueba.derecha();
                prueba.izquierda();
                prueba.bajar();
                prueba.moverEnemigos();
                prueba.verificarColision();
            }
        }
        catch(Exception e) {
            System.out.println("Error en la ejecución" + e);
        }
    }

    public int getY() {
        return moverFondo.getY();
    }

    public int getX() {
        return moverFondo.getX();
    }
}