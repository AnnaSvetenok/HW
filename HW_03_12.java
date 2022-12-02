
public class HW_03_12 {
        public static void main(String[] args) {
            Exercise1();

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
                } catch (InterruptedException error) { //когда главный поток снова выполняется, завершаем остальные два потока
                    System.out.printf("Поток %s завершен.\n", getName());
                }
            }
        }
}

