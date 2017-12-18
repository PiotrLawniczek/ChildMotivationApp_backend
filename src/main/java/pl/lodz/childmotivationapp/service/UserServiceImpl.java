package pl.lodz.childmotivationapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.lodz.childmotivationapp.entity.User;
import pl.lodz.childmotivationapp.entity.UserRole;
import pl.lodz.childmotivationapp.repository.UserRepository;
import pl.lodz.childmotivationapp.repository.UserRoleRepository;

import java.util.List;

/**
 * Created by elawpio on 2017-12-18.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public void addUser(User user) {
        user.getUserRoles().add(userRoleRepository.findByName("ROLE_USER"));   ///statyczne dodawanie zwyklego usera
        user.setPassword(hashPassword(user.getPassword()));
        userRepository.save(user);

    }

    @Override
    public void editUser(User user) {
/*        if(user.getId() > 0) {
            user.setPassword(hashPassword(user.getPassword()));
            userRepository.save(user);
        }*/
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public void removeUser(int id) {
        userRepository.delete(userRepository.findById(id));

    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id);
    }

    @Override
    public String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    @Override
    public void addUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);

    }

    @Override
    public List<UserRole> listUserRole() {

        return userRoleRepository.findAll();
    }

    @Override
    public void removeUserRole(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public UserRole getUserRole(int id) {
        // TODO Auto-generated method stub
        return null;
    }
}
