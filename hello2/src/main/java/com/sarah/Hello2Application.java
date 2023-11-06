package com.sarah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 이 어노테이션에 우리가 필요로 하는 모든 어노테이션과 설정이 다 들어가 있다.
public class Hello2Application {

	// 메인 메서드는 모든 프로그램의 시작점이 된다. (스프링 부트의 시작점이다.)
	// 컨트롤러도 이 클래스가 있는 위치와 다른 위치에서는 시작 할 수 없다(인식이 안됨) --> 메인 클래스의 위치를 기준으로 해서 여기서부터 작업이 시작
	// --> 같은 위치에 만들거나 자식 패키지로 만들어야 하는 이유
	public static void main(String[] args) {
		SpringApplication.run(Hello2Application.class, args);
	}

}
