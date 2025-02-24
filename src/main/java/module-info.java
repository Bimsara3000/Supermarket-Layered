module lk.ijse.gdse71.supermarketlayered {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;
    requires net.sf.jasperreports.core;
    requires java.mail;


    opens lk.ijse.gdse71.supermarketlayered.view.tdm to javafx.base;
    opens lk.ijse.gdse71.supermarketlayered.controller to javafx.fxml;
    exports lk.ijse.gdse71.supermarketlayered;
}