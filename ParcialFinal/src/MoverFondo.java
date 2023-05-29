import javax.swing.JLabel;

public class MoverFondo extends Thread {
    Prueba prueba;
    JLabel moverFondo;
    Notificador notificador;

    public MoverFondo(Prueba prueba){
        this.prueba = prueba;
        this.notificador = new Notificador(prueba.nave, prueba);
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
                notificador.addObserver(prueba.nave);
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