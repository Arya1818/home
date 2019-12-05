package com.test.home.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.test.home.vo.UserVO;

@Repository
public class UserDAO {
	
	@Resource
	private SqlSessionFactory ssf;
	
	public List<UserVO> getUserList(UserVO user){
		SqlSession ss = ssf.openSession();
		
		try {
			return ss.selectList("com.test.home.dao.UserInfoDao.selectUserInfoList",user);
		}catch(Exception e){
			
		}finally {
			ss.close();
		}
		return null;
	}
}
