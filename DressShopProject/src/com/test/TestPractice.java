package com.test;

import java.util.List;

import com.service.MemberService;
import com.vo.MemberVo;

public class TestPractice {

	public static void main(String[] args) {
		MemberService service = new MemberService();
		int cnt = service.selectMemberCount("benny").size();
	}

}
