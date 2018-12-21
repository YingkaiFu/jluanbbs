package cn.edu.ncu.jiluan.bbs.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PostLikedEntityPK implements Serializable {
    private int postId;
    private int userId;

    @Column(name = "post_id", nullable = false)
    @Id
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Column(name = "user_id", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostLikedEntityPK that = (PostLikedEntityPK) o;

        if (postId != that.postId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId;
        result = 31 * result + userId;
        return result;
    }
}
