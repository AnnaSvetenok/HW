package com.trainjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class FutureTrainsController {
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    private ObservableList<FutureTrains> futureTrainsData = FXCollections.observableArrayList();

    @FXML
    private TableView<FutureTrains> futureTrains;

    @FXML
    private TableColumn<FutureTrains, String> cityFrom;

    @FXML
    private TableColumn<FutureTrains, String> cityTo;

    @FXML
    private TableColumn<FutureTrains, String> departureDate;
    @FXML
    private TableColumn<FutureTrains, String> departureTime;
    @FXML
    private TableColumn<FutureTrains, String> arrivalDate;
    @FXML
    private TableColumn<FutureTrains, String> arrivalTime;
    @FXML
    private TableColumn<FutureTrains, Integer> seats;
    @FXML
    private TableColumn<FutureTrains, Integer> emptySeats;


    // инициализируем форму данными
    @FXML
    private void initialize() {
        data();

        // устанавливаем тип и значение которое должно хранится в колонке
        cityFrom.setCellValueFactory(new PropertyValueFactory<FutureTrains, String>("cityFrom"));
        cityTo.setCellValueFactory(new PropertyValueFactory<FutureTrains, String>("cityTo"));
        departureDate.setCellValueFactory(new PropertyValueFactory<FutureTrains, String>("departureDate"));
        departureTime.setCellValueFactory(new PropertyValueFactory<FutureTrains, String>("departureTime"));
        arrivalDate.setCellValueFactory(new PropertyValueFactory<FutureTrains, String>("arrivalDate"));
        arrivalTime.setCellValueFactory(new PropertyValueFactory<FutureTrains, String>("arrivalTime"));
        seats.setCellValueFactory(new PropertyValueFactory<FutureTrains, Integer>("seats"));
        emptySeats.setCellValueFactory(new PropertyValueFactory<FutureTrains, Integer>("emptySeats"));

        // заполняем таблицу данными
        futureTrains.setItems(futureTrainsData);
    }

    // подготавливаем данные для таблицы
    private void data() {
        futureTrainsData.add(new FutureTrains("МОСКВА ОКТЯБРЬСКАЯ", "САНКТ-ПЕТЕРБУРГ-ГЛАВН.", "20-05-2023", "15:30", "20-05-2023", "19:30", 600, 50));
        futureTrainsData.add(new FutureTrains("МОСКВА БЕЛОРУССКАЯ", "СМОЛЕНСК ЦЕНТРАЛЬНЫЙ", "21-05-2023", "19:18", "21-05-2023", "23:40", 480, 248));
        futureTrainsData.add(new FutureTrains("МОСКВА ПАВЕЛЕЦКАЯ", " ВОЛГОГРАД 1", "21-05-2023", "20:10", "22-05-2023", "16:52", 810, 57));
        futureTrainsData.add(new FutureTrains("МОСКВА ПАВЕЛЕЦКАЯ", "ВОРОНЕЖ 1", "21-05-2023", "21:04", "22-05-2023", "08:30", 745, 47));
        futureTrainsData.add(new FutureTrains("МОСКВА КАЗАНСКАЯ", "КАЗАНЬ ПАСС", "21-05-2023", "20:40", "22-05-2023", "08:00", 760, 102));
    }

}
