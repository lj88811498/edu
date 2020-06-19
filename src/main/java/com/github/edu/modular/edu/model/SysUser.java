package com.github.edu.modular.edu.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Monkey
 * @since 2020-05-28
 */
@ApiModel
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    private String password;
    /**
     * 随机盐
     */
    private String salt;
    /**
     * 简介
     */
    private String phone;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 部门ID
     */
    private Integer deptId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 0-正常，1-删除
     */
    private String delFlag;
    /**
     * 工号
     */
    private String employeeNumber;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 身份证
     */
    private String certNo;
    /**
     * 入职时间
     */
    private Date employmentDate;
    /**
     * 离职时间
     */
    private Date leaveDate;
    /**
     * 在职状态:0-在职,1-已离职
     */
    private Integer employmentState;
    /**
     * 密码是否符合规则:0-符合,1-不符合
     */
    private Integer passMatch;
    /**
     * 密码过期时间
     */
    private Date passExpiredDate;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Integer getEmploymentState() {
        return employmentState;
    }

    public void setEmploymentState(Integer employmentState) {
        this.employmentState = employmentState;
    }

    public Integer getPassMatch() {
        return passMatch;
    }

    public void setPassMatch(Integer passMatch) {
        this.passMatch = passMatch;
    }

    public Date getPassExpiredDate() {
        return passExpiredDate;
    }

    public void setPassExpiredDate(Date passExpiredDate) {
        this.passExpiredDate = passExpiredDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        "userId=" + userId +
        ", username=" + username +
        ", password=" + password +
        ", salt=" + salt +
        ", phone=" + phone +
        ", avatar=" + avatar +
        ", deptId=" + deptId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", delFlag=" + delFlag +
        ", employeeNumber=" + employeeNumber +
        ", realName=" + realName +
        ", certNo=" + certNo +
        ", employmentDate=" + employmentDate +
        ", leaveDate=" + leaveDate +
        ", employmentState=" + employmentState +
        ", passMatch=" + passMatch +
        ", passExpiredDate=" + passExpiredDate +
        "}";
    }
}
