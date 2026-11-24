package ejemplos_puestaApunto4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Filtra {

	public static void main(String[] args) {
		if(args.length ==0) {
			System.err.println("Uso: java Filtra <palabra>");
			System.exit(2);
			
			
		};
		boolean encontrado = false;
		String minusculas = args[0].toLowerCase();
		
		try(BufferedReader w = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))){
			String linea;
			
			while ((linea = w.readLine()) != null) {
			    // Comprobamos si la línea contiene la palabra clave (ignorando mayúsculas/minúsculas)
			    if (linea.toLowerCase().contains(minusculas)) {
			        System.out.println(linea); // La escribimos en la salida estándar
			        encontrado = true;          // Marcamos que al menos hemos encontrado una
			    }
			}

			// Códigos de salida finales según si hubo coincidencias o no
			if (encontrado) {
			    System.exit(0); // Éxito: encontró líneas
			} else {
			    System.exit(1); // Fallo/No encontrado: ninguna línea coincidía
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
