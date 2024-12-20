package com.sh.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.sh.spring.dao.UserDAO;

import lombok.Getter;
import lombok.Setter;



@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private UserDAO udao;
	
	@Getter
	@Setter
	private String authEmail;
	
	@Getter
	@Setter
	private String authUrl;
	
	// redirect 데이터를 가지고 리다이렉트 경로로 이동하는 역할
	private RedirectStrategy redStr = new DefaultRedirectStrategy();
		
	// 세션의 캐시 정보, 경로
	private RequestCache reqCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		setAuthEmail(authentication.getName());
		int isOk = udao.updateLastLogin(getAuthEmail());
		setAuthUrl("/");
		
		HttpSession ses = request.getSession();
		if(isOk == 0 || ses == null) {
			return;
		} else {
			// removeAttribute : 세션의 객체 삭제
			ses.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
		SavedRequest saveRequest = reqCache.getRequest(request, response);
		redStr.sendRedirect(request, response,
			   saveRequest != null ? saveRequest.getRedirectUrl() : getAuthUrl());
		
		}

}
