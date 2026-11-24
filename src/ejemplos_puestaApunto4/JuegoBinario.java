package ejemplos_puestaApunto4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JuegoBinario {

	public static void main(String[] args) {
	
		Path ruta = Path.of("ranking.dat");
		try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(Files.newOutputStream(ruta)))) {

            System.out.println("Escribiendo alumnos en formato binario...");
            // Registro 1: int (4 bytes) + String UTF (2 bytes longitud + texto) + double (8 bytes)
            out.writeInt(1);
            out.writeUTF("Guillermo");
            out.writeInt(400);
            out.writeDouble(8.5);

            // Registro 2:
            out.writeInt(2);
            out.writeUTF("Íñigo");
            out.writeInt(200);
            out.writeDouble(6.25);
            
         // Registro 3:
            out.writeInt(3);
            out.writeUTF("ana");
            out.writeInt(150);
            out.writeDouble(3.55);

        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
		
		
		try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(Files.newInputStream(ruta)))) {

            System.out.println("Leyendo ranking desde 'ranking.dat':");

            // Bucle infinito que se detiene cuando salta la EOFException
            while (true) {
                int id = in.readInt();
                String nombreJugador = in.readUTF();
                int puntuacion = in.readInt();
                double nivel = in.readDouble();

                System.out.println("  ID: " + id + " | Nombre: " + nombreJugador + " con una puntacion de: "+ puntuacion + "| Nota: " + nivel);
            }

        } catch (EOFException fin) {
            // EOF = End Of File. No es un error grave: es la señal normal de que no hay más datos.
            System.out.println("-> Fin del fichero alcanzado con éxito (EOFException).");
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }

	}


