package Tasks;

import java.util.ArrayList;
import java.util.List;

public class MyArchive {
    private static final List<Task> archivedTasks = new ArrayList<>();

    public static void showArchive() {
        System.out.println("===в архиве===");
        archivedTasks.forEach(System.out::println);
    }

    public static void addNewTask(Task task) {
        archivedTasks.add(task);
        System.out.println("Сообщение от архива: Задача '" + task.getTitle() + "' добавлено в архив.");
    }

}
