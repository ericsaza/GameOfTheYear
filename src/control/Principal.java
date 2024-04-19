package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Utils.AlertUtils;
import Utils.GameUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Principal implements Initializable {

	// Propiedades
	private boolean comenzar = false;
	@FXML
	private TextField txtFieldPuntos;
	@FXML
	private ArrayList<Button> gameButtons = new ArrayList<>(); // Lista donde guardaremos los botones
	private static String[] simbolos;
	@FXML
	private Text txtRecord;
	@FXML
	private Button gameButton1;
	@FXML
	private Button gameButton2; 
	@FXML
	private Button gameButton3;
	@FXML
	private Button gameButton4;
	@FXML
	private Button gameButton5;
	@FXML
	private Button gameButton6;
	@FXML
	private Button gameButton7;
	@FXML
	private Button gameButton8;
	@FXML
	private Button gameButton9;
	@FXML
	private Button gameButton10;
	@FXML
	private Button gameButton11;
	@FXML
	private Button gameButton12;
	@FXML
	private Button gameButton13;
	@FXML
	private Button gameButton14;
	@FXML
	private Button gameButton15;
	@FXML
	private Button gameButton16;
    @FXML
    private Button btnReiniciarPantalla;



	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Mostraremos un mensaje al inicializar
		System.out.println("Logs\n" + "---------\n" +
				"[JUEGO] La escena se ha cargado.");

		// Cargamos el record del fichero
		GameUtils.cargarRecord(txtRecord);
		
		// Rellenamos el array
		simbolos = GameUtils.generadorSimbolos();

		// Añadimos los botones a la lista
		gameButtons.add(gameButton1);
		gameButtons.add(gameButton2);
		gameButtons.add(gameButton3);
		gameButtons.add(gameButton4);
		gameButtons.add(gameButton5);
		gameButtons.add(gameButton6);
		gameButtons.add(gameButton7);
		gameButtons.add(gameButton8);
		gameButtons.add(gameButton9);
		gameButtons.add(gameButton10);
		gameButtons.add(gameButton11);
		gameButtons.add(gameButton12);
		gameButtons.add(gameButton13);
		gameButtons.add(gameButton14);
		gameButtons.add(gameButton15);
		gameButtons.add(gameButton16);
		
		// Deshabilitamos los botones para que el jugador no pueda hacer nada hasta que comience
		GameUtils.deshabilitarBotones(gameButtons);
	} 

	/**
	 * Función para controlar los clicks de los botónes
	 * @param event
	 */
	@FXML
	public void clickBoton(ActionEvent event) {

		// Obtenemos el botón
		Button botonClicado = (Button) event.getSource();

		// Obtenemos el id
		int idBoton = Integer.valueOf(botonClicado.getId().split("Button")[1]);
		System.out.println("[JUEGO] Se ha clicado el siguiente botón con id: " + idBoton + " - " + simbolos[idBoton - 1]);

		// Deshabilitamos el botón clickado y mostramos el simbolo
		botonClicado.setDisable(true);
		botonClicado.setText(simbolos[idBoton - 1]);

		switch(simbolos[idBoton - 1]) {
		case "O":
			
			// Sumamos un punto a los puntos
			txtFieldPuntos.setText((Integer.valueOf(txtFieldPuntos.getText()) + 1) + "");
			break;
		case "W":

			// Duplicamos el valor de los puntos
			txtFieldPuntos.setText((Integer.valueOf(txtFieldPuntos.getText()) * 2) + "");
			break;
		case "X":
			
			System.out.println("[JUEGO] Te retiraste con esta cantidad de puntos: " + Integer.valueOf(txtFieldPuntos.getText()));

			// Habilitamos todos los botones
			GameUtils.deshabilitarBotones(gameButtons, simbolos);
			
			// Mostramos una alerta de enhorabuena
			AlertUtils.mostrarAlertaPuntos(Integer.valueOf(txtFieldPuntos.getText()));
			
			if (Integer.valueOf(txtFieldPuntos.getText()) > Integer.valueOf(txtRecord.getText().split(" ")[0])) {
				txtRecord.setText(txtFieldPuntos.getText());
				
				// Cargamos el record del fichero
				GameUtils.cargarRecord(txtRecord);
			}
			
			// Volvemos a dejar el input a 0
			txtFieldPuntos.setText("0");
			
			// Cambiamos el texto del boton reiniciar
			btnReiniciarPantalla.setText("Començar");
			comenzar = false;
		}
	}

	/**
	 * Función para reiniciar el juego
	 * @param event
	 */
	@FXML
	public void reiniciarJuego(ActionEvent event) {

		if (!comenzar) {
			System.out.println("[JUEGO] Que empiece el juego");

			// Cambiamos el mensaje del botón de "Començar" a "Reiniciar pantalla"
			btnReiniciarPantalla.setText("Reiniciar pantalla");

		} else {
			System.out.println("[JUEGO] Pantalla reiniciada");

			// Cambiamos el mensaje del botón de "Començar" a "Reiniciar pantalla"
			btnReiniciarPantalla.setText("Començar");

			comenzar = false;
		}
		// Rellenamos el array
		simbolos = GameUtils.generadorSimbolos();

		// Habilitar todos los botones
		for (Button button : gameButtons) {
			button.setDisable(false);
			button.setText("?");
		}
		
	}

	/**
	 * Función para salir del juego
	 * @param event
	 */
	@FXML
	public void salirJuego(ActionEvent event) {
		
		System.out.println("[JUEGO] Saliste dle juego.");
		
		// Cerramos la ventana
		System.exit(0);
	}
}
