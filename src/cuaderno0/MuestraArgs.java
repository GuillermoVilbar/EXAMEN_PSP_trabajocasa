package cuaderno0;

public class MuestraArgs {
	public static void main(String[] args) {
		System.out.println("He recibido " + args.length + " argumentos:");
		for (String a : args) {
			System.out.println(" [" + a + "]");
		}
	}

}
