/**
 * 
 */
package ca.scheid.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com Apr 11, 2020
 */

public class ScreenController extends TimerTask implements Initializable {
	@FXML
	public ProgressBar throttleBar;

	@FXML
	public ProgressBar brakeBar;

	@FXML
	public Slider steeringSlider;
	
	@Override
	public void run() {
		Platform.runLater(() -> {
			throttleBar.setProgress(PanelController.getTHROTTLE());
			brakeBar.setProgress(PanelController.getBRAKE());
			steeringSlider.setValue(PanelController.getSTEERING_WHEEL());
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		throttleBar.setProgress(PanelController.getTHROTTLE());
		brakeBar.setProgress(PanelController.getBRAKE());
		steeringSlider.setValue(PanelController.getSTEERING_WHEEL());
	}

}
