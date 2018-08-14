package com.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.dto.BithumbDTO;
import com.dto.UpbitDTO;;

public class MyBatisDAO {
	public int bithumbInsert(SqlSession session, ArrayList<BithumbDTO> list) {
		int n = session.insert("com.cryptocurrency.bithumbInsert", list);
		return n;
	}
	
	public int upbitInsert(SqlSession session, ArrayList<UpbitDTO> list) {
		int n = session.insert("com.cryptocurrency.upbitInsert", list);
		return n;
	}
}
