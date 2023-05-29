/**
 * Класс CreateController отвечает за обработку событий на экране добавления нового рейса.
 */
package com.trainjavafx;

import java.io.IOException;

import javafx.fxml.FXML;

public class CreateController {

    /**
     * Метод switchToPrimary() переключает экран на главный экран приложения.
     *
     * @throws IOException - исключение, которое может быть выброшено при загрузке FXML-файла
     */
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    /**
     * Метод createAction() создает новый рейс и переключает экран на главный экран приложения.
     *
     * @throws IOException - исключение, которое может быть выброшено при загрузке FXML-файла
     */
    @FXML
    private void createAction() throws IOException {
        App.setRoot("primary");
    }

}