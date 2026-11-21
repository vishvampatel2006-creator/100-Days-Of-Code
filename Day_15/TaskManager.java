package Day_15;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        if (task == null || task.isBlank()) {
            System.out.println("Invalid task.");
            return;
        }
        tasks.add(task);
    }

    public boolean removeTask(String target) {
        if (target == null) return false;
        return tasks.removeIf(t -> t.equals(target));
    }

    public String getFirstTask() {
        if (tasks.isEmpty()) {
            return null;
        }
        return tasks.get(0);
    }

    public void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}