
import java.util.ArrayList;
import java.util.Scanner;

public class Task {
    static ArrayList<String> tasks =new ArrayList<>();
    static ArrayList<String> done_tasks =new ArrayList<>();
    static ArrayList<String> not_done_tasks =new ArrayList<>();
    public static String task,new_task,creation_date,complete_date,task_name,description,status;
    int task_id;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Список команд: \n" +
                "1 - Создать задание\n" +
                "2 - Удалить задание\n" +
                "3 - Отредактировать задание\n" +
                "4 - Просмотреть список ВСЕХ заданий\n" +
                "5 - Просмотреть список ВЫПОЛНЕННЫХ заданий\n" +
                "6 - Просмотреть список НЕВЫПОЛНЕННЫХ заданий\n" +
                "7 - Пункты 4-6 на конкретную дату ВЫПОЛНЕНИЯ\n" +
                "8 - Пункты 4-6 на конкретную дату СОЗДАНИЯ\n" +
                "9 - Просмотреть детальную информацию о задании\n"+
                "0 - Выход из команд.");
        String command;

        //вводим команды и после проверяем условия, чтобы найти нужную команду
        while(true) {
            System.out.println("Введите команду: ");
            command=scanner.nextLine();
            if(command.equalsIgnoreCase("1")){
                int task_id=generate(1,50);
                create_task(task_id);
            }
            if(command.equalsIgnoreCase("2")){
                delete_task();
            }
            if(command.equalsIgnoreCase("3")){
                update_task();
            }
            if(command.equalsIgnoreCase("4")){
                list_task();
            }
            if(command.equalsIgnoreCase("5")){
                done_tasks();
            }
            if(command.equalsIgnoreCase("6")){
                not_done_tasks();
            }
            if(command.equalsIgnoreCase("7")){
                list_complete_date();
            }
            if(command.equalsIgnoreCase("8")){
                list_creation_date();
            }
            if(command.equalsIgnoreCase("9")){
                description_task();
            }
            if(command.equalsIgnoreCase("0")){
                break;
            }
    }

    //метод для создания задачи
    public static void create_task(int task_id){
        //вводим каждый пункт по очереди
        System.out.println("Введите дату создания в формате 'DD-MM-YYYY': ");
        creation_date= scanner.nextLine();
        String tmp_cr_date= creation_date.replaceAll("\\p{Punct}","");
        String regex = "[0-9]+";
        //проверяем чтобы дата была в корректном формате
        while(!(tmp_cr_date.length()==8 && tmp_cr_date.matches(regex))){
            System.out.println("Ошибка! Не правильный ввод даты(DD-MM-YYYY). Попробуйте снова.");
            creation_date=scanner.nextLine();
            tmp_cr_date= creation_date.replaceAll("\\p{Punct}","");
        }
        System.out.println("Введите дату выполнения: ");
        complete_date=scanner.nextLine();
        String tmp_com_date= complete_date.replaceAll("\\p{Punct}","");
        while(!(tmp_com_date.length()==8 && tmp_com_date.matches(regex))){
            System.out.println("Ошибка! Не правильный ввод даты(DD-MM-YYYY). Попробуйте снова.");
            complete_date=scanner.nextLine();
            tmp_com_date= complete_date.replaceAll("\\p{Punct}","");
        }
        System.out.println("Введите наименование: ");
        task_name=scanner.nextLine();
        System.out.println("Введите детальное описание: ");
        description = scanner.nextLine();
        System.out.println("Введите статус задания(выполненно/не выполненно): ");
        status= scanner.nextLine();
        //проверяем что статус может быть только выполненно/не выполненно
        if(!(status.equalsIgnoreCase("выполненно")) && !(status.equalsIgnoreCase("не выполненно"))){
            System.out.println("Ошибка! Другой статус установить нельзя. Попробуйте снова");
            status=scanner.nextLine();
        }
        String task_id_str = String.valueOf(task_id);
        task="номер задачи: " + task_id_str +", дата создания: " +creation_date+ ", дата выполнения: "+complete_date + ", наименование: " +task_name+", детальное описание: "+description+", статус задачи: "+status;
        System.out.println("Созданo:\n"+task);
        tasks.add(task);

        //дополнительно проверяем статус чтобы рассртировать по спискам
        if(status.equalsIgnoreCase("выполненно")){
            done_tasks.add(task);
        }
        else if(status.equalsIgnoreCase("не выполненно")){
            not_done_tasks.add(task);
        }

    }
    //метод для удаления задачи
    public static void delete_task(){
        System.out.println("Укажите номер задачи, которую хотите удалить: ");
        String task_id_str= scanner.nextLine();
        for (String value : tasks) {
            String tmp_delete=value.substring(value.indexOf("задачи:")+8,value.indexOf(", дата создания"));
            if (tmp_delete.equalsIgnoreCase(task_id_str)){ //проверяем номер задачи, если задача с заданным номеров сущесвует, удаляем ее
                tasks.remove(value);
                System.out.println("Удалена задача с номером: " + task_id_str);
            }
            //иначе выводим сообщение, что такой задачи нет
            else{
                System.out.println("Задачи с таким номером не существует");
            }
        }
    }

    //метод для редактирования задач
    public static void update_task(){
        System.out.println("Укажите номер задачи, которую хотите отредактировать: ");
        String task_id_str= scanner.nextLine();
        System.out.println("Укажите пункт задачи, который хотите отредактировать(Дата создания, Дата выполнения, Наименование, Детальное описание, Статус): ");
        String update_task = scanner.nextLine();

        //прописываем условие для каждог пункта, который можно отредактировать
        if (update_task.equalsIgnoreCase("Дата создания")) {
            System.out.println("Введите новую дату создания: ");
            String new_creation_date = scanner.nextLine();
            new_task = task.replace(creation_date, new_creation_date);
            tasks.remove(task);
            System.out.println("Задача отредактирована:\n" + new_task);
            tasks.add(new_task);
        } else if (update_task.equalsIgnoreCase("Дата выполнения")) {
            System.out.println("Введите новую дату выполнения: ");
            String new_complete_date = scanner.nextLine();
            new_task = task.replace(complete_date, new_complete_date);
            tasks.remove(task);
            System.out.println("Задача отредактирована:\n" + new_task);
            tasks.add(new_task);
        } else if (update_task.equalsIgnoreCase("Наименование")) {
            System.out.println("Введите новое наименование: ");
            String new_task_name = scanner.nextLine();
            new_task = task.replace(task_name, new_task_name);
            tasks.remove(task);
            System.out.println("Задача отредактирована:\n" + new_task);
            tasks.add(new_task);
        } else if (update_task.equalsIgnoreCase("Детальное описание")) {
            System.out.println("Введите новое детальное описание: ");
            String new_descripton = scanner.nextLine();
            new_task = task.replace(description, new_descripton);
            tasks.remove(task);
            System.out.println("Задача отредактирована:\n" + new_task);
            tasks.add(new_task);
        } else if (update_task.equalsIgnoreCase("Статус")) {
            System.out.println("Введите новый статус: ");
            String new_status = scanner.nextLine();
            if (!(new_status.equalsIgnoreCase("выполненно")) && !(new_status.equalsIgnoreCase("не выполненно"))) {
                System.out.println("Ошибка! Другой статус установить нельзя. Попробуйте снова");
                new_status = scanner.nextLine();
            }
            new_task = task.replace(status, new_status);
            tasks.remove(task);
            System.out.println("Задача отредактирована:\n" + new_task);
            tasks.add(new_task);
            //дополнительно проверяем статус задачи, чтобы рассотривать задачи по спискам
            if (new_status.equalsIgnoreCase("выполненно")) {
                not_done_tasks.remove(task);
                done_tasks.add(new_task);
            } else if (new_status.equalsIgnoreCase("не выполненно")) {
                done_tasks.remove(task);
                not_done_tasks.add(new_task);
            }
        }
    }

    //метод для всех невыполненных задач
    public static void list_task() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.print(tasks.get(i) + "\n");
        }
    }

    //метод для получения всех выполненных задач
    public static void done_tasks() {
        //проходим по списку, если выполненные задачи есть, то выводим их, если нет то выводим сообщение об их отсутствии
        for (int i = 0; i < done_tasks.size(); i++) {
            System.out.print(done_tasks.get(i) + "\n");
        }
        if (done_tasks.size()==0){
            System.out.println("Еще нет выполненных задач.");
        }
    }
    //метод для получения всех невыполненных задач
    public static void not_done_tasks(){
        //проходим по списку, если невыполненные задачи есть, то выводим их, если нет то выводим сообщение об их отсутствии
        for (int i = 0; i < not_done_tasks.size(); i++) {
            System.out.print(not_done_tasks.get(i) + "\n");
        }
        if(not_done_tasks.size()==0){
            System.out.println("Невыполненных задач нет");
        }
    }

    //метод для получения списка задач на конкретную дату создания
    public static void list_creation_date() {
        System.out.println("Укажите список каких задач хотите посмотреть\n" +
                "1 - Просмотреть список ВСЕХ заданий на конкретную дату создания\n" +
                "2 - Просмотреть список ВЫПОЛНЕННЫХ заданий на конкретную дату создания\n" +
                "3 - Просмотреть список НЕВЫПОЛНЕННЫХ заданий на конкретную дату создания");
        String option_list = scanner.nextLine();
        System.out.println("Укажите дату создания, чтобы посмотреть список задач: ");
        String list_creation_date = scanner.nextLine();
        if (option_list.equalsIgnoreCase("1")) { //условие для получения всех задач
            ArrayList<String> all_creation_date = new ArrayList<>();
            for (String value : tasks) {
                String tmp_str=value.substring(value.indexOf("я:")+3,value.indexOf(", дата выполнения"));
                if (tmp_str.equalsIgnoreCase(list_creation_date)) {//ищем существуют ли задачи с заданной датой
                    all_creation_date.add(value);
                } else {
                    System.out.print("");
                }
            }
            System.out.println("Все задачи на дату создания: "+list_creation_date);
            for (int i = 0; i < all_creation_date.size(); i++) {//выводим все задачи на конкретную дату выполнения
                System.out.println(all_creation_date.get(i));
            }
        }
        else if(option_list.equalsIgnoreCase("2")) { //условие для получения всех выполненных задач на конкретную дату создания
                ArrayList<String> done_creation_date = new ArrayList<>();
                for (String values : done_tasks) {
                    String tmp_str=values.substring(values.indexOf("я:")+3,values.indexOf(", дата выполнения"));
                    if (tmp_str.equalsIgnoreCase(list_creation_date)) { //ищем существуют ли выполненные задачи с заданной датой
                        done_creation_date.add(values);
                    } else {
                        System.out.print("");
                    }
                }
                System.out.println("Все выполненные задачи на дату создания: "+list_creation_date);
                for (int i = 0; i < done_creation_date.size(); i++) {//выводим все выполненные задачи на конкретную дату выполнения
                    System.out.println(done_creation_date.get(i));
                }
            }
        else if(option_list.equalsIgnoreCase("3")){//условие для получения всех невыполненных задач на конкретную дату создания
            ArrayList<String> not_done_creation_date = new ArrayList<>();
            for (String value : not_done_tasks) {
                String tmp_str=value.substring(value.indexOf("я:")+3,value.indexOf(", дата выполнения"));
                if (tmp_str.equalsIgnoreCase(list_creation_date)) { //ищем существуют ли невыполненные задачи с заданной датой
                    not_done_creation_date.add(value);
                } else {
                    System.out.print("");
                }
            }
            System.out.println("Все невыполненные задачи на дату создания: "+list_creation_date);
            for (int i = 0; i < not_done_creation_date.size(); i++) {//выводим все невыполненные задачи на конкретную дату выполнения
                System.out.println(not_done_creation_date.get(i));
            }
        }
    }

    //метод для получения списка задач на конкретную дату выполнения
    public static void list_complete_date() {
        System.out.println("Укажите список каких задач хотите посмотреть\n" +
                "1 - Просмотреть список ВСЕХ заданий на конкретную дату выполнения\n" +
                "2 - Просмотреть список ВЫПОЛНЕННЫХ заданий на конкретную дату выполнения\n" +
                "3 - Просмотреть список НЕВЫПОЛНЕННЫХ заданий на конкретную дату выполнения");
        String option_list = scanner.nextLine();
        System.out.println("Укажите дату выполнения, чтобы посмотреть список задач: ");
        String list_complete_date = scanner.nextLine();
        if (option_list.equalsIgnoreCase("1")) { //условие для получения всех задач
            ArrayList<String> all_compete_date = new ArrayList<>();
            for (String value : tasks) {
                String tmp_str=value.substring(value.indexOf("выполнения:")+12,value.indexOf(", наименование"));
                String tmp_list_com_date= tmp_str.replaceAll("\\p{Punct}","");
                String tmp1_lst_com_date= list_complete_date.replaceAll("\\p{Punct}","");
                if (tmp_list_com_date.equalsIgnoreCase(tmp1_lst_com_date)) {//ищем существуют ли задачи с заданной датой
                    all_compete_date.add(value);
                } else {
                    System.out.print("");
                }
            }
            System.out.println("Все задачи на дату выполнения: "+list_complete_date); //выводим все задачи на конкретную дату выполнения
            for (int i = 0; i < all_compete_date.size(); i++) {
                System.out.println(all_compete_date.get(i));
            }
        }
        else if(option_list.equalsIgnoreCase("2")) {//условие для получения всех выполненных задач
            ArrayList<String> done_complete_date = new ArrayList<>();
            for (String values : done_tasks) {
                String tmp_str=values.substring(values.indexOf("выполнения:")+12,values.indexOf(", наименование"));
                String tmp_done_cr_date= tmp_str.replaceAll("\\p{Punct}","");
                if (tmp_done_cr_date.equalsIgnoreCase(list_complete_date)) {//ищем существуют выполненные ли задачи с заданной датой
                    done_complete_date.add(values);
                } else {
                    System.out.print("");
                }
            }
            System.out.println("Все выполненные задачи на дату выполнения: "+list_complete_date);
            for (int i = 0; i < done_complete_date.size(); i++) { //выводим все выполненные задачи на конкретную дату выполнения
                System.out.println(done_complete_date.get(i));
            }
        }
        else if(option_list.equalsIgnoreCase("3")){ //условие для получения всех невыполненных задач
            ArrayList<String> not_done_complete_date = new ArrayList<>();
            for (String value : not_done_tasks) {
                String tmp_str=value.substring(value.indexOf("выполнения:")+12,value.indexOf(", наименование"));
                String tmp_not_done_cr_date= tmp_str.replaceAll("\\p{Punct}","");
                if (tmp_not_done_cr_date.equalsIgnoreCase(list_complete_date)) { //ищем существуют ли невыполненные задачи с заданной датой
                    not_done_complete_date.add(value);
                } else {
                    System.out.print("");
                }
            }
            System.out.println("Все невыполненные задачи на дату выполнения: "+list_complete_date);
            for (int i = 0; i < not_done_complete_date.size(); i++) {//выводим все невыполненные задачи на конкретную дату выполнения
                System.out.println(not_done_complete_date.get(i));
            }
        }
    }

    //метод для получения детального описания
    public static void description_task(){
        System.out.println("Укажите номер задачи, детальную информацию которой хотите узнать: ");
        String description_task_id= scanner.nextLine();
        for (String value : tasks) {
            String tmp_desc=value.substring(value.indexOf("задачи:")+8,value.indexOf(", дата создания"));
            if (tmp_desc.equalsIgnoreCase(description_task_id)) { //проверяем существует ли номер задачи
                //если существует, выводим детальное описание задачи
                String description_task=value.substring(value.indexOf("описание:")+10,value.indexOf(", статус задачи"));
                System.out.println("Детальное описание задачи номер: " + description_task_id + "\n" + description_task);
            }
            else if (!(tmp_desc.equalsIgnoreCase(description_task_id))){ //если такой задачи нет, то выводим следующее сообщение:
                System.out.println("Задачи с таким номером не существует");
            }
        }
    }

    //метод для генерации номера задачи
    public static int generate(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
