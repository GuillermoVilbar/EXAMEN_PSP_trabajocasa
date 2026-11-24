package cuaderno0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Filtra {

	public static void main(String[] args) throws IOException {
		BufferedReader entrada = new BufferedReader(
				new InputStreamReader(System.in));
		String linea;
		while ((linea = entrada.readLine()) != null) {
			if (linea.contains(args[0])) {
				System.out.println(linea);
			}
		}
	}

}
