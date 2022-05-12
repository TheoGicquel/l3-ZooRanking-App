module com.turquoise.zooturquoiseapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.turquoise.zooturquoiseapp to javafx.fxml;
    exports com.turquoise.zooturquoiseapp;
}