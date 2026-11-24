package ejemplos_puestaApunto4;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;



public class Ejercicio1 {

	public static void main(String[] args) {
		
		Path ruta = Path.of("datos.txt");
		
		try(BufferedWriter w = Files.newBufferedWriter(ruta)){
			
			String linea;
			
			w.write("hola");
			w.write("aun no se que hacer \n"
					+ "seguro q nada nuevo");
			
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("ya termino el proceso");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}

}
