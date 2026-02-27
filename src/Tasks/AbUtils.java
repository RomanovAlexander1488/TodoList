package Tasks;

import Interfes.Utils;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class  AbUtils implements Utils {
    public abstract void Update_Task(ArrayList<Task> taskArrayList);

    public abstract Task Status_Task(Task task);

    public abstract void Update_status_sub(ArrayList<SubTask> subTasks, Integer count);

    public abstract void Sort(Task task);

    public abstract Integer count_done_status_sub(Task task);
}