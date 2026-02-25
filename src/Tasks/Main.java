package Tasks;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Task myTask = new Task("Реализовать программу");
        SubTask s1 = new SubTask("Посадить дерево");
        SubTask s2 = new SubTask("Протестировать выполнение");

        myTask.addSubTask(s1);
        myTask.addSubTask(s2);

        System.out.println("====Начало====");
        System.out.println(myTask);

        s1.setCompleted(true);
        s2.setCompleted(true);

        if (myTask.checkAndComplete()) {
            System.out.println("\n====После выполнения всех подзадач====");
            System.out.println("Сделано! " + myTask);
        }

        Task duplicateTask = new Task("Написать код");
        List<Task> taskList = Arrays.asList(myTask, duplicateTask, new Task("Другая задача"));

        System.out.println("\n====Показ уникальности====");
        Utils.checkUniqueness(taskList);

        System.out.println("\n====Вывод диаграмм====");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Task anotherTask = new Task("Другая задача");
        Utils.completingTheTask(anotherTask, false);

        taskList.sort(new MyComparator());

        Utils.completingTheTask(myTask, true);
        Utils.completingTheTask(anotherTask, false);

        MyComparator statusComparator = new MyComparator();
        taskList.sort(statusComparator);

        System.out.println("\n====Задачи, отсортированные по статусу====");
        taskList.forEach(System.out::println);

        System.out.println("\n========== ПРОВЕРКА PERSON ==========");

        Master master = new Master("M001", "Иван Петров");
        Client client = new Client("C001", "Анна Сидорова");

        System.out.println("\n--- Проверка методов Person (деньги) ---");
        master.addMoney(5000);
        master.removeMoney(1500);

        client.addMoney(10000);
        client.removeMoney(2500);

        System.out.println("\n--- Добавление задач мастеру ---");
        master.addTask("Ремонт розетки", "Срочно, кухня - 2000 руб.");
        master.addTask("Заменить проводку", "Коридор - 5000 руб.");
        master.addTask("Починить свет", "Ванная - 1500 руб.");
        master.showTasks();

        System.out.println("\n--- Выполнение задачи мастером ---");
        master.completeTask("Ремонт розетки", 2000);
        master.showTasks();

        System.out.println("\n--- Проверка абстрактного метода doWork() ---");
        master.doWork();
        client.doWork();

        System.out.println("\n--- Итоговое состояние ---");
        System.out.println("Мастер: " + master.getId() + " - " + master.getName());
        System.out.println("Клиент: " + client.getId() + " - " + client.getName());


//        Master chief = new Master("Настройка сервера", "Высокий", "IT");
//        chief.displayRole();
//        System.out.println(chief);

//        Task myTask = new Task("Реализовать программу");
//        SubTask s1 = new SubTask("Посадить дерево");
//        SubTask s2 = new SubTask("Протестировать выполнение");
//        SubTask s3 = new SubTask("Новая невыполненная задача");
//
//        myTask.addSubTask(s1);
//        myTask.addSubTask(s2);
//        myTask.addSubTask(s3);
//
//        System.out.println(myTask);
//
//        s1.setCompleted(true);
//        s2.setCompleted(true);
//
//        if (myTask.checkAndComplete()) {
//            System.out.println("Успешно " + myTask);
//        }
//
//        myTask.checkAndComplete();
//
//        System.out.println("====Состояние основной задачи====");
//        System.out.println(myTask);
//
//        Task duplicateTask = new Task("Реализовать программу");
//        List<Task> taskList = Arrays.asList(myTask, duplicateTask, new Task("Другая задача"));
//
//        System.out.println("\n====Демонстрация====");
//        Utils.checkUniqueness(taskList);
//
//        System.out.println("\n====Вывод диаграммы====");
//        Utils.printTaskTree(myTask);
    }
}