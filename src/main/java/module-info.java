module org.tusharchaurasia.installrepos.installrepos {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.tusharchaurasia.installrepos.installrepos to javafx.fxml;
    exports org.tusharchaurasia.installrepos.installrepos;
}