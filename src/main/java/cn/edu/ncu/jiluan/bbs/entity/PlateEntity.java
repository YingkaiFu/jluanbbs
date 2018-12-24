package cn.edu.ncu.jiluan.bbs.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "plate", schema = "bbs", catalog = "")
public class PlateEntity {
    private int plateId;
    private String plateName;
    private String plateImage;
    private Collection<PostEntity> postsByPlateId;
    private Collection<UserEntity> usersByPlateId;

    @Id
    @Column(name = "plate_id", nullable = false)
    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    @Basic
    @Column(name = "plate_name", nullable = true, length = 256)
    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    @Basic
    @Column(name = "plate_image", nullable = true, length = 256)
    public String getPlateImage() {
        return plateImage;
    }

    public void setPlateImage(String plateImage) {
        this.plateImage = plateImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlateEntity that = (PlateEntity) o;

        if (plateId != that.plateId) return false;
        if (plateName != null ? !plateName.equals(that.plateName) : that.plateName != null) return false;
        if (plateImage != null ? !plateImage.equals(that.plateImage) : that.plateImage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = plateId;
        result = 31 * result + (plateName != null ? plateName.hashCode() : 0);
        result = 31 * result + (plateImage != null ? plateImage.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "plateByPlateId")
    @JsonManagedReference
    public Collection<PostEntity> getPostsByPlateId() {
        return postsByPlateId;
    }

    public void setPostsByPlateId(Collection<PostEntity> postsByPlateId) {
        this.postsByPlateId = postsByPlateId;
    }

    @OneToMany(mappedBy = "plateByPlateId")
    @JsonManagedReference
    public Collection<UserEntity> getUsersByPlateId() {
        return usersByPlateId;
    }

    public void setUsersByPlateId(Collection<UserEntity> usersByPlateId) {
        this.usersByPlateId = usersByPlateId;
    }
}
