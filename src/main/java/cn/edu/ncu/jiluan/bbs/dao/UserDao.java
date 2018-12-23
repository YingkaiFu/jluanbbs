package cn.edu.ncu.jiluan.bbs.dao;

import cn.edu.ncu.jiluan.bbs.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by krito on 2018/12/19
 */
@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
    UserEntity findUserEntityByUserName(String username);
}
