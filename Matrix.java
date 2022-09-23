/**********************************
 Реализуйте класс матрицы и методы
 Сложение и вычитание матриц.
 Умножение матрицы на число.
 Произведение двух матриц.
 Транспонированная матрица.
 Возведение матрицы в степень.
 Если метод, возвращает матрицу, то он должен возвращать новый объект, а не
 менять базовый.
 *******************************************/

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix1, matrix2;
        matrix1 = new int[2][2]; //Задаем размер матрицы
        matrix2 = new int[2][2]; //Задаем размер матрицы

        //Заполняем матрицу 1
        matrix1[0][0] = 4;
        matrix1[0][1] = 2;
        matrix1[1][0] = 9;
        matrix1[1][1] = 0;

        //Выводим матрицу 1
        System.out.println("Матрица 1: ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix1[i][j] + "\t");
            }
            System.out.println();
        }

        //Заполняем матрицу 2
        matrix2[0][0] = 3;
        matrix2[0][1] = 1;
        matrix2[1][0] = -3;
        matrix2[1][1] = 4;

        //Выводим матрицу 2
        System.out.println("Матрица 2: ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix2[i][j] + "\t");
            }
            System.out.println();
        }

        //Сложение матриц
        System.out.println("Матрица 1+2: ");
        int[][] matrix12;
        matrix12 = new int[2][2];
        for (int i = 0; i < matrix12.length; i++) {
            for (int j = 0; j < matrix12[i].length; j++) {
                matrix12[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(" " + matrix12[i][j] + "\t");
            }
            System.out.println();
        }
        //Вычитание матриц
        System.out.println("Матрица 1-2: ");
        int[][] matrixC;
        matrixC = new int[2][2];
        for (int i = 0; i < matrixC.length; i++) {
            for (int j = 0; j < matrixC[i].length; j++) {
                matrixC[i][j] = matrix1[i][j] - matrix2[i][j];
                System.out.print(" " + matrixC[i][j] + "\t");
            }
            System.out.println();
        }

        //Умножение матрицы на число
        System.out.println("Матрица1* num: ");
        int[][] matrix1A;
        matrix1A = new int[2][2];
        Scanner in = new Scanner(System.in); //Используем Scanner, чтобы позволить пользователю ввести число с клавиатуры
        System.out.print("Введите число, на которое хотите умножить матрицу1: ");
        int num = in.nextInt();

        for (int i = 0; i < matrix1A.length; i++) {
            for (int j = 0; j < matrix1A[i].length; j++) {
                matrix1A[i][j] = matrix1[i][j] * num;
                System.out.print(" " + matrix1A[i][j] + "\t");
            }
            System.out.println();
        }
    }
}