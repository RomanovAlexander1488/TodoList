package Tasks;

import java.util.ArrayList;
import java.util.List;

public class Task extends Base {
    private final ArrayList<SubTask> subTasks = new ArrayList<>();
    private Status status = Status.NEW;
    private double price;

    public Task(String title, double price) {
        super(title);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Задача: %-20s | Цена: %8.2f | Статус: %s | Подзадач: %d",
                title, price, status, subTasks.size());
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
        this.status = allDone ? Status.DONE : Status.IN_PROGRESS;
        return allDone;
    }

    public ArrayList<SubTask> getSubTasks() {
        return new ArrayList<>(subTasks);
    }
}