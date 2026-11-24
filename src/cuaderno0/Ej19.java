package cuaderno0;

import java.io.BufferedReader;

public class Ej19 {

	public static void main(String[] args) throws Exception {
		long t0 = System.currentTimeMillis();
		Process hijo = Lanzador.para("cuaderno0.Cuenta", "100000").start();
		long lineas = 0;
		try (BufferedReader r = hijo.inputReader()) {
			lineas = r.lines().count(); // leer vacía la tubería
		}
		int codigo = hijo.waitFor(); // ahora sí termina
		long ms = System.currentTimeMillis() - t0;
		System.out.println("Líneas: " + lineas + ", código " + codigo
				+ ", " + ms + " ms");
	}

}
