package Ejercicios_2a_2b;

import java.io.IOException;

public class DetectorCodigoSalida {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ProcessBuilder pb = new ProcessBuilder("notepad.exe");
		Process p = pb.start();
		int codigo = p.waitFor();
		System.out.println("El proceso terminó con el código: " + codigo);
		
	}

}
