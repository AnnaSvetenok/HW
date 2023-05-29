/**
 * Класс для будущих поездов.
 */
package com.trainjavafx;

public class FutureTrains {
    /** Поле Город Откуда */
    private String cityFrom;
    /** Поле Город Куда */
    private String cityTo;
    /** Поле Дата отправления */
    private String departureDate;
    /** Поле Время отправления */
    private String departureTime;
    /** Поле Дата прибытия */
    private String arrivalDate;
    /** Поле Время прибытия */
    private String arrivalTime;
    /** Поле Кол-во мест в поезде*/
    private int seats;
    /** Поле Кол-во свободных мест */
    private int emptySeats;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param cityFrom - Город Откуда
     * @param cityTo - Город Куда
     * @param departureDate - Дата отправления
     * @param departureTime - Время отправления
     * @param arrivalDate - Дата прибытия
     * @param arrivalTime - Время прибытия
     * @param  seats - Кол-во мест в поезде
     * @param  emptySeats - Кол-во свободных мест
     */
    public FutureTrains(String cityFrom, String cityTo, String departureDate, String departureTime, String arrivalDate, String arrivalTime, int seats, int emptySeats) {
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.seats = seats;
        this.emptySeats = emptySeats;
    }

    /**
     * Функция получения значения поля {@link FutureTrains#cityFrom}
     * @return возвращает город откуда
     */
    public String getCityFrom() {
        return cityFrom;
    }

    /**
     * Процедура определения производителя {@link FutureTrains#cityFrom}
     * @param cityFrom - город откуда
     */
    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    /**
     * Функция получения значения поля {@link FutureTrains#cityTo}
     * @return возвращает город куда
     */
    public String getCityTo() {
        return cityTo;
    }

    /**
     * Процедура определения производителя {@link FutureTrains#cityTo}
     * @param cityTo - город куда
     */
    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    /**
     * Функция получения значения поля {@link FutureTrains#departureDate}
     * @return возвращает дату отправления
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * Процедура определения производителя {@link FutureTrains#departureDate}
     * @param departureDate - дата отправления
     */
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * Функция получения значения поля {@link FutureTrains#departureTime}
     * @return возвращает время отправления
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Процедура определения производителя {@link FutureTrains#departureTime}
     * @param departureTime - время отправления
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Функция получения значения поля {@link FutureTrains#arrivalDate}
     * @return возвращает дату прибытия
     */
    public String getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Процедура определения производителя {@link FutureTrains#arrivalDate}
     * @param arrivalDate - дата прибытия
     */
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * Функция получения значения поля {@link FutureTrains#arrivalTime}
     * @return возвращает время прибытия
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Процедура определения производителя {@link FutureTrains#arrivalTime}
     * @param arrivalTime - время прибытия
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Функция получения значения поля {@link FutureTrains#seats}
     * @return возвращает кол-во мест в поезде
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Процедура определения производителя {@link FutureTrains#seats}
     * @param seats - кол-во мест в поезде
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * Функция получения значения поля {@link FutureTrains#emptySeats}
     * @return возвращает кол-во свободных мест
     */
    public int getEmptySeats() {
        return emptySeats;
    }

    /**
     * Процедура определения производителя {@link FutureTrains#emptySeats}
     * @param emptySeats - кол-во свободных мест
     */
    public void setEmptySeats(int emptySeats) {
        this.emptySeats = emptySeats;
    }
}
