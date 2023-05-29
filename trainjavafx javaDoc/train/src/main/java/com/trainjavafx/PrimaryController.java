/**
 * Класс, представляющий контроллер главного окна приложения.
 */
package com.trainjavafx;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    /**
     * Метод, который переключает на окно создания нового элемента.
     * @function
     * @throws IOException
     */
    @FXML
    private void switchToCreate() throws IOException {
        App.setRoot("create");
    }

    /**
     * Метод, который переключает на окно со списком всех поездов.
     * @function
     * @throws IOException
     */
    @FXML
    private void switchToAllTrains() throws IOException {
        App.setRoot("All_trains");
    }

    /**
     * Метод, который переключает на окно со списком будущих поездов.
     * @function
     * @throws IOException
     */
    @FXML
    private void switchToFutureTrains() throws IOException {
        App.setRoot("Future_trains");
    }

}
