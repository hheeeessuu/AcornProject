package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.TableDTO;

public class TableDAO {


	public List<TableDTO> select(SqlSession session, HashMap<String, String> map) {
		List<TableDTO> list = session.selectList("com.dto.selectAll",map);
		return list;
	}
	
	
}
