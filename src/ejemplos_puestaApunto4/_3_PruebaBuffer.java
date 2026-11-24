package ejemplos_puestaApunto4;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _3_PruebaBuffer {

	public static void main(String[] args) {
		
		Path ruta = Path.of("prueba.txt");
		try(BufferedWriter w = Files.newBufferedWriter(ruta)) {
			w.write("Estyo es una prubea de bufer");
			w.newLine();
			
			long tamañoAntes = Files.size(ruta);
			System.out.println("Tamaño antes del flush" +  tamañoAntes + "bytes");
			
			w.flush();
			long tamañoAhora = Files.size(ruta);
			System.out.println("Ahora pesa: " + tamañoAhora + "bytes");
		} catch(IOException e) {
			System.err.println("ERROR" + e.getMessage());
			
			
		
	
	
		
	}
}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

