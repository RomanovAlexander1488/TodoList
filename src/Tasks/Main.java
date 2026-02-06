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

        System.out.println(myTask);

        s1.setCompleted(true);
        s2.setCompleted(true);

        if (myTask.checkAndComplete()) {
            System.out.println("Успешно " + myTask);
        }

        Task duplicateTask = new Task("Реализовать программу");
        List<Task> taskList = Arrays.asList(myTask, duplicateTask, new Task("Другая задача"));

        System.out.println("\n====Демонстрация====");
        Utils.checkUniqueness(taskList);

        System.out.println("\n====Вывод диаграммы====");
        Utils.printTaskTree(myTask);
    }
}