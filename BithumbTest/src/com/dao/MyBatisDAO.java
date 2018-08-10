package com.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.dto.BithumbDTO;;

public class MyBatisDAO {
	public int multiInsert(SqlSession session, ArrayList<BithumbDTO> kkk) {
		int n = session.insert("com.bithumb.multiInsert", kkk);
		return n;
	}
}
