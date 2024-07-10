package service;

import model.Task;

import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

public class InMemoryHistoryManager<T extends Task> implements HistoryManager<T> {
    private LinkedList<T> history;

    public InMemoryHistoryManager() {
        this.history = new LinkedList<>();
    }

    @Override
    public void add(T task) {
        if(Objects.nonNull(task)) {
            if (history.size() > 9) {
                history.removeFirst();
            }
            history.add(task);
        }
    }

    @Override
    public LinkedList<T> getHistory() {
        return history.stream().limit(10).collect(Collectors.toCollection(LinkedList::new));
    }
}
