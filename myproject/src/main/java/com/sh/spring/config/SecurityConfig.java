package com.sh.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.sh.spring.security.CustomAuthUserService;
import com.sh.spring.security.LoginFailureHandler;
import com.sh.spring.security.LoginSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// 비밀번호 암호화 객체 PasswordEncoder 빈 생성
	@Bean
	public PasswordEncoder bcPassWordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	// SuccessHandler 객체 빈 생성 => 사용자 커스텀 객체
	public AuthenticationSuccessHandler authSuccessHnadler() {
		return new LoginSuccessHandler();
	}
	
	// FailureHandler 객체 빈 생성 => 사용자 커스텀 객체 
	@Bean
	public AuthenticationFailureHandler authFailureHandler() {
		return new LoginFailureHandler();
	}
	
	// UserDetail 객체 빈 생성 => 사용자 커스텀 객체
	@Bean
	public UserDetailsService customDetailsService() {
		return new CustomAuthUserService();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 인증용 객체 생성 메니저 설정
		auth.userDetailsService(customDetailsService()).passwordEncoder(bcPassWordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
	
		http.authorizeRequests().antMatchers("/user/list").hasRole("ADMIN")
		.antMatchers("/","/user/login","/user/register","/board/list","/board/sortCmt","/board/sortRead","/upload/**","/comment/**","/resources/**").permitAll()
		.anyRequest().authenticated();
		
		// 로그인 페이지 구성 : id => email / pw => pwd 
		// Controller에 주소요청 맵핑은 같이 있어야 함. (필수) 
		http.formLogin()
			.usernameParameter("email")
			.passwordParameter("pwd")
			.loginPage("/user/login")
			.successHandler(authSuccessHnadler())
			.failureHandler(authFailureHandler());
		
		
		// 로그아웃 구성 : method ="post"
		http.logout()
			.logoutUrl("/user/logout")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.logoutSuccessUrl("/");

	}
	
	
}
