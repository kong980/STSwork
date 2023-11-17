package com.sarah.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarah.domain.CrawlingData;
import com.sarah.repository.CrawlingDataDao;

@Service
public class CrawlingService {
	@Autowired
	private CrawlingDataDao dao;
	@Autowired
	private CrawlingData dt;
	
	public int getData() {
		for (int i = 1; i < 2; i++) {
			// 인크루트 주소 가져오기
			String url = "https://job.incruit.com/jobdb_list/searchjob.asp?rgn2=14&rgn2=18&rgn2=11&occ1=150&page=" + i;

			try {
				Document doc = Jsoup.connect(url).get(); // 주소에 있는 html 파일 가져다 넣기
				Elements goSiteUrlElements = doc.getElementsByClass("c_col "); // 채용공고 세부 페이지 url

				Elements companyElements = doc.getElementsByClass("cell_first"); // 기업명 div
				Elements titleElements = doc.getElementsByClass("cell_mid"); // 공고 제목, 조건 div
				Elements dateElements = doc.getElementsByClass("cell_last"); // 마감 날짜 div
				Elements linkElements = titleElements.select("a"); // 채용 공고 상세 페이지

				for (int j = 0; j < titleElements.size(); j++) {
					
					// 회사명
					String companyName = companyElements.get(j).getElementsByClass("cl_top").select("a").text();
					
					// 공고 제목
					String title = titleElements.get(j).getElementsByClass("cl_top").select("a").text();
					
					// 조건
					String carrer = titleElements.get(j).getElementsByClass("cl_md").select("span").get(0).text(); // 경력
					String background = titleElements.get(j).getElementsByClass("cl_md").select("span").get(1).text(); // 학력
					String loc = titleElements.get(j).getElementsByClass("cl_md").select("span").get(2).text(); // 지역
					
					
					// 마감 날짜
					String upToDate = dateElements.get(j).getElementsByClass("cl_btm").select("span").get(0).text();																													
					
					// 채용공고 세부 페이지 url
					final String siteUrl = linkElements.get(j).attr("abs:href");

					// 데이터들을 DB에 insert
					dt.setCompanyName(companyName);
					dt.setTitle(title);
					dt.setCarrer(carrer);
					dt.setBackground(background);
					dt.setLoc(loc);
					dt.setUpToDate(upToDate);
					dt.setSiteUrl(siteUrl);
					
					dao.insertData(companyName, title, carrer, background, loc, upToDate, siteUrl, dt);				
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
