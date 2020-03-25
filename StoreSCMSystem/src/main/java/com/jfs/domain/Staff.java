package com.jfs.domain;

import java.util.Date;

public class Staff {
    private String staffId;

    private Integer userId;

    private String realName;

    private Integer sex;

    private Integer age;

    private String qq;

    private String wechat;

    private String telephone;

    private String email;

    private String nativePalce;

    private String place;

    private Integer departmentId;

    private String pic;

    private Date workdate;

    private Date createtime;

    private Date updatetime;

    private Role role;

    public Staff() {

    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getNativePalce() {
        return nativePalce;
    }

    public void setNativePalce(String nativePalce) {
        this.nativePalce = nativePalce == null ? null : nativePalce.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getWorkdate() {
        return workdate;
    }

    public void setWorkdate(Date workdate) {
        this.workdate = workdate;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId='" + staffId + '\'' +
                ", userId=" + userId +
                ", realName='" + realName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", nativePalce='" + nativePalce + '\'' +
                ", place='" + place + '\'' +
                ", departmentId=" + departmentId +
                ", pic='" + pic + '\'' +
                ", workdate=" + workdate +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", role=" + role +
                '}';
    }
}