package ejemplos_puestaApunto4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ejercicioPrueba {

	public static void main(String[] args) {
		
		Path ruta = Path.of("clientes.txt");
		
		try(BufferedReader w = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)){
			String linea;
			int numeroLinea =0;
			while((linea = w.readLine())!=null) {
				if(!linea.isBlank()) {
					numeroLinea++;
					System.out.println(linea + " el numero delinae es" +numeroLinea);
					
				}
				
			}
			
			
		}catch(IOException e) {
			System.err.println("Error al leer el fichero"+e.getMessage());
			
		
		}
	}

}
