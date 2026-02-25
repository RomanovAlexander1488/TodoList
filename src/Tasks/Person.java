package Tasks;

import java.util.HashMap;
import java.util.Map;

public abstract class Person {
    protected String id;
    protected String name;
    protected Map<String, String> hmTasks;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
        this.hmTasks = new HashMap<>();
    }

    public void addMoney(double sum) {
        System.out.println(name + " получил " + sum + " руб.");
    }

    public void removeMoney(double sum) {
        System.out.println(name + " потратил " + sum + " руб.");
    }

    public abstract void doWork();

    public void addTask(String taskName, String taskDesc) {
        hmTasks.put(taskName, taskDesc);
    }

    public void showTasks() {
        System.out.println("Задачи " + name + ": " + hmTasks);
    }

    public String getId() { return id; }
    public String getName() { return name; }
}