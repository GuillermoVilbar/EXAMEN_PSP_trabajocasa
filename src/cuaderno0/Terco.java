package cuaderno0;

public class Terco {
	public static void main(String[] args) throws InterruptedException {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("Me piden que termine: recojo y salgo");
			}
		});
		System.out.println("Trabajando...");
		Thread.sleep(60_000);

	}
}
