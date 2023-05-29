package com.trainjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */

/**
 * Главный класс приложения, который запускает JavaFX-приложение и загружает первоначальный интерфейс пользователя.
 */
public class App extends Application {

    private static Scene scene;

    /**
     * Метод start() является точкой входа в приложение JavaFX.
     * Он создает главное окно приложения и загружает первоначальный интерфейс пользователя.
     *
     * @param stage - главное окно приложения
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Метод setRoot() устанавливает новый корневой элемент для главной сцены приложения.
     *
     * @param fxml - имя файла FXML для загрузки
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));

    }

    /**
     * Метод loadFXML() загружает файл FXML и возвращает его в виде объекта Parent.
     *
     * @param fxml - имя файла FXML для загрузки
     * @return объект Parent, представляющий загруженный файл FXML
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Главный метод, который запускает приложение.
     *
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        launch();
    }

}