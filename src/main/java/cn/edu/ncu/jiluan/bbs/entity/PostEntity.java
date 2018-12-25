package cn.edu.ncu.jiluan.bbs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
@Table(name = "post", schema = "bbs", catalog = "")
public class PostEntity {
    private int postId;
    private String postTopic;
    private String postCont;
    @Column(columnDefinition="datetime default getdate()")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp postTime;
    private int views;
    private int likes;
    private int replies;

    private Integer plateId;
    private Integer userId;
    @Column(columnDefinition="datetime default getdate()")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastReply;
    private PlateEntity plateByPlateId;
    private UserEntity userByUserId;
    private Collection<PostLikedEntity> postLikedsByPostId;
    private Collection<ReplyEntity> repliesByPostId;
    private Byte isPicked;
    private Byte ispost;
    private Byte isGood;

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
    @Column(name = "post_cont", nullable = false, length = 255)
    public String getPostCont() {
        return postCont;
    }

    public void setPostCont(String postCont) {
        this.postCont = postCont;
    }

    @Basic
    @Column(name = "post_time", nullable = true, insertable=false, updatable=false)
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
        return result;
    }

    @Basic

    @Column(name = "plate_id")

    public Integer getPlateId() {
        return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
    }

    @Basic

    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic

    @Column(name = "last_reply", nullable = true)
    public Timestamp getLastReply() {
        return lastReply;
    }

    public void setLastReply(Timestamp lastReply) {
        this.lastReply = lastReply;
    }

    @ManyToOne
    @JoinColumn(name = "plate_id", referencedColumnName = "plate_id", insertable = false, updatable = false)
    @JsonBackReference
    public PlateEntity getPlateByPlateId() {
        return plateByPlateId;
    }

    public void setPlateByPlateId(PlateEntity plateByPlateId) {
        this.plateByPlateId = plateByPlateId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @JsonBackReference
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "postByPostId")
    @JsonManagedReference
    public Collection<PostLikedEntity> getPostLikedsByPostId() {
        return postLikedsByPostId;
    }

    public void setPostLikedsByPostId(Collection<PostLikedEntity> postLikedsByPostId) {
        this.postLikedsByPostId = postLikedsByPostId;
    }

    @OneToMany(mappedBy = "postByPostId")
    @JsonManagedReference
    public Collection<ReplyEntity> getRepliesByPostId() {
        return repliesByPostId;
    }

    public void setRepliesByPostId(Collection<ReplyEntity> repliesByPostId) {
        this.repliesByPostId = repliesByPostId;
    }

    @Basic
    @Column(name = "is_picked", nullable = true)
    public Byte getIsPicked() {
        return isPicked;
    }

    public void setIsPicked(Byte isPicked) {
        this.isPicked = isPicked;
    }

    @Basic
    @Column(name = "ispost", nullable = true)
    public Byte getIspost() {
        return ispost;
    }

    public void setIspost(Byte ispost) {
        this.ispost = ispost;
    }

    @Basic
    @Column(name = "is_good", nullable = true)
    public Byte getIsGood() {
        return isGood;
    }

    public void setIsGood(Byte isGood) {
        this.isGood = isGood;
    }
}
