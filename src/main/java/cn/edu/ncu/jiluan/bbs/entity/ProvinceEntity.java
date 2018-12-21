package cn.edu.ncu.jiluan.bbs.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "province", schema = "bbs", catalog = "")
public class ProvinceEntity {
    private int provinceId;
    private String provinceName;
    private Collection<CityEntity> citiesByProvinceId;
    private Collection<UserEntity> usersByProvinceId;

    @Id
    @Column(name = "province_id", nullable = false)
    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    @Basic
    @Column(name = "province_name", nullable = false, length = 20)
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProvinceEntity that = (ProvinceEntity) o;

        if (provinceId != that.provinceId) return false;
        if (provinceName != null ? !provinceName.equals(that.provinceName) : that.provinceName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = provinceId;
        result = 31 * result + (provinceName != null ? provinceName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "provinceByProvinceId")
    @JsonManagedReference
    public Collection<CityEntity> getCitiesByProvinceId() {
        return citiesByProvinceId;
    }

    public void setCitiesByProvinceId(Collection<CityEntity> citiesByProvinceId) {
        this.citiesByProvinceId = citiesByProvinceId;
    }

    @OneToMany(mappedBy = "provinceByProvinceId")
    @JsonManagedReference
    public Collection<UserEntity> getUsersByProvinceId() {
        return usersByProvinceId;
    }

    public void setUsersByProvinceId(Collection<UserEntity> usersByProvinceId) {
        this.usersByProvinceId = usersByProvinceId;
    }
}
