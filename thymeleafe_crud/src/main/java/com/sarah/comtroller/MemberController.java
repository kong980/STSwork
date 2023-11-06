package com.sarah.comtroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarah.domain.Member;
import com.sarah.repository.MemDao;

@Controller
public class MemberController {
	@Autowired
	private MemDao dao;
	
	@GetMapping("list")
	public String list(Model model) {
		ArrayList<Member> list = (ArrayList<Member>)dao.getDataAll();
		model.addAttribute("members", list);
		return "list";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insert(Member mem) {
		boolean result = dao.insertData(mem);
		if(result) {
			return "redirect:/list";
		}else {
			return "redirect:/error";
		}
	}
	
	@GetMapping("update")
	public String update(String num, Model model) {
		Member mem = dao.updateview(num);
		model.addAttribute("member", mem);
		return "update";
	}
	
	@PostMapping("update")
	public String update(Member mem) {
		boolean result = dao.updateData(mem);
		if(result) {
			return "redirect:/list";
		}else {
			return "redirect:/error";
		}
	}
	
	@GetMapping("delete")
	public String delete(String num) {
		boolean result = dao.deleteData(num);
		if(result) {
			return "redirect:/list";
		}else {
			return "redirect:/error";
		}
	}
}
