module com.mycompany.blackjack1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.blackjack1 to javafx.fxml;
    exports com.mycompany.blackjack1;
}
