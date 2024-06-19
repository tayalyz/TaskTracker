import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskManager {
    private static final AtomicInteger taskId = new AtomicInteger(0);

    private Task task;
    private Epic epic;

    private HashMap<Integer, Task> tasks;
    private HashMap<Integer, Epic> epics;

    public TaskManager() {
        this.tasks = new HashMap<>();
        this.epics = new HashMap<>();
    }

    public void getAllTasks() {
        if (!tasks.isEmpty()) {
            System.out.println(tasks);
        } else {
            System.out.println("No tasks found");
        }
    }

    public void getAllEpics() {
        if (!tasks.isEmpty()) {
            System.out.println(epics);
        } else {
            System.out.println("No epics found");
        }
    }

    public void setTasks(HashMap<Integer, Task> tasks) {
        this.tasks = tasks;
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    public void deleteAllTasks() {
        tasks.clear();
        epics.clear();;
    }

    public void createTask(Task task) {
        task.setStatus(Status.NEW);
        task.setId(taskId.incrementAndGet());
        tasks.put(task.getId(), task);
    }

    public void createEpic(Epic epic) {
        epic.setStatus(Status.NEW);
        epic.setId(taskId.incrementAndGet());
        tasks.put(epic.getId(), epic);
        epics.put(epic.getId(), epic);
    }

    public void createSubtask(Subtask subtask, Epic epic) {
        subtask.setStatus(Status.NEW);
        subtask.setId(taskId.incrementAndGet());
        epic.addSubtask(subtask);
    }

//    public void updateTask(Task task) { //TODO
//    }
//
//    public void updateSubtask(Subtask subtask, Epic epic) {
//        if (subtask.getStatus() == Status.IN_PROGRESS) {
//            epic.setStatus(Status.IN_PROGRESS);
//        }
//    }
}
