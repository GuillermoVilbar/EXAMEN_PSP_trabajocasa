package cuaderno0;

import java.io.BufferedReader;
import java.util.List;

public class Ej24 {

	public static void main(String[] args) throws Exception {
		ProcessBuilder cuenta = Lanzador.para("cuaderno0.Cuenta", "20");
		ProcessBuilder filtra = Lanzador.para("cuaderno0.Filtra", "1");
		List<Process> tuberia = ProcessBuilder.startPipeline(
				List.of(cuenta, filtra));
		Process ultimo = tuberia.get(tuberia.size() - 1);
		try (BufferedReader r = ultimo.inputReader()) {
			r.lines().forEach(System.out::println);
		}
		for (Process p : tuberia) {
			System.out.println("PID " + p.pid() + " -> código " + p.waitFor());
		}
	}
}
