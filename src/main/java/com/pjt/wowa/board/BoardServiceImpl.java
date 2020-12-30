package com.pjt.wowa.board;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pjt.wowa.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public List<BoardVO>list(Integer m_no) throws Exception {
		logger.info("list !!!!!!!");
		return dao.list(m_no);
	}
	@Override
	public int create(BoardVO vo) throws Exception {
		logger.info("insert !!!!!!!");
		return dao.create(vo);
	}
	
	@Override
	public void delete(int td_no) throws Exception {
		dao.delete(td_no);
	}
}
