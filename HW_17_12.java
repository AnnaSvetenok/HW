import java.util.Arrays;

public class HW_17_12 {
    public static void main(String [] args){
        System.out.println("Упражнение 1. \n" + Exercise1(5));
        System.out.println("Упражнение 3. \n" + Exercise3(0,10,0.0,10.0,0.001));

    }
    public static String  Exercise1(int n){
        //Дано натуральное число n. Выведите все числа от 1 до n.
        if(n==1){
            return "1";
        }
        return (Exercise1(n-1) + " " + n);
    }

    public static double Exercise3(double a, double b,double fa, double fb, double sigma){
        //Найдите корень уравнения cos(x^5 )+ x^4-345.3*x-23=0 на отрезке [0;10] с точностью по x не хуже 0.001.
        // Известно, что на этом промежутке корень единственный. Используйте для этого метод деления отрезка пополам (и рекурсию).

        //метод принимает переменные, где a и b- начало и конец интервала, f(a) и f(b)- значения ф-ии в начале и конце интервала,
        //sigma - значение точности

        //Следуя методу деления отрезка пополам нужно найти переменную c
        double c=0.5*(a+b);
        //проверяем условия для поиска ответа
        if (Math.abs(a-b)<sigma) //если |a-b|<sigma, то ответом будет с
            return c;
        //вводим новую переменную,обозначающую значение функции в середине интервала, которая равна корню
        // уравнения с переменной 'с'
        double fc=solution(c);
        //если |f(c)|< sigma, то ответ с
        if (Math.abs(fc)<sigma)
            return c;
        //переменные f(a) и f(b) обозначают значение ф-ии в начале и конце интервала
        //если fc*fa<0, то переменная b=c и в дальнейшем уравнение решается с новыми переменными
        if (fc*fa<0)
            return Exercise3(a,c,fa,fc,sigma); //передаем новые переменные
        //если же fc*fb<0, то переменная a=c и в дальнейшем уравнение решается с новыми переменными
        else
            return Exercise3(c,b,fc,fb,sigma); //передаем новые переменные
    }
    //метод, в котором решается уравнение
    public static double solution(double x) {
        return Math.cos(Math.pow(x,5)) + Math.pow(x,4) - 343.3*x - 23;
    }

}
