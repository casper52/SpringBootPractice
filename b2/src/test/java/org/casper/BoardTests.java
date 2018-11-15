package org.casper;


import java.util.stream.IntStream;

import org.casper.domain.BoardVO;
import org.casper.domain.QBoardVO;
import org.casper.persistance.BoardRepositery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.Setter;
import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class BoardTests {

	@Setter(onMethod_=@Autowired)
	private BoardRepositery boardRepositery;
	
	@Test
	public void testDynamic() {
		String[] types= {"t","c"};
		String keyword="10";
		
		BooleanBuilder builder = new BooleanBuilder();	//where 조건문에만 해당.
		
		QBoardVO board = QBoardVO.boardVO;
		
		BooleanExpression[] arr = new BooleanExpression[types.length];
		
		for(int i = 0; i< types.length; i++) {
			
			String type = types[i];
			BooleanExpression cond = null;
			
			if(type.equals("t")) {
				cond = board.title.contains(keyword);
			
			}else if(type.equals("c")) {
				cond = board.content.contains(keyword);
			}
		
			arr[i] = cond;
		}
		
		builder.andAnyOf(arr);
		builder.and(board.bno.gt(0));
		
		Page<BoardVO> result = boardRepositery.findAll(builder, PageRequest.of(0, 10, Sort.Direction.DESC,"bno"));
		
		log.info(""+result);
	}
	
	@Test
	public void testWriter() {
		Page<BoardVO> result = boardRepositery.getListByWriter("5", PageRequest.of(0, 10));
		log.info(""+result);
		
		result.getContent().forEach(vo -> log.info(""+vo));
	}
	
	@Test
	public void testContent() {
		Page<BoardVO> result = boardRepositery.getListByContent("10", PageRequest.of(0, 10));
		log.info(""+result);
		
		result.getContent().forEach(vo -> log.info(""+vo));
	}
	
	@Test
	public void testTitle() {
		Page<BoardVO> result = boardRepositery.getListByTitle("10", PageRequest.of(0, 10));
		log.info(""+result);
		
		result.getContent().forEach(vo -> log.info(""+vo));
	}
	
	@Test
	public void testList() {
		
		Page<BoardVO> result = boardRepositery.getList(PageRequest.of(0, 10));
		log.info(""+result);
	}
	
	@Test
	public void testDelete() {
		
		boardRepositery.deleteById(10L);
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO vo = new BoardVO();
		vo.setBno(10L);
		vo.setTitle("제목 10 수정");
		vo.setContent("내용 10 수정");
		vo.setWriter("user10");
		
		boardRepositery.save(vo);
	}
	
	@Test
	public void testRead() {
		
		boardRepositery.findById(10L).ifPresent(vo -> log.info(""+vo));
	}
	
	@Test
	public void testInsert() {
		
		IntStream.range(100,1000).forEach(i -> {
			BoardVO vo = new BoardVO();
			vo.setTitle("초키포키"+i);
			vo.setContent("밀크티"+i);
			vo.setWriter("casper"+ (i%10));
			
			boardRepositery.save(vo);
		});
	}
}
