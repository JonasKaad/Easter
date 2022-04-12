module com.jonaskaad.easter {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;

    opens com.jonaskaad.easter to javafx.fxml;
    exports com.jonaskaad.easter;
}