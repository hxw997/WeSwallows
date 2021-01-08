package com.lrm.po;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_user")
public class User
{
    @Id
    @GeneratedValue
    private Long id;     //每个类都要有一个id主键
    //用户个人属性
    private Boolean admin;     //是否为管理员
      //必填部分
        //@NotBlank需要搭配有@Valid的controller方法使用 且只能用在String上
    @NotBlank(message = "请输入昵称")
    private String nickname;
    @NotBlank(message = "请输入账号")
    private String username;
    @NotBlank(message = "请输入密码")
    private String password;
      //非必填 可以在前端显示默认值
    private String avatar;
    private String email;
    private String QQid;
    private Integer donation;
      //自动生成时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerTime;

    //关联关系 Merge Refresh Remove Persist
        //mappedBy="name" name为外键所在的表中关联的字段的名字
        //没必要设置Remove 因为不打算做注销账号功能
    @OneToMany(mappedBy = "user")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "user")

    private List<Comment> comment = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQQid() {
        return QQid;
    }

    public void setQQid(String QQid) {
        this.QQid = QQid;
    }

    public Integer getDonation() {
        return donation;
    }

    public void setDonation(Integer donation) {
        this.donation = donation;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", admin=" + admin +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", QQid='" + QQid + '\'' +
                ", donation=" + donation +
                ", registerTime=" + registerTime +
                ", questions=" + questions +
                ", comment=" + comment +
                '}';
    }
}

