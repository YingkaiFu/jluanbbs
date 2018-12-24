package cn.edu.ncu.jiluan.bbs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
@Table(name = "reply", schema = "bbs", catalog = "")
public class ReplyEntity {
    private int replyId;
    private String replyCont;
    private Integer replyRef;
    @Column(columnDefinition="datetime default getdate()")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Timestamp replyTime;
    private Integer userId;
    private Integer postId;

    private UserEntity userByUserId;
    private PostEntity postByPostId;

    @Id
    @Column(name = "reply_id", nullable = false)
    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    @Basic
    @Column(name = "reply_cont", nullable = false, length = 256)
    public String getReplyCont() {
        return replyCont;
    }

    public void setReplyCont(String replyCont) {
        this.replyCont = replyCont;
    }

    @Basic
    @Column(name = "reply_ref", nullable = true)
    public Integer getReplyRef() {
        return replyRef;
    }

    public void setReplyRef(Integer replyRef) {
        this.replyRef = replyRef;
    }

    @Basic
    @Column(name = "reply_time", nullable = false)
    public Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReplyEntity that = (ReplyEntity) o;

        if (replyId != that.replyId) return false;
        if (replyCont != null ? !replyCont.equals(that.replyCont) : that.replyCont != null) return false;
        if (replyRef != null ? !replyRef.equals(that.replyRef) : that.replyRef != null) return false;
        if (replyTime != null ? !replyTime.equals(that.replyTime) : that.replyTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = replyId;
        result = 31 * result + (replyCont != null ? replyCont.hashCode() : 0);
        result = 31 * result + (replyRef != null ? replyRef.hashCode() : 0);
        result = 31 * result + (replyTime != null ? replyTime.hashCode() : 0);
        return result;
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

    @Column(name = "post_id")
    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id", insertable = false, updatable = false)
    @JsonBackReference
    public PostEntity getPostByPostId() {
        return postByPostId;
    }

    public void setPostByPostId(PostEntity postByPostId) {
        this.postByPostId = postByPostId;
    }
}
