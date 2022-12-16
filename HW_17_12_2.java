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
    
    //метод для генерации случайных чисел для массива
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
