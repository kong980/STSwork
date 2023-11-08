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
	
	public boolean insertData(CrawlingData data) {
		int result = dataInterface.insertData(data);
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	
//	public List<CrawlingData> insertData(CrawlingData cd){
//		List<CrawlingData> list = dataInterface.insert(cd);
//		return list;
//	}

}
