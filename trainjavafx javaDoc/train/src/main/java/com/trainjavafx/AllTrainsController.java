
/**
 * Класс AllTrainsController отвечает за обработку событий на экране со списком всех поездов.
 */
package com.trainjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;


public class AllTrainsController {

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
     * Метод switchToAddTrain() переключает экран на экран добавления нового поезда.
     *
     * @throws IOException - исключение, которое может быть выброшено при загрузке FXML-файла
     */
    @FXML
    private void switchToAddTrain() throws IOException {
        App.setRoot("Add_train");
    }

    private ObservableList<Train> trainData = FXCollections.observableArrayList();

    @FXML
    private TableView<Train> tableTrains;

    @FXML
    private TableColumn<Train, String> name;

    @FXML
    private TableColumn<Train, String> type;

    @FXML
    private TableColumn<Train, Integer> carriages;

    @FXML
    private TableColumn<Train, Integer> seats;

    // подготавливаем данные для таблицы
    /**
     * Метод initData() подготавливает данные для таблицы.
     */
    private void initData() {
        trainData.add(new Train("Сапсан", "Скоростной", 10, 64));
        trainData.add(new Train("Кавказ", "Двухэтажный", 12, 112));
        trainData.add(new Train("Невский Экспресс", "Дневной", 15, 100));
        trainData.add(new Train("Ласточка", "Скоростной", 10, 99));
        trainData.add(new Train("АЭРОЭКСПРЕСС", "Пригородный", 6, 65));
    }

    // инициализируем форму данными
    /**
     * Метод initialize() инициализирует форму данными.
     */
    @FXML
    private void initialize() {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        name.setCellValueFactory(new PropertyValueFactory<Train, String>("name"));
        type.setCellValueFactory(new PropertyValueFactory<Train, String>("type"));
        carriages.setCellValueFactory(new PropertyValueFactory<Train, Integer>("carriages"));
        seats.setCellValueFactory(new PropertyValueFactory<Train, Integer>("seats"));

        // заполняем таблицу данными
        tableTrains.setItems(trainData);
    }

}
