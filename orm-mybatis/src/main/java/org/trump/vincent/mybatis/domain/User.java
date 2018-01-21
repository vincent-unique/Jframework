package org.trump.vincent.mybatis.domain;

import org.apache.ibatis.type.Alias;
import org.trump.vincent.mybatis.enumeration.GenderEnum;

import java.io.Serializable;

@Alias("user")
public class User implements Serializable{
    private static final long serialVersionUID = 100432L;

    public String getUserId() {
        return userId;
    }

    public User setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public User setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    private String userId;
    private String userName;
    private String password;
    private int age;
    private GenderEnum gender;
}

