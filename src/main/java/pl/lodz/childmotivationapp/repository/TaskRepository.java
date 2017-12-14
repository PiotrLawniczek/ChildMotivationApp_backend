package pl.lodz.childmotivationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodz.childmotivationapp.entity.Task;

/**
 * Created by elawpio on 2017-12-13.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findById(long id);
}
