package cuaderno0;

public class Ej15 {

	public static void main(String[] args) throws Exception {
		System.out.println("--- destroy()");
		Process a = Lanzador.para("cuaderno0.Terco").inheritIO().start();
		Thread.sleep(1500); // le damos tiempo a arrancar
		a.destroy();
		System.out.println("Código: " + a.waitFor());
		System.out.println("--- destroyForcibly()");
		Process b = Lanzador.para("cuaderno0.Terco").inheritIO().start();
		Thread.sleep(1500);
		b.destroyForcibly();
		System.out.println("Código: " + b.waitFor());
	}
}
