package Ejercicios_2a_2b;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Monitor {
	public static void main(String[] args) throws InterruptedException, IOException {

		Path fichero = Path.of("datos.txt");
		Path carpeta = Path.of("trabajo");
		if(!Files.exists(carpeta)) {
			Files.createDirectories(carpeta);
		}

		List<ProcessBuilder> pbs = new ArrayList<>();
		List<Process> procesos = new ArrayList<>();





		try(BufferedReader w = Files.newBufferedReader(fichero)){
			String linea;
			int n =0;
			while((linea = w.readLine())!=null) {
				if(!linea.isBlank() && !linea.startsWith("#")) {
					n++;
					String[] comandos = linea.split("\\s+");
					pbs.add(new ProcessBuilder(comandos));

				}


			}

		} catch (IOException e) {

			System.out.println("ERROR" + e.getMessage());
		}
		int contador =0;
		for(ProcessBuilder p : pbs) {
			contador++;
			p.directory(carpeta.toFile());

			p.redirectOutput(new File(carpeta.toFile(),"tarea-" + contador + ".txt"));
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

