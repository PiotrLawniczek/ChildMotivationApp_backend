package pl.lodz.childmotivationapp.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.lodz.childmotivationapp.entity.User;
import pl.lodz.childmotivationapp.entity.UserRole;

import java.util.List;

/**
 * Created by elawpio on 2017-12-18.
 */
public interface UserService {

    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    void addUser(User user);

    @Secured("ROLE_ADMIN")
    void editUser(User user);

    List<User> listUser();

    @Secured("ROLE_ADMIN")
    void removeUser (int id);

    User getUser(int id);

    String hashPassword(String password);

    void addUserRole(UserRole userRole);
    List<UserRole> listUserRole();
    void removeUserRole (int id);
    UserRole getUserRole(int id);

}