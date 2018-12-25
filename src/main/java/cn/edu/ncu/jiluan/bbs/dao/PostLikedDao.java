package cn.edu.ncu.jiluan.bbs.dao;

import cn.edu.ncu.jiluan.bbs.entity.PostLikedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

/**
 * Created by krito on 2018/12/20
 */
public interface PostLikedDao extends JpaRepository<PostLikedEntity, Integer> {
    @Modifying
    @Transactional
    void deletePostLikedEntitiesByPostId(Integer postId);
}
