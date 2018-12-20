package cn.edu.ncu.jiluan.bbs.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "post", schema = "bbs", catalog = "")
public class PostEntity {
    private int postId;
    private String postTopic;
    private String postCont;
    private Timestamp postTime;
    private int views;
    private int likes;
    private int replies;
    private Timestamp lastreply;
    private Integer plateId;
    private Integer userId;

    @Id
    @Column(name = "post_id", nullable = false)
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "post_topic", nullable = false, length = 1024)
    public String getPostTopic() {
        return postTopic;
    }

    public void setPostTopic(String postTopic) {
        this.postTopic = postTopic;
    }

    @Basic
    @Column(name = "post_cont", nullable = true, length = 255)
    public String getPostCont() {
        return postCont;
    }

    public void setPostCont(String postCont) {
        this.postCont = postCont;
    }

    @Basic
    @Column(name = "post_time", nullable = false)
    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    @Basic
    @Column(name = "views", nullable = false)
    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Basic
    @Column(name = "likes", nullable = false)
    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Basic
    @Column(name = "replies", nullable = false)
    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    @Basic
    @Column(name = "lastreply", nullable = false)
    public Timestamp getLastreply() {
        return lastreply;
    }

    public void setLastreply(Timestamp lastreply) {
        this.lastreply = lastreply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostEntity that = (PostEntity) o;

        if (postId != that.postId) return false;
        if (views != that.views) return false;
        if (likes != that.likes) return false;
        if (replies != that.replies) return false;
        if (postTopic != null ? !postTopic.equals(that.postTopic) : that.postTopic != null) return false;
        if (postCont != null ? !postCont.equals(that.postCont) : that.postCont != null) return false;
        if (postTime != null ? !postTime.equals(that.postTime) : that.postTime != null) return false;
        if (lastreply != null ? !lastreply.equals(that.lastreply) : that.lastreply != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId;
        result = 31 * result + (postTopic != null ? postTopic.hashCode() : 0);
        result = 31 * result + (postCont != null ? postCont.hashCode() : 0);
        result = 31 * result + (postTime != null ? postTime.hashCode() : 0);
        result = 31 * result + views;
        result = 31 * result + likes;
        result = 31 * result + replies;
        result = 31 * result + (lastreply != null ? lastreply.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "plate_id", nullable = true)
    public Integer getPlateId() {
        return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
