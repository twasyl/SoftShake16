package io.twasyl.demo.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Thierry Wasylczenko
 * @version 1.0
 */
public class DemoFXApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        final Parent root = FXMLLoader.load(DemoFXApp.class.getResource("/io/twasyl/demo/fx/fxmls/DemoFX.fxml"));

        final Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("DemoFX");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
