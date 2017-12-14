package pl.lodz.childmotivationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.childmotivationapp.entity.Reward;
import pl.lodz.childmotivationapp.repository.RewardRepository;

import java.util.List;

/**
 * Created by elawpio on 2017-12-14.
 */
@Service
public class RewardServiceImpl implements RewardService{

    @Autowired
    private RewardRepository rewardRepository;

    public List<Reward> getAll(){
        return rewardRepository.findAll();
    }

    public Reward getReward(long id){
        return rewardRepository.findById(id);
    }

    public void addReward(Reward task){
        rewardRepository.save(task);
    }

    public void removeReward(long id){
        rewardRepository.delete(rewardRepository.findById(id));
    }

}
