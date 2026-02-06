package Tasks;

public class SubTask extends Base {
    private boolean isCompleted = false;

    public SubTask(String title) {
        super(title);
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        String statusMarker = isCompleted ? "[-]" : "[ ]";
        return String.format("   └── %m %-20m (SubTask)", statusMarker, title);
    }
}

