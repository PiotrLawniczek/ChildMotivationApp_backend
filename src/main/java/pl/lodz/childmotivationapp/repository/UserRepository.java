package pl.lodz.childmotivationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.childmotivationapp.entity.User;

/**
 * Created by elawpio on 2017-12-11.
 */
@Transactional
@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    User findById(long id);
    User findByLogin(String login);

}
