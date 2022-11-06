import java.util.Random;

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void main(String[] args) {
        Vector vector1 = new Vector(1.0, 3.0, 7.0);
        Vector vector2 = new Vector(2.5, 8.0, 0.5);

        System.out.println("Длина вектора: " + vector1.length());
        System.out.println("Скалярное произведение вектора: " + vector1.scalar(vector2));
        System.out.println("Векторное произдение с другим вектором. Получился вектор: " + vector1.vectorProduct(vector2));
        System.out.println("Угол между векторами (или косинус угла): " + vector1.cos(vector2));
        System.out.println("Сумма векторов. Получился вектор: " + vector1.sum(vector2));
        System.out.println("Разность веторов. Получился вектор: " + vector1.difference(vector2));
        System.out.print("Массив векторов: ");
        int vectors = list(5);

    }

    //метод, вычисляющий длину вектора
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    //метод, вычисляющий скалярное произведение
    public double scalar(Vector vector) {
        return (x * vector.x + y * vector.y + z * vector.z);
    }

    //метод, вычисляющий векторное произведение с другим вектором
    public String vectorProduct(Vector vector) {
        double new_x = y * vector.z - z * vector.y;
        double new_y = z * vector.x - x * vector.z;
        double new_z = x * vector.y - y * vector.x;
        return new_x + ", " + new_y + ", " + new_z;
    }

    //метод, вычисляющий угол между векторами (или косинус угла)
    public double cos(Vector vector) {
        return (scalar(vector) / (length() * vector.length()));
    }

    //метод для суммы векторов
    public String sum(Vector vector) {
        double new_x = x + vector.x;
        double new_y = y + vector.y;
        double new_z = z + vector.z;
        return new_x + ", " + new_y + ", " + new_z;
    }

    //метод для разности векторов
    public String difference(Vector vector) {
        double new_x = x - vector.x;
        double new_y = y - vector.y;
        double new_z = z - vector.z;
        return new_x + ", " + new_y + ", " + new_z;
    }

    //статический метод, который принимает целое число N, и возвращает массив
    //случайных векторов размером N
    public static int list(int n) {
        //ArrayList<ArrayList<Double>> vectors = new ArrayList<>(n);
        Random random = new Random();
        int [][] vectors = new int[1][3]; //создаем двумерный массив для записи координат векторов
        for(int k=0; k<n; k++){
            System.out.print("[ ");
            for (int i = 0; i < vectors.length; i++) { //заполняем массив
                for (int j=0; j<vectors[i].length;j++){
                    vectors[i][j]=random.nextInt(3);
                    System.out.print(vectors[i][j]+ " ");
                }
                System.out.print("]");
            }
        }
        return 0;
    }
}
