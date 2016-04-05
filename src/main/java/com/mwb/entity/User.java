package com.mwb.entity;

import java.util.Date;

/**
 * 用户bean
 */
public class User {
	private Integer id;
	private String name;
	private String password;
	private String realname;
	//真是姓名
	private String sex;
	private String tel;
	private String email;
	private String address;
	private int zipcode;
	//邮编
	private Date joindate;
	//注册时间
	private Date lastdate;
	//最后登录时间
	private int members;
	//是否是会员
	public User() {
	}

	public User(Integer id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public User(Integer id, String name, String password, String realname, String sex, String tel, String email, String address, int zipcode, Date joindate, Date lastdate, int members) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.tel = tel;
		this.email = email;
		this.address = address;
		this.zipcode = zipcode;
		this.joindate = joindate;
		this.lastdate = lastdate;
		this.members = members;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", realname='" + realname + '\'' +
				", sex='" + sex + '\'' +
				", tel='" + tel + '\'' +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				", zipcode=" + zipcode +
				", joindate=" + joindate +
				", lastdate=" + lastdate +
				", members=" + members +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public Date getLastdate() {
		return lastdate;
	}

	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}
}
