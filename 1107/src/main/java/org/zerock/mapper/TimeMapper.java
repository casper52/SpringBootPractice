package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("select now()")
	public String getTime();
	
	@Insert("insert into tbl_t1(col) values(#{str})")
	public int insert1(String str);
	
	@Insert("insert into tbl_t2(col) values(#{str})")
	public int insert2(String str);
}
