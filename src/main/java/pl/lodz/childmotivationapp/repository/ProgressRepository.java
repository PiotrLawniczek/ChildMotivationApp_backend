package pl.lodz.childmotivationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.childmotivationapp.entity.Progress;

/**
 * Created by elawpio on 2017-12-13.
 */
@Transactional
@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    Progress findById(long id);

}
