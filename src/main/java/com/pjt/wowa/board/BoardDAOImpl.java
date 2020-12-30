package com.pjt.wowa.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pjt.wowa.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.pjt.wowa.mappers.boardMapper";
	
	@Override
	public List<BoardVO>list(Integer m_no) throws Exception {
		logger.info("list DAO!");
		//return sql.selectList("reply.list", m_no);
		return sql.selectList(namespace + ".list", m_no);
	}
	@Override
	public int create(BoardVO vo) throws Exception {
		logger.info("insert DAO!");
		//sql.insert("reply.insert", vo);
		return sql.insert(namespace + ".insert", vo);
	}
	@Override
	public void delete(int td_no) throws Exception {
		logger.info("delete DAO!");
		sql.delete(namespace + ".delete", td_no);
	}
	
}
