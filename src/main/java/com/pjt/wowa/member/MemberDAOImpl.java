package com.pjt.wowa.member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.wowa.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.pjt.wowa.mappers.memberMapper";
	
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return sql.selectOne(namespace + ".login", vo);
	}
}
