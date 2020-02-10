/*
 * UserAccount与UserInfo的联合操作bean类
 * 2019/7/10
 * 刘硕
 */
package nju.sofware.service.model;

import nju.sofware.data.dataobject.Useraccount;
import nju.sofware.data.dataobject.Userinfo;

public class UserAccountandInfo {
	private Integer id;
	private String username;
	private String password;
	private String name;
	private Integer phone;
	private String email;
	private Integer power;
	private String role;
	private String mode;
	private String headimage;
	/*
	 * 自定义类型转换
	 */
	public Useraccount toaccount() {
		Useraccount account=new Useraccount();
		account.setUsername(username);
		account.setPassword(password);
		account.setPower(power);
		account.setEmail(email);
		account.setPhone(phone);
		return account;
	}
	public Userinfo toinfo() {
		Userinfo info=new Userinfo();
		info.setId(id);
		info.setUsername(username);
		info.setName(name);
		info.setHeadimage(headimage);
		info.setMode(mode);
		info.setRole(role);
		return info;
	}
	@Override
	public String toString() {
		return "UserAccountandInfo [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", email=" + email + ", power=" + power + ", role=" + role + ", mode=" + mode + ", headimage="
				+ headimage + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getHeadimage() {
		return headimage;
	}
	public void setHeadimage(String headimage) {
		this.headimage = headimage;
	}
}
