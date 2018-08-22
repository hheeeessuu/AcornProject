package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.TableDAO;
import com.dto.TableDTO;

public class MyTableService {


	public List<TableDTO> select(HashMap<String, String> map) {
		TableDAO dao = new TableDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		List<TableDTO> list = null;
		try {
			list = dao.select(session,map);

			// }catch(Exception e) {
			// e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}// end select

}
