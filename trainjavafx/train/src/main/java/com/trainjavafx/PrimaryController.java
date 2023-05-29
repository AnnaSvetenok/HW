package com.trainjavafx;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToCreate() throws IOException {
        App.setRoot("create");
    }

    @FXML
    private void switchToAllTrains() throws IOException {
        App.setRoot("All_trains");
    }

    @FXML
    private void switchToFutureTrains() throws IOException {
        App.setRoot("Future_trains");
    }

}
