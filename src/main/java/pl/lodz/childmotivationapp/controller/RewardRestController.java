package pl.lodz.childmotivationapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lodz.childmotivationapp.entity.Reward;
import pl.lodz.childmotivationapp.service.RewardService;

import java.util.List;

/**
 * Created by elawpio on 2017-12-14.
 */
@RestController
@RequestMapping("/api/reward")
public class RewardRestController {

    public static final Logger log = LoggerFactory.getLogger(TaskRestController.class);

    @Autowired
    private RewardService rewardService;


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reward>> getAllRewards(){
        List<Reward> rewards = rewardService.getAll();
        System.out.println(rewards);
        if(rewards.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rewards, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reward> getReward( @PathVariable("id") long id){
        log.debug("get single user with id= " + id);
        Reward reward = rewardService.getReward(id);
        if(reward == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reward, HttpStatus.OK);
    }
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createReward(@RequestBody Reward reward){
        System.out.println("create  " + reward.getName());
        /////brak walidacji z istniejacym taskiem !
        rewardService.addReward(reward);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Reward> deleteReward(@PathVariable("id") long id){
        System.out.println("delete user with id " + id);

        Reward reward = rewardService.getReward(id);
        if(reward== null){
            System.out.println("cannot delete, user not exist");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        rewardService.removeReward(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
