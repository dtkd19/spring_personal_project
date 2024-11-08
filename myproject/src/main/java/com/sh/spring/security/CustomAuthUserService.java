package com.sh.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sh.spring.dao.UserDAO;
import com.sh.spring.domain.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAuthUserService implements UserDetailsService {
	
	@Autowired
	private UserDAO udao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username : 로그인을 시도하는 email
		UserVO uvo = udao.selectEmail(username);
		// 아이디가 없거나 잘못 입력되면...
		if(uvo == null) {
			throw new UsernameNotFoundException(username);
		}
			
		uvo.setAuthList(udao.selectAuths(username));
		
		log.info(">>>> userDetails >> {} " , uvo);
		
		return new AuthUser(uvo);
	}

}
