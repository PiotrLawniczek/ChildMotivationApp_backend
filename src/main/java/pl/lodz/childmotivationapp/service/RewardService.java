package pl.lodz.childmotivationapp.service;

import pl.lodz.childmotivationapp.entity.Reward;

import java.util.List;

/**
 * Created by elawpio on 2017-12-14.
 */

public interface RewardService {
    List<Reward> getAll();
    Reward getReward(long id);
    void addReward(Reward task);
    void removeReward(long id);
}
