package org.trump.vincent.mybatis.domain;

import org.apache.ibatis.type.Alias;

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

    public SexEnum getSex() {
        return sex;
    }

    public User setSex(SexEnum sex) {
        this.sex = sex;
        return this;
    }

    private String userId;
    private String userName;
    private String password;
    private int age;
    private SexEnum sex;
}
enum  SexEnum implements Serializable{
    MALE,
    FEMALE
}
