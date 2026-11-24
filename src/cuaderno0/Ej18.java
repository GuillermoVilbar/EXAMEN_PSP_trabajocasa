package cuaderno0;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ej18 {

	public static void main(String[] args) throws Exception {
		for (int n : new int[] {100, 100_000}) {
			Process hijo = Lanzador.para("cuaderno0.Cuenta",
					String.valueOf(n)).start(); // salida a tubería
			boolean termino = hijo.waitFor(5, TimeUnit.SECONDS);
			System.out.println(n + " líneas -> ¿terminó? " + termino);
			if (!termino) {
				hijo.destroyForcibly();
			}
		}
	}


}


