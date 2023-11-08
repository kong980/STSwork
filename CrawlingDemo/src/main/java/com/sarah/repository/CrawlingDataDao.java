package com.sarah.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sarah.domain.CrawlingData;

@Repository
public class CrawlingDataDao {
	@Autowired
	private DataMappingInterface dataInterface;
	
	public List<CrawlingData> getDataAll(){
		List<CrawlingData> list = dataInterface.selectAll();
		return list;
	}
}
