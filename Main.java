//Задачи из презентации
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //задача 1
        System.out.println("Задача 1. Hello World!");

        //задача 2
        final int num = 21;
        System.out.println("Задача 2. " + num);

        //задача 3
        int num_1 = 1;
        int num_2 = ++num_1;
        System.out.print("Задача 3. " + num_2);

        int c = 1;
        int d = c++;
        System.out.println(" " + c);

        //задача 4
        int t1 = 30;
        int t2 = 55;
        System.out.println("Задача 4. t1=" + t2 + "; t2=" + t1);

        int temp;
        temp = t1;
        t1 = t2;
        t2 = temp;
        System.out.println("t1=" + t1 + "; t2=" + t2);

        //задача 5
        int a = 3;
        int b = 4;
        System.out.println("Гипотенуза =" + Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2))));

        //задача 6
        Scanner in = new Scanner(System.in); //используем Scanner чтобы пользователь ввел число с клавиатуры
        System.out.print("Задача 6. Введите число: ");
        int number = in.nextInt();
        //int number=1635;
        int last_number = number % 10;
        System.out.println("Последняя цифра числа = " + last_number);

        //задача 7
        int number1 =25;
        double number2 = number1%100;
        System.out.println("Задача 7. Число в десятичной записи = " + number2/100 +" \nЧисло десятков в десятичной записи = " + number1%100/10);

        //задача 8
        Scanner ii = new Scanner(System.in); //используем Scanner чтобы пользователь ввел число с клавиатуры
        System.out.print("Задача 8. Введите число: ");
        int number_1 = ii.nextInt();
        //int number_1=35;
        int second_last_number = number_1 / 10 % 10;
        System.out.println("Число десятков в числе = " + second_last_number);

        //задача 9
        Scanner iii = new Scanner(System.in);
        System.out.print("Задача 9. Введите число: ");
        int chislo = iii.nextInt();
        int difference = chislo - 21;
        System.out.println("Разница между введенным числом и 21 = " + difference);
    }
}

/****************************

    //задача 10
    public static void main(String[] args) {
        //задача 10
        int c1 = 6;
        int d1= 12;
        int average = (c1 + d1) / 2;
        System.out.println("Среднее арифметическое этих чисел = " + average);
    }

    //задача 11
    public static void main (String[] args){
        //задача 11
        int e = 3;
        int f = 12;
        int average= e*f;
        System.out.println("Среднее геометрическое этих чисел = " + Math.sqrt(average));
    }

    //задача 12
    public static void main(String[] args){
        //задача 12
        double x1 = 10.0;
        double y1 = 34.0;
        double x2 = 3.0;
        double y2 = 10.0;
        System.out.println("Расстояние между двумя точками = " + Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2)));
    }
}
****************/