//Задача1
// Напишите программу, в которой создаются два потока, которые выводят на консоль своё имя по очереди.
/**
 class Treads extends Thread{

 }
 **/
    /**
     class StepThread extends Thread {

     // общий для двух потоков lock
     private Object lock;

     public StepThread(Object object) {
     this.lock = object;
     }

     /**
     * Идея такая: выводим имя потока, потом поток засыпает,
     * перед этим уведомив другой поток, о том, что теперь его очередь.
     *
     * После вызова первым потоком lock.notify() второй поток
     * не просыпается сразу, а ждёт,
     * пока lock не будет освобождён. А когда это происходит, уже вызван
     * метод lock.wait(), и первый поток ждёт своей очереди. И так по кругу.

     @Override
     public void run() {
     while (true) {
     synchronized (lock) {
     try {
     System.out.println(getName());
     lock.notify();
     lock.wait();
     } catch (InterruptedException e) {
     e.printStackTrace();
     }
     }
     }
     }
     }

     public class Semenar_18_11 {
     public static void main(String[] strings) {
     Object lock = new Object();
     new StepThread(lock).start();
     new StepThread(lock).start();
     }
     }
     */


public class HW_03_12 {
        public static void main(String[] args) {
            Exercise1();
            //Exercise2();

        }

        public static void Exercise1() {
            //Напишите программу, в которой создаются два потока, которые выводят на консоль своё имя по очереди.

            //Создаем объект монитора(для блокировки потоков)
            Object monitor = new Object();
            try {
                //Создаем два потока
                Thread thread1 = new Threads(monitor);
                Thread thread2 = new Threads(monitor);

                //Запускаем потоки
                thread1.start();
                thread2.start();
                //Останавливаем главный поток на 12 сек.
                Thread.sleep(12000);

                //Останавливаем созданые потоки и завершаем работу
                thread1.interrupt();
                thread2.interrupt();
            } catch (InterruptedException e) { //обрабатываем исключение, чтобы поток не прерывался
                e.getStackTrace();
            }

        }

        //создаем класс потока в котором прописываем метод run
        static class Threads extends Thread {
            private Object monitor;

            //создаем конструктор, который принимает монитор
            Threads(Object monitor) {
                this.monitor = monitor;
            }

            //создаем метод run для запуска задачи
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) { //пока главный поток остановен, выполняются два других
                        synchronized (monitor) {
                            //Выводим сообщение каждые 2 сек.
                            System.out.printf("Выполняется %s\n", getName());
                            sleep(2000);
                            //сообщаем остановленному потоку, что он может запустится
                            monitor.notify();
                            //запрещаем работать другому потоку
                            monitor.wait();
                        }
                    }
                } catch (InterruptedException error) { //когда главный поток снова выполняется, завешаем остальные два потока
                    System.out.printf("Поток %s завершен.\n", getName());
                }
            }
        }
/***
        public static void Exercise2() {
            //Дано два потока — производитель и потребитель.
            //Производитель генерирует некоторые данные (в примере — числа). Производитель «потребляет» их.
            //Два потока разделяют общий буфер данных, размер которого ограничен.
            //Если буфер пуст, потребитель должен ждать, пока там появятся данные.
            //Если буфер заполнен полностью, производитель должен ждать, пока потребитель заберёт данные и место освободится.

            Store store = new Store();
            Producer producer = new Producer();
            Consumer consumer = new Consumer();

        class Store {
            private int product = 0;

            public synchronized void get() {
                while (product < 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
                product--;
                System.out.println("покупателя купил один товар");
                System.out.println("товаров на складе " + product);
                notify();
            }


            public synchronized void get() {
                while (product >= 3) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            product --;
            System.out.println("покупателя купил один товар");
            System.out.println("товаров на складе "+ product);
            notify();
        }

        class producer implements Runnable {
            Store store;

            public Producer(Store store) {
                this.store = store;
            }

            public void run() {
                for (int i = 1; i < 6; i++) {
                    store.put();
                }
            }
        }
        }
 **/
}

