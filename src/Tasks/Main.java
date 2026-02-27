package Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //реализовать третий пункт
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
        ArrayList<Task> taskList = new ArrayList<>(Arrays.asList(myTask, duplicateTask, new Task("Другая задача")));

        System.out.println("\n====Показ уникальности====");
        Utils_Task utilsTask = new Utils_Task();
        utilsTask.Update_Task(taskList);

        System.out.println("\n====Вывод диаграмм====");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        taskList.sort(new MyComparator());


       utilsTask.Update_Task(taskList);
        MyComparator statusComparator = new MyComparator();
        taskList.sort(statusComparator);

        System.out.println("\n====Задачи, отсортированные по статусу====");
        taskList.forEach(System.out::println);

//        Master chief = new Master("Настройка сервера", "Высокий", "IT");
//        chief.displayRole();
//        System.out.println(chief);

        System.out.println("=== Person Client ===\n");

        Client client = new Client("C001", "Иван Петров", 5000);

        Master master = new Master("M001", "Петр Иванов", 1000, "Высокий", "Сантехник");

        client.displayRole();
        master.displayRole();

        System.out.println("\n=== Начальные балансы ===");
        System.out.println(client.getName() + ": " + client.getWalletBalance());
        System.out.println(master.getName() + ": " + master.getWalletBalance());

        System.out.println("\n=== Добавление задач ===");
        master.addTask("Починить кран", 1500);
        master.addTask("Заменить трубы", 3000);

        System.out.println("\n=== Оплата задачи ===");
        client.payForTask("Починить кран", 1500, master);

        System.out.println("\n=== Балансы после оплаты ===");
        System.out.println(client.getName() + ": " + client.getWalletBalance());
        System.out.println(master.getName() + ": " + master.getWalletBalance());

        System.out.println("\n=== Попытка снять больше чем есть ===");
        client.removeMoney(4000);

        System.out.println("\n=== Задачи мастера ===");
        master.getHmTasks().forEach((title, price) ->
                System.out.println("Задача: " + title + ", цена: " + price));

        System.out.println("\n=== Финальные данные ===");
        System.out.println(client);
        System.out.println(master);

        // Дополнительно: показываем priority мастера
        System.out.println("\n=== Дополнительная информация о мастере ===");
        System.out.println("Приоритет мастера: " + master.getPriority());
        System.out.println("Отдел мастера: " + master.getDepartment());

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