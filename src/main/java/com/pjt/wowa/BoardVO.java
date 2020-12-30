package com.pjt.wowa;

public class BoardVO {
	
	private int td_no;
	private int m_no;
	private String td_text;
	
	
	public int getTd_no() {
		return td_no;
	}
	public void setTd_no(int td_no) {
		this.td_no = td_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getTd_text() {
		return td_text;
	}
	public void setTd_text(String td_text) {
		this.td_text = td_text;
	}
	
	@Override
	public String toString() {
		return "boardVO [td_no=" + td_no + ", m_no=" + m_no + ", td_text=" + td_text + "]";
	}
	
	
	
	

}
