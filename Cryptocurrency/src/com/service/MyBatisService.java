package com.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dto.BithumbDTO;
import com.dto.UpbitDTO;
import com.dao.MyBatisDAO;

public class MyBatisService {
	private MyBatisDAO dao = null;

	public MyBatisService() {
		super();
		dao = new MyBatisDAO();
	}

	public void bithumbInsert(ArrayList<BithumbDTO> list) {
		MyBatisDAO dao = new   MyBatisDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			int n= dao.bithumbInsert(session, list);
			if(n!=0) {
				session.commit();
			}
			System.out.println("bithumbInsert : " + n);
		}finally {
			session.close();
		}
	}
	
	public void upbitInsert(ArrayList<UpbitDTO> list) {
		MyBatisDAO dao = new   MyBatisDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			int n= dao.upbitInsert(session, list);
			if(n!=0) {
				session.commit();
			}
			System.out.println("upbitInsert : " + n);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
