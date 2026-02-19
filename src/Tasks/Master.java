package Tasks;

public class Master extends AbstractTask {
    private String department;

    public Master(String title, String priority, String department) {
        super(title, priority);
        this.department = department;
    }

    @Override
    public void displayRole() {
        System.out.println("Роль: Master. Отдел: " + department + ". Приоритет: " + priority);
    }

    @Override
    public String toString() {
        return String.format("Master Задача: %s | Приоритет: %s", title, priority);
    }
}