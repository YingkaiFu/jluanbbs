package cn.edu.ncu.jiluan.bbs.service;

import cn.edu.ncu.jiluan.bbs.dao.RoleRepository;
import cn.edu.ncu.jiluan.bbs.dao.UserDao;
import cn.edu.ncu.jiluan.bbs.dao.UserRepository;
import cn.edu.ncu.jiluan.bbs.entity.Role;
import cn.edu.ncu.jiluan.bbs.entity.User;
import cn.edu.ncu.jiluan.bbs.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by krito on 2018/12/19
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<UserEntity> findAll(){
        return userDao.findAll();
    }

    public User findUserByEmail(String email) {
        return userRepository.QueryUser(email);
    }


    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }
}
