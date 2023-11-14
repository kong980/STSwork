package com.sarah.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sarah.domain.CrawlingData;
import com.sarah.repository.CrawlingDataDao;
import com.sarah.service.CrawlingService;

@Controller
public class CrawlingController {
	@Autowired
	private CrawlingDataDao dao;
	
	@Autowired
	private CrawlingService service;
	
	@GetMapping("/basic/pagination.html")
	public String getPaginationPage() {
		return "basic/pagination";
	}
	
	@GetMapping("/basic/header.html")
	public String getHeaderPage() {
		return "basic/header";
	}

	@GetMapping("/job")
	public String list(Model model) {
//		service.getData();
		// 얘는 그냥 DB에 있는 데이터만 조회해서 오는거야
		ArrayList<CrawlingData> list = (ArrayList<CrawlingData>)dao.getDataAll();
		model.addAttribute("jobs", list);
		return "basic/job";
	}

	
//	@RequestMapping("/button")
//	public String button() {
//		cs.button();
//		return "success";
//	}
	
}
