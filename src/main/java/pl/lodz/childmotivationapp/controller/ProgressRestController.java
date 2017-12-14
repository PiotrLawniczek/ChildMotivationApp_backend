package pl.lodz.childmotivationapp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lodz.childmotivationapp.entity.Progress;
import pl.lodz.childmotivationapp.service.ProgressService;

import java.util.List;

/**
 * Created by elawpio on 2017-12-14.
 */
@RestController
@RequestMapping("api/progress")
public class ProgressRestController {

    public static final Logger log = LoggerFactory.getLogger(TaskRestController.class);

    @Autowired
    private ProgressService progressService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Progress>> getAllProgresses(){
        List<Progress> progresses = progressService.getAll();
        System.out.println(progresses);
        if(progresses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(progresses, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Progress> getProgresses( @PathVariable("id") long id){
        log.debug("get single user with id= " + id);
        Progress progresses = progressService.getProgress(id);
        if(progresses == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(progresses, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProgress(@RequestBody Progress progress){
        System.out.println("create  " + progress.getValue());

        /////brak walidacji z istniejacym progreseem !
        progressService.addProgress(progress);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Progress> deleteProgress(@PathVariable("id") long id){
        System.out.println("delete progress with id " + id);

        Progress progress = progressService.getProgress(id);
        if(progress== null){
            System.out.println("cannot delete, user not exist");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        progressService.removeProgress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
