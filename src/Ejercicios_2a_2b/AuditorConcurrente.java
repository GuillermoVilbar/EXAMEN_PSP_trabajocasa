package Ejercicios_2a_2b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AuditorConcurrente {

	public static void main(String[] args) throws IOException, InterruptedException {

		Path archivo = Path.of("comandos.txt");
		if(!Files.exists(archivo)) {
			Files.createFile(archivo);
		}
		List<ProcessBuilder> pb = new ArrayList<>();
		List<Process> procesos = new ArrayList<>();
		List<Process> todosLosProcesos = new ArrayList<>();


		try(BufferedReader w = Files.newBufferedReader(archivo)){

			String linea;
			int contador =0;

			while((linea = w.readLine())!=null) {
				if(!linea.isBlank() && !linea.startsWith("#")) {
					contador++;
					String[] cadenas = linea.split("\\s+");
					pb.add(new ProcessBuilder(cadenas));
				}
			}


		}catch(IOException e) {
			System.out.println("error" + e.getMessage());
		}

		for(ProcessBuilder p : pb) {

			procesos.removeIf(proc -> proc.isAlive()==false);
			while(procesos.size()>=2) {
				Thread.sleep(500);
				procesos.removeIf(proc -> proc.isAlive()==false);

			}
			Process proceso = p.start();

			procesos.add(proceso);
			todosLosProcesos.add(proceso);

			try (BufferedReader wr = new BufferedReader(new InputStreamReader(proceso.getInputStream(), StandardCharsets.UTF_8))){
				String l;
				while((l=wr.readLine())!=null) {
					System.out.println("PROCESO ACTIVO " + l);
				}
			}catch(IOException e ) {
				System.out.println("ERROR" + e.getMessage());
			}
			
			try (BufferedReader errReader = new BufferedReader(new InputStreamReader(proceso.getErrorStream(), StandardCharsets.UTF_8))) {
				String errLine;
				while((errLine = errReader.readLine()) != null) {
					System.out.println("ERROR PROCESO: " + errLine);
				}
			} catch(IOException e) {
				System.out.println("ERROR LEYENDO ERRORES " + e.getMessage());
			}

		}

		int exitos =0;
		int fallos=0;
		for(Process pro : todosLosProcesos) {
			int codigo = pro.waitFor();
			if(codigo ==0) {
				exitos++;
			}else {
				fallos++;
			}

		}
		System.out.println("AUDITORIA");
		System.out.println("fallos : " + fallos);
		System.out.println("correctos " + exitos);
		System.exit(fallos ==0? 0 :1);


	}
}


