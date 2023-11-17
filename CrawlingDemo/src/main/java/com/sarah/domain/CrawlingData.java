package com.sarah.domain;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
public class CrawlingData {
	private String companyName, title, carrer, background, loc, upToDate, siteUrl;
	
	public CrawlingData() {}

	public CrawlingData(String companyName, String title, String carrer, String background, String loc, String upToDate, String siteUrl){
		this.companyName = companyName;
		this.title = title;
		this.carrer = carrer;
		this.background = background;
		this.loc = loc;
		this.upToDate = upToDate;
		this.siteUrl = siteUrl;
	}
}