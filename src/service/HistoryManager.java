package service;

import model.Task;

import java.util.LinkedList;

public interface HistoryManager<T extends Task> {
    void add(T task);
    LinkedList<T> getHistory();
}
