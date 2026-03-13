package Tasks;
//изминил Finansable, добавил try catch
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Task myTask = new Task("Реализовать программу", 2500.0);
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

        Task duplicateTask = new Task("Написать код", 1500.0);
        Task anotherTask = new Task("Другая задача", 500.0);
        Task expensiveTask = new Task("Деплой сервера", 5000.0);

        ArrayList<Task> taskList = new ArrayList<>(Arrays.asList(myTask, duplicateTask, anotherTask, expensiveTask));

        System.out.println("\n==== Сортировка задач по цене (от дешевых к дорогим) ====");

        List<Task> sortedTasks = taskList.stream()
                .sorted((t1, t2) -> Double.compare(t1.getPrice(), t2.getPrice()))
                .collect(Collectors.toList());

        Iterator<Task> iterator = sortedTasks.iterator();
        while (iterator.hasNext()) {
            Task t = iterator.next();
            System.out.println(t.getTitle() + " - Цена: " + t.getPrice());
        }

        Task maxTask = taskList.stream()
                .max((t1, t2) -> Double.compare(t1.getPrice(), t2.getPrice()))
                .orElse(null);

        Task minTask = taskList.stream()
                .min((t1, t2) -> Double.compare(t1.getPrice(), t2.getPrice()))
                .orElse(null);

        System.out.println("\nСамая дорогая задача: " + (maxTask != null ? maxTask.getTitle() : "Нет"));
        System.out.println("Самая дешевая задача: " + (minTask != null ? minTask.getTitle() : "Нет"));


        System.out.println("\n====Показ уникальности====");
        Utils_Task utilsTask = new Utils_Task();
        utilsTask.Update_Task(taskList);

        System.out.println("\n====Вывод диаграмм====");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        taskList.sort(new MyComparator());
        System.out.println("\n====Задачи, отсортированные по статусу====");
        taskList.forEach(System.out::println);

        System.out.println("\n=== Person Client ===\n");

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

        System.out.println("\n=== Обработка оплаты задачи (Try-Catch) ===");
        try {
            String taskTitle = "Починить кран";
            double taskPrice = 1500;

            if (!myTask.checkAndComplete()) {
                throw new Exception("Ошибка: Задача '" + myTask.getTitle() + "' еще не завершена!");
            }

            if (client.getWalletBalance() < taskPrice) {
                throw new Exception("Ошибка: Недостаточно средств! Баланс: " + client.getWalletBalance() + ", Нужно: " + taskPrice);
            }

            client.payForTask(taskTitle, taskPrice, master);
            System.out.println("Транзакция прошла успешно.");

        } catch (Exception e) {
            System.err.println("ОШИКБА ОПЛАТЫ: " + e.getMessage());
        }

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