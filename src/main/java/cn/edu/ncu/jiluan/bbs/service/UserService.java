package cn.edu.ncu.jiluan.bbs.service;

import cn.edu.ncu.jiluan.bbs.dao.UserDao;
import cn.edu.ncu.jiluan.bbs.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by krito on 2018/12/19
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    /**
     *
     */
    public List<UserEntity> findAll(){
        return userDao.findAll();
    }
}
