package com.nit.shashi.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
auth.inMemoryAuthentication().withUser("shashi").password("{noop}shashi").authorities("admin");	
auth.inMemoryAuthentication().withUser("jha").password("{noop}jha").authorities("student");	
auth.inMemoryAuthentication().withUser("sonu").password("{noop}sonu").authorities("employee");	
}
@Override
	protected void configure(HttpSecurity http) throws Exception {
	//write url acces logic
	http.authorizeRequests()
	.antMatchers("/home").permitAll()
	.antMatchers("/welcome").authenticated()
	.antMatchers("/student").hasAuthority("student")
	.antMatchers("/emp").hasAuthority("employee")
	.antMatchers("/admin").hasAuthority("admin")
	.antMatchers("/change").hasAnyAuthority("admin","student")
	
	// pagelogin
	.and()
	.formLogin()
	.defaultSuccessUrl("/home")
	
	//logoutdetails
	.and()
	.logout()
	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

	
	//exception handling
	.and()
	.exceptionHandling()
	.accessDeniedPage("/denied")

	;
	
	
	
}
	
	
}
