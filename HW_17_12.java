import java.util.Arrays;

public class HW_17_12 {
    public static void main(String [] args){
        System.out.println("Упражнение 1. \n" + Exercise1(5));
        //Exercise2();
        System.out.println("Упражнение 3. \n" + Exercise3(0,10,0.0,10.0,0.001));

    }
    public static String  Exercise1(int n){
        //Дано натуральное число n. Выведите все числа от 1 до n.
        if(n==1){
            return "1";
        }
        return (Exercise1(n-1) + " " + n);
    }
/**
    public static double Exercise2(){
        //Напишите метод, который проверяет, входит ли в массив заданный элемент или нет.
        // Используйте перебор и двоичный поиск для решения этой задачи.
        // Сравните время выполнения обоих решений для больших массивов (например, 100000000 элементов).
        public static int enumeration(double[] array, double value){
            for(int i =0; i<array.length;i++){
                if(array[i]==value){
                    return i;
                }
                return 0;
            }
        }
        private static double[] generateRandomArray(int length) {
            double[] array = new double[length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Math.random();
            }
            return array;
        }

    }
 */
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


    public static void Exercise4(){
    //Реализуйте бинарное дерево поиска
    }

}

class HW_17_12_2 {
    //Напишите метод, который проверяет, входит ли в массив заданный элемент или нет.
    // Используйте перебор и двоичный поиск для решения этой задачи.
    // Сравните время выполнения обоих решений для больших массивов (например, 100000000 элементов).
    public static void main(String[] args) {
        double[] array = generateArray(100000000); //заполняем массив радномными значениями
        Arrays.sort(array); //сортируем массив


        long start = System.nanoTime(); //запускаем таймер
        enumeration(array, 0.2);
        long finish = System.nanoTime(); //останавливаем таймер
        long time = finish - start; //считаем сколько выполнялась программа
        System.out.println("Через метод перебора программа выполнялась(в мс): " + time / 1000000);

        long start1 = System.nanoTime(); //запускаем таймер
        BinarySearch(array, 0.2);
        long finish1 = System.nanoTime(); //останавливаем таймер
        long time1 = finish1 - start1; //считаем сколько выполнялась программа
        System.out.println("Через метод двоичного поиска программа выполнялась(в мс): " + time1 / 1000000);

    }

    private static double[] generateArray(int length) {
        double[] array = new double[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
        return array;
    }

    //метод перебора
    public static int enumeration(double[] array, double value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return i;
        }
        return -1;
    }


    //вспомогательный метод для двоичного поиска, который вызывает метод двоичного поиска с расширенными параметрами
    public static int BinarySearch(double[] sortedArray, double value) {
        return BinarySearch(sortedArray, value, 0, sortedArray.length);
    }

    //метод двоичного поиска
    private static int BinarySearch(double[] sortedArray, double value, double firstElement, double lastElement) {

        // условие прекращения
        int middle = (int) ((firstElement+lastElement) / 2); //находим середину массива
        //System.out.println(middle);

        if (lastElement < firstElement) {
            return -1;
        }

        // если серединное значение = искомому значению, то возвращаем серединное значение
        if (value==sortedArray[middle]) {
            return middle;
        }

        // если серединное значение больше искомого
        //ищем в левой половине
        if (value<sortedArray[middle]) {
            return BinarySearch(sortedArray, value, firstElement, middle - 1);
        }

        //если ничего не сошлось, ищем в правой половине
        else{
            return BinarySearch(sortedArray, value, middle + 1, lastElement);
        }
    }
}


class Node{
    private int value; //значечние узла
    private Node leftChild; //левый потомок
    private Node rightChild; //правый потомок

    public void printNode() { // Вывод значения узла в консоль
        System.out.println(" Выбранный узел имеет значение :" + value);
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(final Node leftChild) {
        this.leftChild = leftChild;
    }
    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final Node rightChild) {
        this.rightChild = rightChild;
    }
}

class Tree{
    private Node rootNode; //начальный узел дерева

    public Tree(){ //пустое дерево
        rootNode=null;
    }

    //метод для поиска элемента по значению
    public Node findNode(int value){
        Node currentNode=rootNode; //начинам искать с начального узла

        if(currentNode.getValue()==value){ //если элемент=нужному значению, то возвращаем найденный элемент
            return currentNode;
        }
        if(currentNode==null){ //если потомка нет, то возвращаем null
            return null;
        }
        if(currentNode.getValue()>value){ //если искомый элемент > начального узла, то ищем справа
            currentNode=currentNode.getRightChild();
        }
        else{ //если искомый элемент < начального узла, то ищем слева
            currentNode=currentNode.getLeftChild();
        }
        return currentNode;
    }

    //метод для вставки значения
    public void insertNode(int value){
        Node newNode=new Node(); //создаем новый узел
        newNode.setValue(value);//вставляем новое значени

        if(rootNode==null){ //если корневого элемента нет, то новое значение становится им
            rootNode=newNode;
        }

        Node currentNode = rootNode; // начинаем с корневого узла
        if(value<currentNode.getValue()){ //если значение для вставки < корневого, то оно становится левым наследником
            currentNode=currentNode.getLeftChild();
        }
        if(value>currentNode.getValue()){ //если значение для вставки > корневого, то оно становится правым наследником
            currentNode=currentNode.getRightChild();
        }
        else{ //если значение уже существует, то просто выходим
            return;
        }
    }

    //метод для удаления узла
    public boolean deleteNode(int value){
        Node currentNode = rootNode;
        boolean isrightChild=true;

        if(currentNode==null){ //если узел не найден, вернет false -такого узла нет
            return false;
        }
        if (currentNode.getValue()>value){//определяем в каком направлении искать нужный узел, если настоящее
                                            //значение>значения для удаления, то ищем в правых потомках
            isrightChild=true;
            currentNode=currentNode.getRightChild();
        }
        if(currentNode.getValue()<value){//определяем в каком направлении искать нужный узел, если настоящее
                                            //значение<значения для удаления, то ищем в левых потомках
            isrightChild=false;
            currentNode=currentNode.getLeftChild();
        }
        //случай, когда нужный элемент является конечным узлом
        if (currentNode.getLeftChild()==null && currentNode.getRightChild()==null){
            if(currentNode==rootNode){
                rootNode=null;
            }
        }
        //случай, когдау узла есть один дочерний элемент
        if(currentNode.getRightChild()==null){// узел заменяется левым поддеревом, если правого потомка нет
            if(currentNode==rootNode){
                rootNode=currentNode.getLeftChild();
            }
        }
        if(currentNode.getLeftChild()==null){// узел заменяется правым поддеревом, если левого потомка нет
            if(currentNode==rootNode){
                rootNode=currentNode.getRightChild();
            }
        }
        //случай, когда у узла есть 2 потомка
        Node heir = findHeir(currentNode);// поиск замены для удаляемого узла


    }

    //метод для поиска замены удаляемого узла
    public Node findHeir(Node node){
        Node heirNode = node;
        Node currentNode=node.getRightChild();
    }


}

