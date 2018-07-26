package components;

import java.util.ArrayList;

public class TaskList implements Board {

    final private ArrayList<Task> tasksList = new ArrayList<>();


    public TaskList() {
    }

    public void addTask(Task task) {
        tasksList.add(task);
    }

    public void delTask(Task task) {
        tasksList.remove(task);
    }

    @Override
    public void showContent() {
        for (Task task : tasksList) {
            System.out.println(task);
        }
    }
}
