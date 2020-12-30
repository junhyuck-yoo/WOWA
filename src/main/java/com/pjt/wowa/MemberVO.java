package com.pjt.wowa;

public class MemberVO {
	
	private int m_no;
	private String id;
	private String password;
	private String name;
	
	
	
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "MemberVO [m_no=" + m_no + ",id=" + id + ", password=" + password + ", name=" + name + "]";
	}
	
	
	
	
}
