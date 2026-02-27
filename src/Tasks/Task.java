package Tasks;

import java.util.ArrayList;
import java.util.List;

public class Task extends Base {
    private final ArrayList<SubTask> subTasks = new ArrayList<>();
    private Status status = Status.NEW;

    public Task(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "Основная задача: " + title + "\n" +
               "Статус: " + status + "\n" +
               "Дочерних задач: " + subTasks.size();
    }

    public void addSubTask(SubTask sub) {
        subTasks.add(sub);
        updateStatus();
    }

    public Status getStatus() {
        return status;
    }

    private void updateStatus() {
        checkAndComplete();
    }

    public boolean checkAndComplete() {
        if (subTasks.isEmpty()) return false;

        boolean allDone = subTasks.stream().allMatch(SubTask::isCompleted);

        if (allDone) {
            this.status = Status.DONE;
            return true;
        } else {
            this.status = Status.IN_PROGRESS;
            return false;
        }
    }

    public ArrayList<SubTask> getSubTasks() {
        return new ArrayList<>(subTasks);
    }
}
