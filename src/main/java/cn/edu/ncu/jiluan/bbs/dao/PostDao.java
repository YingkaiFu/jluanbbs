package cn.edu.ncu.jiluan.bbs.dao;

import cn.edu.ncu.jiluan.bbs.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by krito on 2018/12/20
 */
public interface PostDao extends JpaRepository<PostEntity, Integer>, JpaSpecificationExecutor<PostEntity> {

    Page<PostEntity> findPostEntitiesByPlateId(Integer plateId, Pageable pageable);

    PostEntity findPostEntityByPostIdAndIspost(Integer postId,Byte isPost);

    List<PostEntity> findPostEntitiesByIspost(Byte isPost);
    @Modifying
    @Transactional
    @Query(value="UPDATE PostEntity ps SET ps.isPicked=:isPicked WHERE ps.postId= :id")
    void editPicked(@Param("isPicked")Byte isPicked,@Param("id") int post_id);

    @Modifying
    @Transactional
    @Query(value="UPDATE PostEntity ps SET ps.isGood=:isGood WHERE ps.postId= :id")
    void editGood(@Param("isGood")Byte isGood,@Param("id") int post_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE post ps SET ps.views=ps.views+1 WHERE ps.post_id= ?1 ", nativeQuery = true)
    void addView(int postId);

    List<PostEntity> findAllByPlateIdOrderByIsPickedDesc(Integer plateId);
    Page<PostEntity> findAllByPlateIdOrderByIsPickedDesc(Integer plateId, Pageable pageable);

    @Modifying
    @Transactional
    void deletePostEntityByPostId(Integer postId);

    long countPostEntityByPlateId(Integer plateId);

}
