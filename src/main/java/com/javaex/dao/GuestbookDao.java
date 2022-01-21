package com.javaex.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestbookVo> getList(){
		
		List<GuestbookVo> gbList = sqlSession.selectList("guestbook.selectList");
		System.out.println(gbList);
		
		return gbList;
	}
	
	public int insert(GuestbookVo guestbookVo) {
		
		int count = sqlSession.insert("guestbook.insert", guestbookVo);
		System.out.println(count + "건이 저장되었습니다.");
		
		return count;
	}
	
	public int delete(GuestbookVo vo) {
		
		int count = sqlSession.delete("guestbook.delete", vo);
		System.out.println(count + "건이 삭제되었습니다.");
		
		return count;
	}
		
}

