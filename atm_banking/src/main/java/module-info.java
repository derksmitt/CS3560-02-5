module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;
    requires transitive javafx.graphics;

    opens com.github.cs3560_02_5 to javafx.fxml;
    exports com.github.cs3560_02_5
    ;
}
