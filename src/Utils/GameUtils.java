package Utils;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class GameUtils {
	
	// Propiedades
	private static final int TOTAL_SIMBOLS = 16;
	private static final int TOTAL_X = 2;
    private static final int MIN_W = 1;
    private static final int MAX_W = 3;
    
    /**
     * Función para generar un array de simbolos
     * @return
     */
    public static String[] generadorSimbolos() {
        String[] symbols = new String[TOTAL_SIMBOLS];
        
        // Llenar el array con "O"
        for (int i = 0; i < TOTAL_SIMBOLS; i++) {
            symbols[i] = "O";
        }
        
        // Colocar las "X"
        for (int i = 0; i < TOTAL_X; i++) {
            int randomIndex = (int) (Math.random() * TOTAL_SIMBOLS);
            
            // Si hay una "O" en esa casilla pondrá una "X"
            while (!symbols[randomIndex].equals("O")) {
                randomIndex = (int) (Math.random() * TOTAL_SIMBOLS);
            }
            symbols[randomIndex] = "X";
        }
        
        // Colocar las "W" en una posición entre el número máximo y mínimo
        int totalW = (int) (Math.random() * (MAX_W - MIN_W + 1)) + MIN_W;
        for (int i = 0; i < totalW; i++) {
            int randomIndex = (int) (Math.random() * TOTAL_SIMBOLS);
            
         // Si hay una "O" en esa casilla pondrá una "W"
            while (!symbols[randomIndex].equals("O")) {
                randomIndex = (int) (Math.random() * TOTAL_SIMBOLS);
            }
            symbols[randomIndex] = "W";
        }
        
        return symbols;
    }

	/**
	 * Función para cargar el record del usuario
	 */
	public static int cargarRecord(Text txtRecord) {
		int recordFichero = FileUtils.obtenerRecordFichero();
		int record = Integer.valueOf(txtRecord.getText().split(" ")[0]);

		// Si el record del archivo es más grande cambiará su texto
		if (recordFichero > record) {
			txtRecord.setText(FileUtils.obtenerRecordFichero() + " punts");
		} else {

			// Si no cambiamos el record del fichero
			FileUtils.cambiarRecordFichero("" + record);
			txtRecord.setText(record + " punts");
		}
		
		// Mostramos un mensaje del actual record
		 System.out.println("[JUEGO] El actual record és " + (FileUtils.obtenerRecordFichero() > record ? FileUtils.obtenerRecordFichero() : record));
		return record;

	}
	
	/**
	 * Función para deshabilitar todos los botones
	 * @param gameButtons
	 * @param simbolos
	 */
	public static void deshabilitarBotones(ArrayList<Button> gameButtons, String[] simbolos) {

		// Deshabilitamos los botones para que no se puedan clickar
		for (int i = 0; i < gameButtons.size(); i++) {
			gameButtons.get(i).setDisable(true);
			gameButtons.get(i).setText(simbolos[i]);
		}
	}
	
	/**
	 * Función para deshabilitar todos los botones al inicio
	 * @param gameButtons
	 * @param simbolos
	 */
	public static void deshabilitarBotones(ArrayList<Button> gameButtons) {

		// Deshabilitamos los botones para que no se puedan clickar
		for (int i = 0; i < gameButtons.size(); i++) {
			gameButtons.get(i).setDisable(true);
			gameButtons.get(i).setText("?");
		}
	}
	

	/**
	 * Función para habilitar todos los botones
	 * @param gameButtons
	 * @param simbolos
	 */
	public static void habilitarBotones(ArrayList<Button> gameButtons, String[] simbolos) {

		// Deshabilitamos los botones para que no se puedan clickar
		for (int i = 0; i < gameButtons.size(); i++) {
			gameButtons.get(i).setDisable(false);
			gameButtons.get(i).setText("?");
		}
	}
}
