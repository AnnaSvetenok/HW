//Создать 3 класса(базовый и 2 дочерних) которые описывают некоторых работников с почасовой оплатой
//(один из дочерних) и фиксированой оплатой (второй дочерний).
//Описать в базовом классе абстрактный метод для расчета среднемесячной зарплаты.
//Для «почасовщиков» формула для расчета такая: «среднемесячная зарплата = 20.8*8*ставка в час»,
//для работников с фиксированой оплатой «среднемесячная зарплата = фиксированой месячной оплате».
//a)Упорядочить всю последовательность рабочих по убыванию среднемесячной зарплаты.
//При совпадении зарплаты – упорядочить данные в алфавитном порядке по имени. Вывести идентификатор работника,
//имя и среднемесячную зарплату для всех елементов списка.
package семенары;

public class Semenar_08_10 {
    public static void main(String[] args) {

    }


    public abstract class Worker {
        int worker_id; //идентификатор работника
        String worker_name; //имя работника
        double salary; //зарплата за промежуток времени(час/месяц)
        double full_salary; //полная зарплата

        abstract void SalaryCalculations();

    }

    class Hour_Worker extends Worker {
        public Hour_Worker(int worker_id, String worker_name, double salary) {

            this.worker_id = worker_id;
            this.worker_name = worker_name;
            this.salary = salary;

        }

        @Override
        void SalaryCalculations() {
            //Для «почасовщиков» формула для расчета такая: «среднемесячная зарплата = 20.8*8*ставка в час»
            this.full_salary = 20.8 * 8 * this.salary;

        }
    }

    class Fixed_Salary_Worker extends Worker {
        public Fixed_Salary_Worker(int worker_id, String worker_name, double salary) {

            this.worker_id = worker_id;
            this.worker_name = worker_name;
            this.salary = salary;

        }

        @Override
        void SalaryCalculations() {
            //для работников с фиксированой оплатой «среднемесячная зарплата = фиксированой месячной оплате»
            this.full_salary = this.salary;
        }
    }

}

