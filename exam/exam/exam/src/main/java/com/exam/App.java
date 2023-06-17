/**
 * JavaFX App
 */

/**
 * Главный класс приложения, который запускает JavaFX-приложение и загружает первоначальный интерфейс пользователя.
 */
package com.trainjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    /**
     * Метод start() является точкой входа в приложение JavaFX.
     * Он создает главное окно приложения и загружает интерфейс пользователя.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Форма авторизации");

        /**Создаем контейнер GridPane*/

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        /**Создаем элементы управления*/
        Label lblUser = new Label("Логин");
        final TextField txtUser = new TextField();
        Label lblPassword = new Label("Пароль");
        final PasswordField pf = new PasswordField();
        Button btnLogin = new Button("Войти");
        Button btnCancel = new Button("Отмена");

        /**Добавляем элементы управления на сетку*/
        grid.add(lblUserName, 0, 0);
        grid.add(txtUserName, 1, 0);
        grid.add(lblPassword, 0, 1);
        grid.add(pf, 1, 1);
        grid.add(btnLogin, 0, 2);
        grid.add(btnCancel, 1, 2);

        /**Функция для действий при нажатии на кнопку "Войти"*/
        btnLogin.setOnAction(event -> {
            String userName = txtUserName.getText();
            String password = pf.getText();
            if (userName.equals("user") && password.equals("1234")) {
                System.out.println("Вход выполнен успешно");
            } else {
                System.out.println("Неверный логин или пароль");
            }
        });

        /** Функция для действий при нажатии на кнопку "Отмена"*/
        btnCancel.setOnAction(event -> {
            txtUserName.setText("");
            pf.setText("");
        });

        /**Создаем сцену и добавляем на нее сетку*/
        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Главный метод, который запускает приложение.
     *
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        launch(args);
    }
}
