package com.jonaskaad.easter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import org.kordamp.bootstrapfx.BootstrapFX;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1060, 640);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("PROSA - Easter");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("egg-icon.png")));
    }

    public static void main(String[] args) {
        launch();
    }
}