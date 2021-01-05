package com.lrm.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.lrm.po.Question;

@Entity
@Table(name = "t_user")
public class User
{
    @Id
    @GeneratedValue
    private Long id;
    private Boolean admin;
    private String nickname;
    private String username;
    private String password;
    private String avatar;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @OneToMany(mappedBy = "user")
    private List<Question> questions = new ArrayList<>();


}

