import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Task task1 = new Task("111", "111");
        Task task2 = new Task("222", "222");

        Epic epic = new Epic("333", "333");

        Subtask subtask1 = new Subtask("1sub", "1sub");
        Subtask subtask2 = new Subtask("2sub", "2sub");

        create(manager, task1, task2, epic, subtask1, subtask2);
        System.out.println(manager.getTaskById(3));
        manager.getAllTasks();
        manager.getAllEpics();

        subtask1.setStatus(Status.IN_PROGRESS);
//        manager.updateSubtask(subtask1, epic);
//        manager.updateTask(task1);
        manager.getAllTasks();

        delete(manager);
        manager.getAllTasks();
    }

    private static void delete(TaskManager manager) {
        manager.deleteAllTasks();
        manager.deleteTaskById(1);
    }

    private static void create(TaskManager manager, Task task1, Task task2, Epic epic, Subtask subtask1, Subtask subtask2) {
        manager.createTask(task1);
        manager.createTask(task2);
        manager.createEpic(epic);
        manager.createSubtask(subtask1, epic);
        manager.createSubtask(subtask2, epic);
    }
}