/*
 * 用户信息修改操作bean类
 * 2019/7/10
 * 刘硕
 */
package nju.sofware.service.model;

public class UserAccountModel {
	private String password;
	private String phone;
	private String email;
	private String headpicpath;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHeadpicpath() {
		return headpicpath;
	}
	public void setHeadpicpath(String headpicpath) {
		this.headpicpath = headpicpath;
	}
	public UserAccountModel() {
		super();
	}
}
