package pl.lodz.childmotivationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lodz.childmotivationapp.entity.Task;
import pl.lodz.childmotivationapp.service.TaskService;

import java.util.List;

/**
 * Created by elawpio on 2017-12-13.
 */
@RestController
@RequestMapping("/api/task")
public class TaskRestController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAll();
        System.out.println(tasks);
        if(tasks.isEmpty()){
            return new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Task> getTask( @PathVariable("id") long id){
            System.out.println("get single user with id= " + id);
            Task task = taskService.getTask(id);
            if(task == null){
                return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
            }
        return new ResponseEntity<Task>(task, HttpStatus.OK);
        }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Void> createTask(@RequestBody Task task){
            System.out.println("create  " + task.getName());
    /////brak walidacji z istniejacym taskiem !
            taskService.addTask(task);

            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<Task> deleteTask(@PathVariable("id") long id){
        System.out.println("delete user with id " + id);

        Task task = taskService.getTask(id);
        if(task== null){
            System.out.println("cannot delete, user not exist");
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
        taskService.removeTask(id);
        return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
    }






}
