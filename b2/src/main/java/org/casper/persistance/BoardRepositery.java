package org.casper.persistance;

import java.util.List;

import org.casper.domain.BoardVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepositery extends CrudRepository<BoardVO, Long> {

	public Page<BoardVO> findByBnoGreaterThan(Long bno, Pageable pageable);
	
	//public List<BoardVO> findByBnoGreaterThan(Long bno, Pageable pageable);
	
	public List<BoardVO> findByTitleContainingAndBnoGreaterThan(String keyword, Long bno, Pageable pageable);
	
}
