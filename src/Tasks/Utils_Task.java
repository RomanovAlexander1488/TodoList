package Tasks;

import java.util.ArrayList;
import java.util.Comparator;

public class Utils_Task extends AbUtils {

    @Override
    public void Update_Task(ArrayList<Task> taskArrayList) {
        int count = 0;
        for (Task task : taskArrayList) {
            this.Update_status_sub(task.getSubTasks(), count);
            this.Status_Task(task);
        }
    }

    @Override
    public Task Status_Task(Task task) {
        if (task == null) return null;

        var count = count_done_status_sub(task);

        if (task.getSubTasks().size() > 0) {
            task.checkAndComplete();
        }

        if (task.getSubTasks().size() == count && task.getSubTasks().size() > 0) {
            task.checkAndComplete();
        }

        return task;
    }

    @Override
    public void Update_status_sub(ArrayList<SubTask> subTasks, Integer count) {
        Integer i = 0;
        if (subTasks == null) return;

        for (SubTask subTask : subTasks) {
            if (count == 1) {
                if (i == 2) {
                    break;
                } else {

                    subTask.setCompleted(true);
                    i++;
                }
            } else {
                subTask.setCompleted(true);

            }
        }
    }

    @Override
    public void Sort(Task task) {
        Comparator<SubTask> comparator = Comparator.comparing(s -> s.isCompleted() ? Status.DONE : Status.NEW);
        if (task == null) return;
        else {
            task.getSubTasks().sort(comparator);
        }
    }

    @Override
    public Integer count_done_status_sub(Task task) {
        Integer count = 0;
        if (task == null) return 0;
        else {
            for (SubTask subTask : task.getSubTasks()) {
                if (subTask.isCompleted()) {
                    count++;
                }
            }
        }
        return count;
    }
}

