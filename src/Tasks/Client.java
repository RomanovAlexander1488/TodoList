package Tasks;

import Interfes.AddMoney;
import Interfes.SpendMoney;

public class Client extends Person implements SpendMoney {

    public Client(String id, String name, double initialMoney) {
        super(id, name, initialMoney);
    }

    @Override
    public void displayRole() {
        System.out.println("Роль: Клиент. Имя: " + name + ", ID: " + id);
    }

    public boolean payForTask(String taskTitle, double amount, Master master) {
        System.out.println("\n--- Клиент " + name + " оплачивает задачу ---");
        if (this.removeMoney(amount)) {
            master.addMoney(amount);
            System.out.println("Клиент " + name + " оплатил задачу '" + taskTitle +
                               "' мастеру " + master.getName() + " сумму " + amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Client{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", wallet=" + wallet +
               '}';
    }


    @Override
    public boolean removeMoney(double amount) {
        if (amount > 0 && wallet >= amount) {
            wallet -= amount;
            System.out.println(name + " потратил " + amount + " денег. Баланс: " + wallet);
            return true;
        } else {
            System.out.println(name + " недостаточно средств! Баланс: " + wallet + ", требуется: " + amount);
            return false;
        }
    }
}