package Ejercicios_2a_2b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class LectorProceso {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		boolean windows = System.getProperty("os.name").toLowerCase().contains("win");
		ProcessBuilder pb ;
		if(windows) {
			pb = new ProcessBuilder("ping", "127.0.0.1");
		}else {
		
			pb = new ProcessBuilder("ping", "-c" , "4", "127.0.0.1");
		}
			
		
		Process proceso = pb.start();
		
		try( BufferedReader w = new BufferedReader(new InputStreamReader(proceso.getInputStream(), StandardCharsets.UTF_8))){
			String linea;
			int contadorLineas =0;
			
			while((linea=w.readLine())!=null) {
				contadorLineas++;
				System.out.println("HIJO: " + contadorLineas+ linea);
			}
			
		}catch(IOException e) {
			System.out.println("ERROR" +e.getMessage());
		}
		int codigo = proceso.waitFor();
		System.out.println("salio con codigo " + codigo);
		}
		
		
		
	}


