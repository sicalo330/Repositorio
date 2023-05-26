public class DispararBala implements Disparar {//Componente concreto(BASE)
	Control control;
	Prueba prueba;
	
	public DispararBala() {
		
	}
	
	@Override
	public void disparo() {
		System.out.println("El laser se está moviendo");
	}

	@Override
	public void bomba() {
		System.out.println("BOOOOM");
		
	}
}
