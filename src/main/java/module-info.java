module com.jonaskaad.easter {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jonaskaad.easter to javafx.fxml;
    exports com.jonaskaad.easter;
}