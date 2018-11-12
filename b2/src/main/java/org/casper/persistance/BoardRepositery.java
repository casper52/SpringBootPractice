package org.casper.persistance;

import java.util.List;

import org.casper.domain.BoardVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepositery extends CrudRepository<BoardVO, Long> {
	
	@Query("select b from BoardVO b where b.bno > 0")
	public Page<BoardVO> getList(Pageable pageable);

	public Page<BoardVO> findByBnoGreaterThan(Long bno, Pageable pageable);
	
	//public List<BoardVO> findByBnoGreaterThan(Long bno, Pageable pageable);
	
	public List<BoardVO> findByTitleContainingAndBnoGreaterThan(String keyword, Long bno, Pageable pageable);
	
	
}
