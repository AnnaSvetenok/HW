//a)Создать перечисление, содержащее названия времен года.
//б)Создать переменную содержащую ваше любимое время года и распечатать всю информацию о нем.
//в)Создать метод, который принимает на вход переменную созданного вами enum типа.
// Если значение равно Лето, выводим на консоль “Я люблю лето” и так далее. Используем оператор switch.
//г)Перечисление должно содержать переменную, содержащую среднюю температуру в каждом времени года.
//д)Добавить конструктор принимающий на вход среднюю температуру.
//е)Создать метод getDescription, возвращающий строку “Холодное время года”.
// Переопределить метод getDescription - для константы Лето метод должен возвращать “Теплое время года”.
//ж)В цикле распечатать все времена года, среднюю температуру и описание времени года.

public class SeasonDemo {
    public static void main(String[] args){
        //Создать переменную содержащую ваше любимое время года и распечатать всю информацию о нем
        Season season=Season.WINTER;
        System.out.println("Мой любимый сезон: " + season + " \nинформация о нем: \nСредняя температура: " + season.getAvgTemp() + "\nКакое время года(телое/холодное): " + season.getDescription());
        print(Season.SPRING);
        printAllvalues();


    }
    //создаем метод, возвращающий строку "Я люблю ..." с помощью оператора switch
    public static void print(Season season){
        switch (season){
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
        }
    }
    //выводим все данные о временах года
    public static void printAllvalues(){
        for (Season s:Season.values()){
            System.out.println(s+" "+s.getAvgTemp() + " "+ s.getDescription());
        }
    }
}
