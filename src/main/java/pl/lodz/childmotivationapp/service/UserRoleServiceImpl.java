package pl.lodz.childmotivationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.childmotivationapp.entity.UserRole;
import pl.lodz.childmotivationapp.repository.UserRoleRepository;

/**
 * Created by elawpio on 2017-12-19.
 */




@Service
public class UserRoleServiceImpl implements UserRoleService{

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public void addUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);

    }
}
