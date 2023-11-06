package com.sarah.basic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.Setter;

@Controller
@RequestMapping("/basic")
public class BasicController {

	@GetMapping("/text-basic")
	public String textBasic(Model model) {
		model.addAttribute("data", "Hello Spring");
		model.addAttribute("data2", "Hello <b>Spring</b>"); // 스타일을 직접 html에 전달하는 경우
		return "basic/text-basic"; // .html은 기본으로 resolver 설정이 돼 있기 때문에 따로 설정 할 필요가 없다.
	}
	
	@GetMapping("/variable")
	public String variable(Model model) {
		User userA = new User("userA", 10);
		User userB = new User("userB", 20);
		
		List list = new ArrayList<>(Arrays.asList(userA, userB));
		
		Map<String, User> map = new HashMap<>();
		map.put("userA", userA);
		map.put("userB", userB);
		
		model.addAttribute("user", userA);
		model.addAttribute("users", list);
		model.addAttribute("userMap", map);
		
		
		return "basic/variable";
	}
	
	@Getter
	@Setter
	static class User{
		private String userName;
		private int age;
		
		public User() {}
		
		public User(String userName, int age) {
			this.userName = userName;
			this.age = age;
		}
	
	} // User End
	@GetMapping("/basic-objects")
	public String basicObjects(HttpSession session, HttpServletRequest req) {
		session.setAttribute("sessionData", "Hello Session~");
		req.setAttribute("userName", "홍길동");
		return "basic/basic-objects";
	}
	
	@Component("helloBean")
	static class HelloBean{
		public String hello(String data) {
			return "Hello!!! " + data;
		}
	} // HelloBean End
	
	@GetMapping("/date")
	public String date(Model model) {
		model.addAttribute("localDateTime", LocalDateTime.now());
		return "basic/date";
	}
	
	@GetMapping("/link")
	public String link(Model model) {
		model.addAttribute("param1","data1");
		model.addAttribute("param2","data2");
		return "basic/link";
	}
	
	@GetMapping("/literal")
	public String literal(Model model) {
		model.addAttribute("data", "Spring~~~");
		return "basic/literal";
	}
	
	@GetMapping("/operation")
	public String operation(Model model) {
		model.addAttribute("nullData", null);
		model.addAttribute("data", "Spring~!");
		
		return "basic/operation";
	}
	
	@GetMapping("/attribute")
	public String attribute() {
		return "basic/attribute";
	}

	@GetMapping("/each")
	public String each(Model model) {
		addUsers(model);
		return "basic/each";
	}
	
	private void addUsers(Model model) {
		List users = Arrays.asList(new User("userA",15), new User("userB",23), new User("userC",37));
		model.addAttribute("users", users);
	}
	
	@GetMapping("/condition")
	public String condition(Model model) {
		addUsers(model);
		return "basic/condition";
	}
	
	@GetMapping("/comments")
	public String comments(Model model) {
		model.addAttribute("data", "Spring~~~!!");
		return "basic/comments";
	}
	
	@GetMapping("/block")
	public String block(Model model) {
		addUsers(model);
		return "basic/block";
	}
	
	@GetMapping("/javascript")
	public String javascript(Model model) {
		model.addAttribute("user", new User("홍길동", 20));
		addUsers(model);
		return "basic/javascript";
	}
}
