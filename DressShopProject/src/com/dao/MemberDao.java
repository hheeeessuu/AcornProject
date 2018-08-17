package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.vo.MemberVo;

public class MemberDao {
	
	public List<MemberVo> selectMemberCount(SqlSession session, String userid) {
		List<MemberVo> list = session.selectList("selectMemberCount", userid);
		return list;
	}
	
	public int insertMember(SqlSession session, MemberVo vo) {
		return session.insert("insertMember", vo);
	}

}
