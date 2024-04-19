package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileUtils {
	
	// Propiedades
	private static File archivoJuego = new File("record.txt");

	/**
	 * Función para obtener el record del ficero
	 * @return devuelve el primer número que seria el record
	 */
	public static int obtenerRecordFichero() {
		try {
			// Declaramos un scanner para leer el archivo
			Scanner sc = new Scanner(archivoJuego);
			try {
				int record = sc.nextInt();
				return record;
			} catch (InputMismatchException e) {
				System.out.println("[ERROR] El archivo solo puede contener un número entero.");
				System.out.println("[JUEGO] Se generó un fichero con record 0.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] No se encontró el archivo.");
			System.out.println("[CONFIG] Se ha creado un archivo para resultados.");
		}
		return 0;
	}
	
	/**
	 * Función para canviar el record del fichero
	 */
	public static void cambiarRecordFichero(String nuevoRecord) {
        try {
        	
        	// Declaramos un PrintWriter para editar el ficero
    		PrintWriter writer = new PrintWriter(archivoJuego);
            writer.println(nuevoRecord);
            writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("[JUEGO] No se encontró el archivo.");
		}
	}
}
