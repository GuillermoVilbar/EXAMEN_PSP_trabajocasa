package Ejercicios_2a_2b;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.io.File;



public class Auditor {

	public static void main(String[] args) throws InterruptedException, IOException {

		List<ProcessBuilder> pb = new ArrayList<>();
		List<Process> procesos = new ArrayList<>();

		Path fichero = Path.of("comandos.txt");
		Path ruta = Path.of("logs");
		if(!Files.exists(ruta)) {
			Files.createDirectories(ruta);
		}

		
		try(BufferedReader w = Files.newBufferedReader(fichero)){

			String linea;

			while((linea = w.readLine())!=null) {

				if(!linea.isBlank() && !linea.startsWith("#")) {

					String[] comandos = linea.split("\\s");

					pb.add(new ProcessBuilder(comandos));
				}
			}
		} catch (IOException e) {
			System.out.println("ERROR " + e.getMessage());
		}
		int contador =0;
		for(ProcessBuilder p : pb) {
			contador++;
			p.directory(ruta.toFile());

			p.redirectOutput(new File(ruta.toFile(),"tarea-" + contador + ".txt"));
			p.redirectErrorStream(true);

			procesos.removeIf(proc -> !proc.isAlive());

			while(procesos.size()>=2) {

				Thread.sleep(500);
				procesos.removeIf(proc -> !proc.isAlive());
			}
			Process proceso = p.start();
			if(proceso.isAlive()) {
				procesos.add(proceso);
			}

		}
		int exitos =0;
		int fallos =0;

		for(Process p : procesos) {
			int codigo = p.waitFor();
			if(codigo == 0) {
				exitos++;
			}else {
				fallos++;
			}


		}

		System.out.println("AUDITORIA INFORME");
		System.out.println("Tareas correctas(0):" + exitos);
		System.out.println("tareas con fallos (!=0) " + fallos);
		System.exit(fallos ==0? 0:1);





	}

}
