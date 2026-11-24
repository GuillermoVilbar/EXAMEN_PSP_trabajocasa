package ejemplos_guia03;

import java.util.Objects;

public class Cliente {
	
	public static class PaqueteCorruptoException extends Exception{
		public PaqueteCorruptoException(String mensaje) {
			super(mensaje);
			
		}
		public  PaqueteCorruptoException(String mensaje, Throwable  causa) {
			super(mensaje, causa);
		}
	}

	private final String ip;
	private final int puerto;
	private String nombre;

	public Cliente(String ip, int puerto, String nombre) {
		if (ip == null || ip.isBlank()) {
			throw new IllegalArgumentException("la ip no puede estar vacío");
		}
		if (puerto < 1 || puerto > 65535) {
			throw new IllegalArgumentException("puerto no válido: " + puerto);
		}
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException("cliente invalido debe tener un nombre");
		}
		this.ip = ip;
		this.puerto = puerto;
		this.nombre = nombre;
	}

	public String getIp() {
		return ip;
	}

	public int getPuerto() {
		return puerto;
	}

	public String getNombre() {
		return nombre;
	}
	
	public static void  intentarReasignacion(Cliente cParam) {
		
		cParam = new Cliente("192.168.1.100", 8080, "ClienteNuevo");
	}
	
	public void procesarPaquete(String datos) throws PaqueteCorruptoException {
		if (datos == null || datos.isBlank()) {
			throw new PaqueteCorruptoException("El paquete de datos es nulo o está vacío.");
		}
		
		try {
			// Intentamos convertir los datos a un número (simulando un tamaño)
			int tamanio = Integer.parseInt(datos);
			System.out.println("Paquete procesado con éxito. Tamaño: " + tamanio);
			
		} catch (NumberFormatException e) {
			// Relanzamos nuestra excepción propia conservando la causa original (e)[cite: 18, 19]
			throw new PaqueteCorruptoException("Fallo en el formato de los datos del paquete", e);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(ip, puerto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(ip, other.ip) && puerto == other.puerto;
	
	
	
	}
}

