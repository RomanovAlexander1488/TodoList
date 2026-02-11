package Tasks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    public static void checkUniqueness(List<Task> tasks) {
        Set<Task> uniqueTasks = new HashSet<>(tasks);
        System.out.println("====Проверка====");
        System.out.println("Всего в списке: " + tasks.size());
        System.out.println("Уникальных задач: " + uniqueTasks.size());

        if (tasks.size() == uniqueTasks.size()) {
            System.out.println("Результат: Все задачи уникальны.");
        } else {
            System.out.println("Результат: Найдены похожие.");
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void printTaskTree( Task task) {
        System.out.println(task.toString());

        task.getSubTasks().stream()
                .sorted((s1, s2) -> Boolean.compare(s1.isCompleted(), s2.isCompleted()))
                .forEach(System.out::println);

        System.out.println("\n");
    }

    public static void completingTheTask(Task task, boolean toArchive) {

        task.getSubTasks().forEach(s -> s.setCompleted(true));

        if (toArchive) {
            task.checkAndComplete();
            MyArchive.addNewTask(task);
        } else {
            task.checkAndComplete();
            System.out.println("Информация: Статус задачи '" + task.getTitle() + "' изменён на выполнено.");
        }
    }

}
