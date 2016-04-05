package com.mwb.entity;

/**
 * Created by Administrator on 2016/4/5 0005.
 * 管理员
 */
public class admin {
    private  int id;
    private  String name;
    private  String  email;
    private  String  password;
    private  int grad;
    //级别
    public admin() {
    }

    public admin(int id, String email, int grad, String name, String password) {
        this.id = id;
        this.email = email;
        this.grad = grad;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", grad=" + grad +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }
}
