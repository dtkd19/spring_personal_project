package com.sh.spring.dao;

import java.util.List;

import com.sh.spring.domain.AuthVO;
import com.sh.spring.domain.UserVO;

public interface UserDAO {

	int register(UserVO uvo);

	int registerAuthInit(String email);

	UserVO selectEmail(String username);

	List<AuthVO> selectAuths(String username);

	int updateLastLogin(String authEmail);

	List<UserVO> getList();

	int modifyPwdEmpty(UserVO uvo);

	int modify(UserVO uvo);

	int removeAuth(String email);

	int remove(String email);

//	int deleteAuth(String email);
//
//	int delete(String email);

}
