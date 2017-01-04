package org.naraberri.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.naraberri.domain.BoardVO;
import org.naraberri.persistence.BoardDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardDAOTest {

	@Inject
	private BoardDAO dao;

	@Test
	public void testCreate() throws Exception {

		BoardVO board = new BoardVO();
		board.setTitle("새로운 글을 넣습니다");
		board.setContent("새로운 글을 넣습니다");
		board.setWriter("user00");
		dao.create(board);
	}

	@Test
	public void testRead() throws Exception {
		System.out.println(dao.read(2).toString());
	}

	@Test
	public void testUpdate() throws Exception {

		BoardVO board = new BoardVO();
		board.setBno(2);
		board.setTitle("수정된 급입니다");
		board.setContent("수정 테스트");
		dao.update(board);
	}

	@Test
	public void testDelete() throws Exception {
		dao.delete(2);
	}
	
	@Test
	public void testListPage() throws Exception{
		
		int page = 3;
		
		List<BoardVO> list = dao.listPage(page);
		
		for(BoardVO boardVO : list){
			System.out.println(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}

}
