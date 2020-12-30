package com.pjt.wowa.board;

import java.util.List;

import com.pjt.wowa.BoardVO;

public interface BoardService {
	
	public List<BoardVO>list(Integer m_no) throws Exception;
	
	public int create(BoardVO vo) throws Exception;
	
	public void delete(int td_no) throws Exception; 

}
