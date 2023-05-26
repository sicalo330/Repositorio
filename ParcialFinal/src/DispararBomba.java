public class DispararBomba extends DecoradorDisparar {
	Control control;
	Prueba prueba;

	public DispararBomba(Disparar disparar, Control control, Prueba prueba) {
		super(disparar);
		this.prueba = prueba;
		this.control = control;
	}
	
	@Override
	public void bomba() {
		if(control.bomba) {
	       System.out.println("Bomba");
		}
	}

}
