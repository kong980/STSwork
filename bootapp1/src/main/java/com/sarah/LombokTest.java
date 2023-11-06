package com.sarah;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/*
// lombok : @Getter, @Setter 어노테이션으로 바로 호출 가능
@Getter
@Setter
public class LombokTest {
	
	private String hello;
	private int count;

	public static void main(String[] args) {
		LombokTest test = new LombokTest();
		test.setHello("안녕하세요");
		test.setCount(10);

		System.out.println(test.getHello());
		System.out.println(test.getCount());
	}

}
*/

@Getter
// @RequiredArgsConstructor : Setter 대신 생성자로 자동 주입 --> 변수는 반드시 final로 선언해야 함
@RequiredArgsConstructor
public class LombokTest {
	
	private final String hello;
	private final int count;

	public static void main(String[] args) {
		LombokTest test = new LombokTest("안녕하세요~", 100);

		System.out.println(test.getHello());
		System.out.println(test.getCount());
	}

}