package com.sarah.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sarah.domain.Member;

@Mapper
public interface DataMappingInterface {
	@Select("select * from mem") // 어노테이션으로 작성한 쿼리문의 결과를 List<Member>에 집어넣겠다.
	List<Member> selectAll(); // mapper가 따로 있다면 selectAll에 대한 실제 sql을 작성하면 됨
	
	@Insert("insert into mem(num, name, addr) values(#{num}, #{name}, #{addr})")
	int insertData(Member mem);
	
	@Select("select * from mem where num=#{num}")
	Member selectOne(String num);
	
	@Update("update mem set name=#{name}, addr=#{addr} where num=#{num}")
	int updateData(Member mem);
	
	@Delete("delete from mem where num=#{num}")
	int deleteData(String num);
}
