package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.OracleSqlSessionFactory;
import com.dao.MemberDao;
import com.vo.MemberVo;

public class MemberService {
	
	public MemberService() {
	}
	
	public List<MemberVo> selectMemberCount(String userid) {
		MemberDao dao = new MemberDao();
		SqlSession session = OracleSqlSessionFactory.getSession();
		List<MemberVo> id=null;
		try {
			id = dao.selectMemberCount(session, userid);
		}catch(Exception e){
			System.err.println(e);
		}finally {
			session.close();
		}
		return id;
	}
	
	public int insertMember(MemberVo vo) {
		MemberDao dao = new MemberDao();
		SqlSession session = OracleSqlSessionFactory.getSession();
		int i=0;
		try {
			i = dao.insertMember(session, vo);
			session.commit();
		}catch(Exception e){
			System.err.println(e);
		}finally {
			session.close();
		}
		return i;
	}

}
