package ejemplos_puestaApunto4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FiltroLinea {

	public static void main(String[] args) {
		
		try(BufferedReader w = new BufferedReader(
			new InputStreamReader (System.in, StandardCharsets.UTF_8))) {
			
			String linea;
			int n =0;
			while((linea = w.readLine()) !=null) {
			String mayus=	linea.toUpperCase();
				if(mayus.startsWith("A")) {
					n++;
					System.out.println(n + "lineas empiezan con A" + mayus);
					
				}
				
			}
				
				
				
				
			
			
		}catch(Exception e) {
			System.out.println("ERROR " + e.getMessage());
		
		}
	}
}
		


	

