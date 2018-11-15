package org.casper.persistance;

import org.casper.domain.BoardVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BoardRepositery extends CrudRepository<BoardVO, Long>, QuerydslPredicateExecutor<BoardVO> {
	
	@Query("select b from BoardVO b where bno > 0 order by b.bno desc")
	public Page<BoardVO> getList(Pageable pageable);
	
	//제목, 내용, 작성자 검색
	@Query("select b from BoardVO b where b.title like %:title% and bno > 0 order by b.bno desc")
	public Page<BoardVO> getListByTitle(@Param("title") String title, Pageable pageable);
	
	@Query("select b from BoardVO b where b.content like %:content% and bno > 0 order by b.bno desc")
	public Page<BoardVO> getListByContent(@Param("content") String content, Pageable pageable);
	
	@Query("select b from BoardVO b where b.writer like %:writer% and bno > 0 order by b.bno desc")
	public Page<BoardVO> getListByWriter(@Param("writer") String writer, Pageable pageable);
	
	//복합조건 검색
	
	
	
}
