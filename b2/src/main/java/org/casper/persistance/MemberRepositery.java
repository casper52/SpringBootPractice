package org.casper.persistance;

import org.casper.domain.MemberVO;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepositery extends CrudRepository<MemberVO, String>   {

}
