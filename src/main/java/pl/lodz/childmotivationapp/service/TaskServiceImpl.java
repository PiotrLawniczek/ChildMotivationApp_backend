package pl.lodz.childmotivationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.childmotivationapp.entity.Task;
import pl.lodz.childmotivationapp.repository.TaskRepository;

import java.util.List;

/**
 * Created by elawpio on 2017-12-13.
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    public Task getTask(long id){
        return taskRepository.findById(id);
    }

    public void addTask(Task task){
        taskRepository.save(task);
    }

    public void removeTask(long id){
        taskRepository.delete(taskRepository.findById(id));
    }
    public void editTask(long id){
        taskRepository.save(taskRepository.findById(id));
    }


}
