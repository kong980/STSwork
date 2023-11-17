package com.sarah.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.sarah.domain.CrawlingData;

@Mapper
public interface DataMappingInterface {
	
	@Select("select * from job")
	List<CrawlingData> selectAll();
	
	@Insert("insert into job(companyName, title, carrer, background, loc, upToDate, siteUrl) values(#{companyName, jdbcType=VARCHAR}, #{title, jdbcType=VARCHAR}, #{carrer, jdbcType=VARCHAR}, #{background, jdbcType=VARCHAR}, #{loc, jdbcType=VARCHAR}, #{upToDate, jdbcType=VARCHAR}, #{siteUrl, jdbcType=VARCHAR})")
	int insertData(CrawlingData data);
	
//	@Insert("insert into job(companyName, title) values(#{companyName}, #{title}, #{condition}, #{upToDate}, #{siteUrl})")
//	int insertData();

}
