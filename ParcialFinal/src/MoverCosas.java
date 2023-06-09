import javax.swing.JLabel;

public class MoverCosas extends Thread {
    Juego juego;
    JLabel moverFondo;
    Notificador notificador;

    public MoverCosas(Juego juego){
        this.juego = juego;
        this.notificador = new Notificador(juego.nave, juego);
    }

    public void run() {
        try {
            while(true) {
            	if(juego.terminar) {
            		System.out.println("Fin del juego");
            		break;
            	}
            	else {
                	Thread.sleep(10);
                	juego.subir();
                	juego.derecha();
                	juego.izquierda();
                	juego.bajar();
                	juego.moverEnemigos();
                	juego.UbicarNave();
                	juego.verificar();
                    notificador.addObserver(juego.nave);
            	}
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