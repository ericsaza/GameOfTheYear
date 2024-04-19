package Utils;

import javafx.scene.control.Alert;

public class AlertUtils {

	public static void mostrarAlertaPuntos(int puntos) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    alert.setHeaderText(null);
	    alert.setTitle("Enhorabona");
	    alert.setContentText("Has fet " + puntos + (puntos > 1 ? " punts" : " punt"));
	    alert.showAndWait();
	}
}
