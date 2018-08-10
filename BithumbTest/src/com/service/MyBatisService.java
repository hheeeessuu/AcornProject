package com.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dto.BithumbDTO;
import com.dao.MyBatisDAO;

public class MyBatisService {
	private MyBatisDAO dao = null;

	public MyBatisService() {
		super();
		dao = new MyBatisDAO();
	}

	public void multiInsert(ArrayList<BithumbDTO> kkk) {
		MyBatisDAO dao = new   MyBatisDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			int n= dao.multiInsert(session, kkk);
			if(n!=0) {
				session.commit();
			}
		}finally {
			session.close();
		}
	}
}
