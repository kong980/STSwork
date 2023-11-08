package com.sarah.crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CrawlingTest {
	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			// 인크루트 주소 가져오기
			String url = "https://job.incruit.com/jobdb_list/searchjob.asp?occ1=150&page=" + i;

			try {
				Document doc = Jsoup.connect(url).get(); // 주소에 있는 html 파일 가져다 넣기
				Elements goSiteUrlElements = doc.getElementsByClass("c_col "); // 채용공고 세부 페이지 url 가져오기 위함
				// Elements imageUrlElements = doc.getElementsByClass("cl_top"); //회사명 & 채용공고 제목
				// 가져오기 위함
				Elements companyElements = doc.getElementsByClass("cell_first"); // 기업명
				Elements titleElements = doc.getElementsByClass("cell_mid"); // 공고 제목
				Elements dateElements = doc.getElementsByClass("cell_last"); // 공고 제목
//			System.out.println(goSiteUrlElements);
				Elements linkElements = titleElements.select("a"); // 채용 공고 상세 페이지

				for (int j = 0; j < titleElements.size(); j++) {
//				final String company = companyElements.get(i).text();

//				System.out.println(companyElements.get(i).text() + " : " + titleElements.get(i).text());
//				System.out.println(goSiteUrlElements.get(i).text());
					String companyName = companyElements.get(j).getElementsByClass("cl_top").select("a").text(); // 회사명
					String title = titleElements.get(j).getElementsByClass("cl_top").select("a").text(); // 채용공고 제목
					String condition = titleElements.get(j).getElementsByClass("cl_md").select("span").text(); // 조건
					String upToDate = dateElements.get(j).getElementsByClass("cl_btm").select("span").get(0).text(); // 마감 날짜
																														
					final String siteUrl = linkElements.get(j).attr("abs:href"); // 채용공고 세부 페이지 url

					System.out.print(companyName + " : "); // 회사명 텍스트만 뽑기
					System.out.println(title); // 채용공고 텍스트만 뽑기
					System.out.println(condition); // 조건만 뽑기
					System.out.println(upToDate); // 마감 날짜만 뽑기
					System.out.println(siteUrl);

					System.out.println();
				}

//			for(Element element : imageUrlElements) {
//			System.out.println(element);
//			}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
