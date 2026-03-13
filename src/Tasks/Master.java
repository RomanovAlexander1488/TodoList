package Tasks;

import Interfes.AddMoney;
import Interfes.Finansable;

public class Master extends AbstractTask implements Finansable {
    private String department;

    public Master(String id, String name, double initialMoney, String priority, String department) {
        super(id, name, initialMoney, priority);
        this.department = department;
    }

    @Override
    public void addMoney(double amount) {
            if (amount > 0) {
                wallet += amount;
                System.out.println(name + " получил " + amount + " денег. Баланс: " + wallet);
            }
    }

    @Override
    public void displayRole() {
        System.out.println("Роль: Мастер. Имя: " + name + ", Отдел: " + department + ", Приоритет: " + priority);
    }

    public void completeTask(String taskTitle, Client client) {
        System.out.println("\n--- Мастер " + name + " выполняет задачу ---");
        if (hmTasks.containsKey(taskTitle)) {
            double price = hmTasks.get(taskTitle);
            System.out.println("Мастер " + name + " выполнил задачу '" + taskTitle +
                               "' стоимостью " + price);
            if (client != null) {
                client.removeMoney(price);
                this.addMoney(price);
                System.out.println("Клиент " + client.getName() + " оплатил задачу мастеру " + name);
            }
        } else {
            System.out.println("У мастера " + name + " нет задачи с названием '" + taskTitle + "'");
        }
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Master{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", wallet=" + wallet +
               ", priority='" + priority + '\'' +
               ", department='" + department + '\'' +
               ", tasks=" + hmTasks.size() +
               '}';
    }

    @Override
    public boolean removeMoney(double amount) {
        return false;
    }
}