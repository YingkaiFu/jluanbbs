package cn.edu.ncu.jiluan.bbs.dao;

import cn.edu.ncu.jiluan.bbs.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by krito on 2018/12/20
 */
public interface ReplyDao extends JpaRepository<ReplyEntity, Integer> {
}
