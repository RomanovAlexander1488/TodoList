package Tasks;

public class Master extends Person {
    public Master(String id, String name) {
        super(id, name);
    }

    @Override
    public void doWork() {
        System.out.println("Мастер " + name + " выполняет задачу");
    }

    public void completeTask(String taskName, double payment) {
        System.out.println("Мастер сделал: " + taskName);
        addMoney(payment);
        hmTasks.remove(taskName);
    }
}

//public class Master extends AbstractTask {
//    private String department;
//
//    public Master(String title, String priority, String department) {
//        super(title, priority);
//        this.department = department;
//    }
//
//    @Override
//    public void displayRole() {
//        System.out.println("Роль: Master. Отдел: " + department + ". Приоритет: " + priority);
//    }
//
//    @Override
//    public String toString() {
//        return String.format("Master Задача: %s | Приоритет: %s", title, priority);
//    }
//}