package com.trainjavafx;

import java.io.IOException;

import javafx.fxml.FXML;

public class CreateController {
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void createAction() throws IOException {
        App.setRoot("primary");
    }

}