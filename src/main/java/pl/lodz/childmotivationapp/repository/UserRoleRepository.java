package pl.lodz.childmotivationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodz.childmotivationapp.entity.UserRole;

/**
 * Created by elawpio on 2017-12-13.
 */
public interface UserRoleRepository  extends JpaRepository<UserRole, Long> {
    UserRole findById(long id);
    UserRole findByName(String name);
}
