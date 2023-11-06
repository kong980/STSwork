package com.sarah.domain;

import lombok.Data;

@Data // @Getter, @Setter, @RequiredArgConstructor, @ToString, @EqualsAndHashCode를 한 번에 묶어주는 어노테이션
public class Member {
	private String num, name, addr; // num을 db에서 int로 했다고 dto에서 변수를 int로 선언하지 않아도 괜찮음
}
