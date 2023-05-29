package com.trainjavafx;

import javafx.fxml.FXML;

import java.io.IOException;

public class AddTrainController {
    @FXML
    private void switchToAllTrains() throws IOException {
        App.setRoot("All_trains");
    }

    @FXML
    private void createAction() throws IOException {
        App.setRoot("primary");
    }
}
