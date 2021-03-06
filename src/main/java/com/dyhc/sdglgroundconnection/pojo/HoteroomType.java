package com.dyhc.sdglgroundconnection.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度酒店房间类型表
 **/
@Table(name = "hoteroomtype")
public class HoteroomType {
    @Id
    @Column(name = "hoteroomtId")
    private int hoteroomtId; // 调度酒店房间类型id
    @Column(name = "offerId")
    private Integer offerId; // 调度酒店编号（外键，与调度酒店表关联）
    @Column(name = "templateId")
    private Integer templateId; // 酒店房间类型编号（外键，与酒店房间类型表关联）
    private Integer status; // 是否删除（1代表已删除，0代表未删除）
    @Column(name = "createBy")
    private Integer createBy; // 创建人 （外键，与人员表关联）
    @Column(name = "updateBy")
    private Integer updateBy; // 修改人（外键，与人员表关联）
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "updateDate")
    private Date updateDate; // 修改日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "createDate")
    private Date createDate; // 创建时间
    private int weight;  //权重
    @JsonFormat(pattern = "yyyy-MM-dd",timezone ="GMT+8")
    @Column(name = "date")
    private Date date;
    @Column(name = "temName")
    private String temName;
    @Column(name = "xingcheng")
    private String xingcheng;

    public String getXingcheng() {
        return xingcheng;
    }

    public void setXingcheng(String xingcheng) {
        this.xingcheng = xingcheng;
    }

    @Transient
    private String riqi;

    @Transient
    private String templateName;
    @Transient
    private String templateContent;

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    @Id
    @Column(name = "hoteroomtId")
    public int getHoteroomtId() {
        return hoteroomtId;
    }

    public void setHoteroomtId(int hoteroomtId) {
        this.hoteroomtId = hoteroomtId;
    }

    @Basic
    @Column(name = "templateId")
    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    @Basic
    @Column(name = "offerId")
    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "createBy")
    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "updateBy")
    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @Column(name = "updateDate")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date upDate) {
        this.updateDate = upDate;
    }

    @Basic
    @Column(name = "createDate")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "temName")
    public String getTemName() {
        return temName;
    }

    public void setTemName(String value3) {
        this.temName = value3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoteroomType that = (HoteroomType) o;
        return hoteroomtId == that.hoteroomtId &&
                Objects.equals(offerId, that.offerId) &&
                Objects.equals(templateId, that.templateId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(updateBy, that.updateBy) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(date, that.date) &&
                Objects.equals(temName, that.temName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hoteroomtId, offerId, templateId, status, createBy, updateBy, updateDate, createDate, weight, date, temName);
    }
}
