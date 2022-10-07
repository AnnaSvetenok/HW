import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class HW_08_10 {
    public static void main(String[] args) {
        EX3();
        EX4();
        EX5();
    }

    public static void EX3() {
        ArrayList<String> listA = new ArrayList<>();

        //Добавляем объекты в коллекцию
        listA.add("C++");
        listA.add("Python");
        listA.add("Java");
        listA.add("Python");

        Set<String> set = new LinkedHashSet<>(listA); //создаем мн-во из элементов списка(удаляются все дубликаты)
        ArrayList<String> listA_without_dubl = new ArrayList<>(set); //преобразуем мн-во обратно в список(уже без дубликатов)

        System.out.println("Упражнение 3.\nПолучаем коллекцию объектов: \n" + listA);
        System.out.print("Преобразуем коллекцию в набор и получаем объекты без дубликатов: \n" + listA_without_dubl);
    }

    public static void EX4() {
        ArrayList<Double> ar_list = new ArrayList<>();
        LinkedList<Double> l_list = new LinkedList<>();
        int k = 1000000;
        int n = 100000;

        for (int i = 0; i < k; i++) { //добавляем в списки 1 000 000 рандомных значений
            ar_list.add(Math.random());
            l_list.add((Math.random()));
        }

        long start = System.currentTimeMillis(); //начинаем отсчет времени, за которое выполнится программа
        for (int j = 0; j < n; j++) { //выбираем их списка 100 000 рандомных значений
            ar_list.get((int) (Math.random()));
        }
        long finish = System.currentTimeMillis();//завершаем отсчет времени
        long dif = finish - start;//высчитываем время, потраченное на выполнение программы
        System.out.println("\nУпражнение 4.\nВремя выполнения программы ar_list: " + dif);

        long start1 = System.currentTimeMillis();//начинаем отсчет времени, за которое выполнится программа
        for (int q = 0; q < n; q++) {//выбираем их списка 100 000 рандомных значений
            l_list.get((int) (Math.random()));
        }
        long finish1 = System.currentTimeMillis();//завершаем отсчет времени
        long dif1 = finish1 - start1;//высчитываем время, потраченное на выполнение программы
        System.out.println("Время выполнения программы l_list: " + dif1);

        long min = Math.min(dif, dif1); //находим минимальное время за которое выполнялись программы
        if (dif < dif1) {
            System.out.println("Быстрее программа: ar_list");
        } else {
            System.out.println("Быстрее программа: l_list");
        }

    }

    public static void EX5() {

        Scanner in = new Scanner(System.in); //используем Scanner чтобы пользователь текст с клавиатуры
        System.out.print("Задача 5. Введите текст: "); //вводим текст

        String s = in.nextLine();
        String[] words = s.split("\\s+|\\.|\\,|\\?|\\:|\\;|\\!|\\-"); //разделяем строку по знакам препинания

        HashMap<String, Integer> dictionary = new HashMap<>(); //создаем словарь

        int minWordLen = 1; //задаем минимальную длину слова для подсчета
        for (String word : words) {
            String newWord = word.toLowerCase(); // переводим все слова в нижний регистр
            if (newWord.length() > minWordLen) {
                if (dictionary.containsKey(newWord)) { //проверяем существует ли уже ключ в словаре
                    dictionary.put(newWord, dictionary.get(newWord).intValue() + 1); //если сущесвует, добавляем к значению 1
                } else {
                    dictionary.put(newWord, 1); //если не сущ. значение =1
                }
            }
        }
        for (Map.Entry entry : dictionary.entrySet()) { //проходим циклом по словарю
            System.out.println(entry.getKey() + ": " + entry.getValue()); //выводим пары ключ-значения
        }
    }

}

