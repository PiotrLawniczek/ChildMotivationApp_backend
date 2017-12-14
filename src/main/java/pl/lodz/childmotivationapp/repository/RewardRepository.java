package pl.lodz.childmotivationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodz.childmotivationapp.entity.Reward;

/**
 * Created by elawpio on 2017-12-13.
 */
public interface RewardRepository  extends JpaRepository<Reward, Long> {
    Reward findById(long id);

}
