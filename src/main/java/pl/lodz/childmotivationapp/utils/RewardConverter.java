package pl.lodz.childmotivationapp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.lodz.childmotivationapp.entity.Reward;
import pl.lodz.childmotivationapp.service.RewardService;


/**
 * Created by elawpio on 2017-12-14.
 */
public class RewardConverter implements Converter<String, Reward> {

    @Autowired
    private RewardService rewardService;

    @Override
    public Reward convert(String source) {
        return rewardService.getReward(Long.parseLong(source));
    }
}
