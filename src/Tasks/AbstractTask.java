package Tasks;

public abstract class AbstractTask extends Person {
    protected String priority;

    public AbstractTask(String id, String name, double initialMoney, String priority) {
        super(id, name, initialMoney);
        this.priority = priority;
    }

    public abstract void displayRole();

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "AbstractTask{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", wallet=" + wallet +
               ", priority='" + priority + '\'' +
               ", tasks=" + hmTasks.size() +
               '}';
    }
}