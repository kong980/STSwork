package com.sarah.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.sarah.domain.CrawlingData;
import com.sarah.repository.DataMappingInterface;

@Service
public class CrawlingService {
	private CrawlingData crawlingData;
	private DataMappingInterface dataMappingInterface;
// 실시간 크롤링이 구조적으로 불가능한 이유
// 1. 너네는 로컬서버에서 작업하는거지 실제 서버가 아니기에 실시간 처리가 불가능해
// 1-1. 애초에 크롤링을 예를들어 5분단위로 돌려야하는건데 로컬에서 그게 불가능하지 - why? 컴퓨터 계속 켜둘거야 ? 24시간 내내 ? 그걸 지금 정상적인
//	생각이라고 말하는건지 의문임.
// 2. 1에대한 부연설명인데 실제 웹사이트가 돌아가야 가능한 일이고.
// 애초에 너네가 실시간으로 할 수가 없는 이유가 시간을 지정해서 돌아가게 만들지 못한다는 걸 나는 알고 있음.

// 사이트에 들어갔을 때 크롤링하면 안되는 이유
// 1. 사이트 들어가는데 너무 오래걸려 
//	WHY? 
//	사이트 열릴 때 크롤링 시간 + DB에 insert 하는 시간 + DB에서 select 하는 시간 + 화면에 뿌려지는 시간 을 생각해봤을 때
//	크롤링하는게 지금은 자바에서 돌리니까 금방나오는거처럼 보이는데
//	웹에서 처리를 하면 시간이 더걸리기 때문에 메인페이지가 그만큼 늦게 열려요.

//	내가 생각할 수 있는 최상의 시나리오
//	1. 메인은 그냥 정상적으로 열려요
//	2. 기존 데이터를 가지고 채용 정보 페이지를 보여줌
//	3. 인크루트 사이트의 현재 데이터를 보여줌
//	4. 크롤링 버튼을 만들어 인크루트 사이트의 현재 데이터를 크롤링하여 DB에 insert
//	5. 해당 데이터를 채용 정보 페이지에 뿌려줌

//	public static void main(String[] args) {
	public int getData() {
		for (int i = 1; i < 6; i++) {
			// 인크루트 주소 가져오기
			// 크롤링을 해서 DB에 넣기만 하면돼
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
					String upToDate = dateElements.get(j).getElementsByClass("cl_btm").select("span").get(0).text(); // 마감
																														// 날짜

					final String siteUrl = linkElements.get(j).attr("abs:href"); // 채용공고 세부 페이지 url

					// 열심히 뽑은 String 데이터들을 DB에 insert 해야돼
					
					
					
					System.out.print(companyName + " : "); // 회사명 텍스트만 뽑기
					System.out.println(title); // 채용공고 텍스트만 뽑기
					System.out.println(condition); // 조건만 뽑기
					System.out.println(upToDate); // 마감 날짜만 뽑기
					System.out.println(siteUrl);

					System.out.println();
//					CrawlingData cd = new CrawlingData();
//					cd.getCompanyName();
//					Set<CrawlingData> dataList = new HashSet<CrawlingData>();
//					dataList.add(new CrawlingData());
//					List<CrawlingData> cd;
//					cd.add(compnayName);
				
				}

//			for(Element element : imageUrlElements) {
//			System.out.println(element);
//			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

//	}
//	public String button() {
//		for (int i = 1; i < 6; i++) {
//			// 인크루트 주소 가져오기
//			// 크롤링을 해서 DB에 넣기만 하면돼 
//			String url = "https://job.incruit.com/jobdb_list/searchjob.asp?occ1=150&page=" + i;
//
//			try {
//				Document doc = Jsoup.connect(url).get(); // 주소에 있는 html 파일 가져다 넣기
//				Elements goSiteUrlElements = doc.getElementsByClass("c_col "); // 채용공고 세부 페이지 url 가져오기 위함
//				// Elements imageUrlElements = doc.getElementsByClass("cl_top"); //회사명 & 채용공고 제목
//				// 가져오기 위함
//				Elements companyElements = doc.getElementsByClass("cell_first"); // 기업명
//				Elements titleElements = doc.getElementsByClass("cell_mid"); // 공고 제목
//				Elements dateElements = doc.getElementsByClass("cell_last"); // 공고 제목
////			System.out.println(goSiteUrlElements);
//				Elements linkElements = titleElements.select("a"); // 채용 공고 상세 페이지
//
//				for (int j = 0; j < titleElements.size(); j++) {
////				final String company = companyElements.get(i).text();
//
////				System.out.println(companyElements.get(i).text() + " : " + titleElements.get(i).text());
////				System.out.println(goSiteUrlElements.get(i).text());
//					String companyName = companyElements.get(j).getElementsByClass("cl_top").select("a").text(); // 회사명
//					String title = titleElements.get(j).getElementsByClass("cl_top").select("a").text(); // 채용공고 제목
//					String condition = titleElements.get(j).getElementsByClass("cl_md").select("span").text(); // 조건
//					String upToDate = dateElements.get(j).getElementsByClass("cl_btm").select("span").get(0).text(); // 마감 날짜
//																														
//					final String siteUrl = linkElements.get(j).attr("abs:href"); // 채용공고 세부 페이지 url
//					
//					// 열심히 뽑은 String 데이터들을 DB에 insert 해야돼 
//					// 하단에 sysout 한것처럼 데이터를 Dao의 insert를 호출하면서 데이터를 넘겨줘
//					// ex) insert(mem); / 여기서 mem 은 List
//					
////					System.out.print(companyName + " : "); // 회사명 텍스트만 뽑기
////					System.out.println(title); // 채용공고 텍스트만 뽑기
////					System.out.println(condition); // 조건만 뽑기
////					System.out.println(upToDate); // 마감 날짜만 뽑기
////					System.out.println(siteUrl);
//
//					
////					System.out.println();
////					CrawlingData cd = new CrawlingData();
////					cd.getCompanyName();
////					Set<CrawlingData> dataList = new HashSet<CrawlingData>();
////					dataList.add(new CrawlingData());
////					List<CrawlingData> cd;
////					cd.add(compnayName);
//				}
//
////			for(Element element : imageUrlElements) {
////			System.out.println(element);
////			}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//		}
//		return "success";
//	}
}
