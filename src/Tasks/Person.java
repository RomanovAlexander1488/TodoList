package Tasks;

import java.util.HashMap;
import java.util.Map;

public abstract class Person {
    protected String id;
    protected String name;
    protected double wallet;
    protected Map<String, Double> hmTasks;

    public Person(String id, String name, double initialMoney) {
        this.id = id;
        this.name = name;
        this.wallet = initialMoney;
        this.hmTasks = new HashMap<>();
    }





    public void addTask(String taskTitle, double price) {
        hmTasks.put(taskTitle, price);
        System.out.println("Задача '" + taskTitle + "' с ценой " + price + " добавлена для " + name);
    }

    public double getWalletBalance() {
        return wallet;
    }

    public abstract void displayRole();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Double> getHmTasks() {
        return new HashMap<>(hmTasks);
    }

    @Override
    public String toString() {
        return "Person{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", wallet=" + wallet +
               ", tasks=" + hmTasks.size() +
               '}';
    }
}