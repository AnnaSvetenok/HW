/**
 * Класс для списка поездов.
 */
package com.trainjavafx;
public class Train {

    /** Поле Наименование поезда */
    private String name;
    /** Поле Тип поезда */
    private String type;
    /** Поле Кол-во вагонов */
    private int carriages;
    /** Поле Кол-во мест в вагоне */
    private int seats;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param name - Наименование поезда
     * @param type - Тип поезда
     * @param carriages - Кол-во вагонов
     * @param seats - Кол-во мест в вагоне
     */
    public Train(String name, String type, int carriages, int seats) {
        this.name = name;
        this.type = type;
        this.carriages = carriages;
        this.seats = seats;
    }

    /**
     * Функция получения значения поля {@link Train#name}
     * @return возвращает Наименование поезда
     */
    public String getName() {
        return name;
    }

    /**
     * Процедура определения производителя {@link Train#name}
     * @param name - Наименование поезда
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Функция получения значения поля {@link Train#type}
     * @return возвращает Тип поезда
     */
    public String getType() {
        return type;
    }

    /**
     * Процедура определения производителя {@link Train#type}
     * @param type - Тип поезда
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Функция получения значения поля {@link Train#carriages}
     * @return возвращает Кол-во вагонов
     */
    public int getCarriages() {
        return carriages;
    }

    /**
     * Процедура определения производителя {@link Train#carriages}
     * @param carriages - Кол-во вагонов
     */
    public void setCarriages(int carriages) {
        this.carriages = carriages;
    }

    /**
     * Функция получения значения поля {@link Train#seats}
     * @return возвращает Кол-во мест в вагоне
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Процедура определения производителя {@link Train#seats}
     * @param seats - Кол-во мест в вагоне
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }
}