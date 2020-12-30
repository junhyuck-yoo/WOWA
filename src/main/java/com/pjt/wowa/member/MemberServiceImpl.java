package com.pjt.wowa.member;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pjt.wowa.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO dao;
	
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return dao.login(vo);
	}
}
