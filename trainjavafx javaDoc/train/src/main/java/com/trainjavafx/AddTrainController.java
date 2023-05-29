/**
 * Класс AddTrainController отвечает за обработку событий на экране добавления нового поезда.
 */
package com.trainjavafx;

import javafx.fxml.FXML;

import java.io.IOException;

public class AddTrainController {

    /**
     * Метод switchToAllTrains() переключает экран на список всех поездов.
     *
     * @throws IOException - исключение, которое может быть выброшено при загрузке FXML-файла
     */
    @FXML
    private void switchToAllTrains() throws IOException {
        App.setRoot("All_trains");
    }

    /**
     * Метод createAction() создает новый поезд и переключает экран на главный экран приложения.
     *
     * @throws IOException - исключение, которое может быть выброшено при загрузке FXML-файла
     */
    @FXML
    private void createAction() throws IOException {
        App.setRoot("primary");
    }
}
