package cuaderno0;

public class Ej09 {
	public static void main(String[] args) throws Exception {
		System.out.println("--- Sin intérprete de órdenes");
		ProcessBuilder a = new ProcessBuilder("ls", "*.txt");
		int ca = a.inheritIO().start().waitFor();
		System.out.println("Código: " + ca);
		System.out.println("--- Con sh -c");
		ProcessBuilder b = new ProcessBuilder("sh", "-c", "ls *.txt");
		int cb = b.inheritIO().start().waitFor();
		System.out.println("Código: " + cb);
	}
}
