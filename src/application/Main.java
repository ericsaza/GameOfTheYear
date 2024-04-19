package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carreguem el document FXML, especificant la ruta relativa al projecte
			Parent root = FXMLLoader.load(getClass().getResource("/gui/Principal.fxml"));

			// Creem i mostrem l'escena
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("GOTY - Eric Salado Zafra");
			primaryStage.show();

			// Aquesta línea permet afegir estils CSS al projecte
//			scene.getStylesheets().add(getClass().getResource("/gui/styles.css").toExternalForm());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
