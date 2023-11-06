package com.sarah.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sarah.domain.Member;

@Repository
public class MemDao {
	@Autowired
	private DataMappingInterface dataInterface; // 여기에 객체가 제대로 주입 돼야 작업이 가능
	
	public List<Member> getDataAll(){
		List<Member> list = dataInterface.selectAll();
		return list;
	}
	
	public boolean insertData(Member mem) {
		int result = dataInterface.insertData(mem);
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public Member updateview(String num) {
		Member mem = dataInterface.selectOne(num);
		return mem;
	}
	
	public boolean updateData(Member mem) {
		int result = dataInterface.updateData(mem);
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteData(String num) {
		int result = dataInterface.deleteData(num);
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
}
