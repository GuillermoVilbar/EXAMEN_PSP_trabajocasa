package Ejercicios_2a_2b;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Supervisor {

	public static void main(String[] args) throws IOException, InterruptedException {
		
	
	Path fichero = Path.of("tareas.txt");
	
	List<ProcessBuilder> procesos = new ArrayList<>();
	List<Process> procesosIniciados = new ArrayList<>();
	
	try(BufferedReader w = Files.newBufferedReader(fichero, StandardCharsets.UTF_8)){
		String linea;
		int numero =0;
		
		
		while((linea=w.readLine())!=null) {
			
			if(!linea.isBlank() && !linea.trim().startsWith("#")) {
				numero++;
				String[]comandos = linea.split("\\s+");
				
		 procesos.add(new ProcessBuilder(comandos));
				
		}
		}

	}catch(IOException e) {
		System.out.println("ERROR " + e.getMessage());
	}
	
	for(ProcessBuilder p : procesos) {
		p.inheritIO();
		
		procesosIniciados.removeIf(proc -> !proc.isAlive());
		
		while(procesosIniciados.size() >=3) {
			Thread.sleep(500);
			procesosIniciados.removeIf(proc -> !proc.isAlive());
	}
		
		
		Process proceso = p.start();
		if(proceso.isAlive()) {
			procesosIniciados.add(proceso);	
			}
	}
	 
		
		
	}
}

