//Определить класс Reader, хранящий такую информацию о пользователе библиотеки:ФИО,номер читательского билета,
// факультет,дата рождения,телефон.Методы takeBook(), returnBook().
// Разработать программу, в которой создается массив объектов данного класса.
// Перегрузить методы takeBook(), returnBook():
// - takeBook, который будет принимать количество взятых книг. Выводит на консоль сообщение "Петров В. В. взял 3 книги".
// - takeBook, который будет принимать переменное количество названий книг.
// Выводит на консоль сообщение "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
// - takeBook, который будет принимать переменное количество объектов класса
// Book (создать новый класс, содержащий имя и автора книги). Выводит на консоль сообщение
// "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
// Аналогичным образом перегрузить метод returnBook().
// Выводит на консоль сообщение "Петров В. В. вернул книги: Приключения, Словарь, Энциклопедия".
// Или  "Петров В. В. вернул 3 книги".

public class Reader {
    //создаем переменные ФИО,номер читательского билета,факультет,дата рождения,телефон
    String FIO;
    int number;
    String faculty;
    String birthday;
    String phone;

    public Reader(String FIO,int number, String faculty, String birthday, String phone){
        this.FIO = FIO;
        this.number = number;
        this.faculty = faculty;
        this.birthday = birthday;
        this.phone = phone;
    }

    //создаем метод для получения и изменения ФИО
    public String getFIO(){
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    //создаем метод для получения и изменения номера читательского билета
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //создаем метод для получения и изменения факультета
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    //создаем метод для получения и изменения даты рождения
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    //создаем метод для получения и изменения номера телефона
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //создаем метод take_book, принимающий количество взятых книг
    public void take_book(int number){
        System.out.println(this.FIO + " взял " + this.number + " книги(у).");
        System.out.println();
    }

    //создаем метод take_book, принимающий переменное количество названий книг
    public void take_book(String...books){
        System.out.println(this.FIO + " взял книги: ");
        for (String book : books){
            System.out.println(book);
        }
        System.out.println();
    }

    //создаем метод take_book, принимающий переменное количество объектов класса Book
    public void take_book(Book...books){
        System.out.println(this.FIO + " взял книги: ");
        for (Book book : books){
            System.out.println(book.getName());
        }
        System.out.println();
    }

    //создаем метод return_book, возвращающий количество взятых книг
    public void return_book(int number){
        System.out.println(this.FIO + " вернул "+ this.number + " книги(у).");
        System.out.println();
    }

    //создаем метод return_book, возвращающий переменное количество названий книг
    public void return_book(String...books){
        System.out.println(this.FIO + " вернул книги: ");
        for (String book : books){
            System.out.println(book);
        }
        System.out.println();
    }

    //создаем метод return_book, возвращающий переменное количество объектов класса Book
    public void return_book(Book...books){
        System.out.println(this.FIO + " вернул книги: ");
        for (Book book : books){
            System.out.println(book.getName());
        }
        System.out.println();
    }
}


