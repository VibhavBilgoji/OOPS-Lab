import java.util.*;

public class ManageTasks {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        TaskList taskList = new TaskList();

        System.out.println("===== Task Management System =====");
        System.out.print("\nEnter number of tasks to add: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; ++i) {
            System.out.println("\nTask " + (i + 1) + ":");
            System.out.print("Task ID: ");
            String id = sc.nextLine();
            System.out.print("Description: ");
            String desc = sc.nextLine();
            System.out.print("Priority (high/medium/low): ");
            String prio = sc.nextLine().toLowerCase();

            if (!prio.equals("high") && !prio.equals("medium") && !prio.equals("low")) {
                System.out.println("Invalid priority! Setting to 'low' by default.");
                prio = "low";
            }
            taskList.addTask(new Task(id, desc, prio));
        }

        System.out.println("\n--- Tasks in Original Order ---");
        taskList.printTasks();

        taskList.reverse();
        System.out.println("\n--- Tasks After Reversal ---");
        taskList.printTasks();

        taskList.sort();
        System.out.println("\n--- Tasks Sorted by Priority ---");
        taskList.printTasks();

        sc.close();
    }
}

class Task {
    private String taskId, description, priority;

    public Task() {
        taskId = description = priority = "";
    }

    public Task(String t, String d, String p) {
        taskId = t;
        description = d;
        priority = p;
    }

    public String getTaskId() { return taskId; }
    public void setTaskId(String t) { taskId = t; }
    public String getDescription() { return description; }
    public void setDescription(String d) { description = d; }
    public String getPriority() { return priority; }
    public void setPriority(String p) { priority = p; }
}

class TaskList {
    Vector<Task> tasks;
    Map<String, Integer> pMap;

    public TaskList() {
        tasks = new Vector<Task>();
        initPMap();
    }

    public TaskList(Vector<Task> t) {
        tasks = t;
        initPMap();
    }

    private void initPMap() {
        pMap = new HashMap<>();
        pMap.put("high", 3);
        pMap.put("medium", 2);
        pMap.put("low", 1);
    }

    public void reverse() {
        final int n = tasks.size();
        for (int i = 0; i < n / 2; ++i) {
            Task temp = tasks.get(i);
            tasks.set(i, tasks.get(n - 1 - i));
            tasks.set(n - 1 - i, temp);
        }
    }

    public void sort() {
        final int n = tasks.size();
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                final Task t1 = tasks.get(j);
                final Task t2 = tasks.get(j + 1);
                final int p1 = pMap.get(t1.getPriority());
                final int p2 = pMap.get(t2.getPriority());
                if (p1 < p2) {
                    tasks.set(j, t2);
                    tasks.set(j + 1, t1);
                }
            }
        }
    }

    public void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found. Please add tasks first.");
            return;
        }
        Iterator<Task> it = tasks.iterator();
        while (it.hasNext()) {
            Task t = it.next();
            System.out.println("\nTask ID: " + t.getTaskId());
            System.out.println("Description: " + t.getDescription());
            System.out.println("Priority: " + t.getPriority());
        }
    }

    public Vector<Task> getTasks() { return tasks; }
    public void setTasks(Vector<Task> t) { tasks = t; }
    public void addTask(Task t) { tasks.add(t); }
    public void removeTask(Task t) { tasks.remove(t); }
}