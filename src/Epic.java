import java.util.HashMap;
import java.util.Objects;

public class Epic extends Task{
    private HashMap<Integer, Subtask> subtasks;

    public Epic(String title, String description) {
        super(title, description);
        this.subtasks = new HashMap<>();
    }

    public HashMap<Integer, Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(HashMap<Integer, Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public void addSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
    }

    @Override
    public String toString() {
        return super.toString() +
                " subtasks=" + subtasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Epic epic = (Epic) o;
        return Objects.equals(subtasks, epic.subtasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subtasks);
    }
}
