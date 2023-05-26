
public abstract class DecoradorDispararBala implements Disparar {//	Decorador abstracto
	
	protected Disparar disparar;
	
	public DecoradorDispararBala(Disparar disparar) {
		this.disparar = disparar;
	}
	
	
	@Override
	public void disparo() {
		this.disparar.disparo();
	}
	
	@Override
	public void bomba() {
		this.disparar.bomba();
	}
	
}
