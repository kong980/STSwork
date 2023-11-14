package com.sarah.domain;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
public class CrawlingData {
	private String companyName, title, condition, upToDate, siteUrl;
	
	public CrawlingData() {}

	public CrawlingData(String companyName, String title, String condition, String upToDate, String siteUrl){
		this.companyName = companyName;
		this.title = title;
		this.condition = condition;
		this.upToDate = upToDate;
		this.siteUrl = siteUrl;
	}
}