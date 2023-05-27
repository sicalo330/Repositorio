public abstract class DecoradorDisparar implements Disparar {//	Decorador abstracto
	
	protected Disparar disparar;
	DispararLaser dispararLaser;
	DispararBomba dispararBomba;
	
	public DecoradorDisparar(Disparar disparar) {
		this.disparar = disparar;
	}
	
	
	@Override
	public void disparo() {
		System.out.println("Va a la base");
		this.disparar.disparo();
	}
	
	@Override
	public void bomba() {
		System.out.println("Va a la base");
		this.disparar.bomba();
	}
	
}
