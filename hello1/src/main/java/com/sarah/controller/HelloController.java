package com.sarah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController // Rest 방식(xml, json)으로 응답을 하겠다~ 라는 뜻
public class HelloController {
	@GetMapping("/")
	@ResponseBody
	public String hello() {
		return "Hello Spring Boot!!!";
	}
}
