package Interfes;

import Tasks.SubTask;
import Tasks.Task;

import java.util.ArrayList;

public interface Utils {
    public void Update_Task(ArrayList<Task> taskArrayList);
    public Task Status_Task(Task task);
    public void Update_status_sub(ArrayList<SubTask> subTasks, Integer count);
    public void Sort(Task task);
    public Integer count_done_status_sub(Task task);
}
