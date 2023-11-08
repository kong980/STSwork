package com.sarah.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sarah.domain.CrawlingData;

@Mapper
public interface DataMappingInterface {
	
	@Select("select * from job")
	List<CrawlingData> selectAll();

}
