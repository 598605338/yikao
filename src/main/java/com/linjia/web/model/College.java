package com.linjia.web.model;

public class College {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.college_name
     *
     * @mbggenerated
     */
    private String collegeName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.province_id
     *
     * @mbggenerated
     */
    private Short provinceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.province_name
     *
     * @mbggenerated
     */
    private String provinceName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.city_id
     *
     * @mbggenerated
     */
    private Short cityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.city_name
     *
     * @mbggenerated
     */
    private String cityName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.county_id
     *
     * @mbggenerated
     */
    private Short countyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.county_name
     *
     * @mbggenerated
     */
    private String countyName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.mobile
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.phone
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.contain_specialty_ids
     *
     * @mbggenerated
     */
    private String containSpecialtyIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_college.deleted
     *
     * @mbggenerated
     */
    private Boolean deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.id
     *
     * @return the value of t_college.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.id
     *
     * @param id the value for t_college.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.college_name
     *
     * @return the value of t_college.college_name
     *
     * @mbggenerated
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.college_name
     *
     * @param collegeName the value for t_college.college_name
     *
     * @mbggenerated
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.province_id
     *
     * @return the value of t_college.province_id
     *
     * @mbggenerated
     */
    public Short getProvinceId() {
        return provinceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.province_id
     *
     * @param provinceId the value for t_college.province_id
     *
     * @mbggenerated
     */
    public void setProvinceId(Short provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.province_name
     *
     * @return the value of t_college.province_name
     *
     * @mbggenerated
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.province_name
     *
     * @param provinceName the value for t_college.province_name
     *
     * @mbggenerated
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.city_id
     *
     * @return the value of t_college.city_id
     *
     * @mbggenerated
     */
    public Short getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.city_id
     *
     * @param cityId the value for t_college.city_id
     *
     * @mbggenerated
     */
    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.city_name
     *
     * @return the value of t_college.city_name
     *
     * @mbggenerated
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.city_name
     *
     * @param cityName the value for t_college.city_name
     *
     * @mbggenerated
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.county_id
     *
     * @return the value of t_college.county_id
     *
     * @mbggenerated
     */
    public Short getCountyId() {
        return countyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.county_id
     *
     * @param countyId the value for t_college.county_id
     *
     * @mbggenerated
     */
    public void setCountyId(Short countyId) {
        this.countyId = countyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.county_name
     *
     * @return the value of t_college.county_name
     *
     * @mbggenerated
     */
    public String getCountyName() {
        return countyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.county_name
     *
     * @param countyName the value for t_college.county_name
     *
     * @mbggenerated
     */
    public void setCountyName(String countyName) {
        this.countyName = countyName == null ? null : countyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.address
     *
     * @return the value of t_college.address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.address
     *
     * @param address the value for t_college.address
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.mobile
     *
     * @return the value of t_college.mobile
     *
     * @mbggenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.mobile
     *
     * @param mobile the value for t_college.mobile
     *
     * @mbggenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.phone
     *
     * @return the value of t_college.phone
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.phone
     *
     * @param phone the value for t_college.phone
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.contain_specialty_ids
     *
     * @return the value of t_college.contain_specialty_ids
     *
     * @mbggenerated
     */
    public String getContainSpecialtyIds() {
        return containSpecialtyIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.contain_specialty_ids
     *
     * @param containSpecialtyIds the value for t_college.contain_specialty_ids
     *
     * @mbggenerated
     */
    public void setContainSpecialtyIds(String containSpecialtyIds) {
        this.containSpecialtyIds = containSpecialtyIds == null ? null : containSpecialtyIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_college.deleted
     *
     * @return the value of t_college.deleted
     *
     * @mbggenerated
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_college.deleted
     *
     * @param deleted the value for t_college.deleted
     *
     * @mbggenerated
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}