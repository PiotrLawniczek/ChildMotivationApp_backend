package pl.lodz.childmotivationapp.service;

import pl.lodz.childmotivationapp.entity.Task;

import java.util.List;

/**
 * Created by elawpio on 2017-12-13.
 */
public interface TaskService {
    List<Task> getAll();
    Task getTask(long id);
    void addTask(Task task);
    void removeTask(long id);
    void editTask(long id);


}
