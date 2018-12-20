package cn.edu.ncu.jiluan.bbs.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "city", schema = "bbs", catalog = "")
public class CityEntity {
    private int cityId;
    private String cityName;
    private Integer provinceId;
    private ProvinceEntity provinceByProvinceId;
    private Collection<UserEntity> usersByCityId;

    @Id
    @Column(name = "city_id", nullable = false)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "city_name", nullable = false, length = 20)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (cityId != that.cityId) return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityId;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "province_id")
    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "province_id")
    public ProvinceEntity getProvinceByProvinceId() {
        return provinceByProvinceId;
    }

    public void setProvinceByProvinceId(ProvinceEntity provinceByProvinceId) {
        this.provinceByProvinceId = provinceByProvinceId;
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<UserEntity> getUsersByCityId() {
        return usersByCityId;
    }

    public void setUsersByCityId(Collection<UserEntity> usersByCityId) {
        this.usersByCityId = usersByCityId;
    }
}
