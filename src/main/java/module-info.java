module com.example.jocconversacionalalien {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.jocconversacionalalien.classes to javafx.fxml;
    exports com.example.jocconversacionalalien.classes;
}