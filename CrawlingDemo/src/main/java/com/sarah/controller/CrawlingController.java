package com.sarah.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sarah.domain.CrawlingData;
import com.sarah.repository.CrawlingDataDao;

@Controller
public class CrawlingController {
	@Autowired
	private CrawlingDataDao dao;
	
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
		ArrayList<CrawlingData> list = (ArrayList<CrawlingData>)dao.getDataAll();
		model.addAttribute("jobs", list);
		System.out.println(list);
		return "basic/job";
	}
}
