package com.pjt.wowa.member;

import com.pjt.wowa.MemberVO;

public interface MemberDAO {
	
	public MemberVO login(MemberVO vo) throws Exception;
}
