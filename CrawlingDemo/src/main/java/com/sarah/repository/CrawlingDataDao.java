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
	
	public int insertData(String companyName, String title, String carrer, String background, String loc, String upToDate, String siteUrl, CrawlingData data) {
		data.getCompanyName();
		data.getTitle();
		data.getCarrer();
		data.getBackground();
		data.getLoc();
		data.getUpToDate();
		data.getSiteUrl();
		int result = dataInterface.insertData(data);
		return result;
	}
	
//	public List<CrawlingData> insertData(CrawlingData cd){
//		List<CrawlingData> list = dataInterface.insert(cd);
//		return list;
//	}

}
