package ca.scheid.Main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Timer;

import ca.scheid.controller.ScreenController;
import ca.scheid.threads.PacketProcessor;
import ca.scheid.threads.PacketReceiver;
import ca.scheid.threads.ScreenRefresher;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 8, 2020
 */

@Log4j2
public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("f1-2019-telemetry.fxml"));
			Parent root = loader.load();
			root.getStylesheets().add("f1-2019-telemetry.css");
			stage.setScene(new Scene(root));
			stageConfiguration(stage);
			ScreenController controller = loader.getController();
			Timer timer = new Timer(true);
			timer.scheduleAtFixedRate(controller, 1000, 5);
		} catch (MalformedURLException e) {
			log.error("Could find the fxml file");
			e.printStackTrace();
		}
	}


	private void stageConfiguration(Stage stage) {
		stage.setTitle("Formula 1 - Extra Dashboard");
		stage.setResizable(false);
		stage.show();
		stage.setOnCloseRequest(e->{
			Platform.exit();
			System.exit(0);
		});
	}

	public static void main(String[] args) {
		PacketReceiver receiver = new PacketReceiver();
		receiver.start();
		PacketProcessor processor = new PacketProcessor();
		processor.start();
		ScreenRefresher screen = new ScreenRefresher();
		screen.start();
		Platform.setImplicitExit(false);
		launch();
	}
}
