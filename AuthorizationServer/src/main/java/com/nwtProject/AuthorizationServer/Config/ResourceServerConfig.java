package com.nwtProject.AuthorizationServer.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

//Autetifikacija(utvrduje se da li nekon ima pristup)
@EnableResourceServer
@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//Opis se nastavlja sa strane 
		http.requestMatchers()
							.antMatchers("/login","/oauth/autorize")    //Za match url-a
							.and()
							.authorizeRequests()       //Match-uj ova 2 iznad url-a i autoriziraj ih 
							.anyRequest()              //za bilo koji zahtjev
							.authenticated()           //Napravi ih da su autetificirani
							.and()
							.formLogin()               //Omoguci login page
							.permitAll();              //za svakoga
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.parentAuthenticationManager(authenticationManager)
										.inMemoryAuthentication()
										.withUser("Peter")
										.password("peter")
										.roles("ADMIN");
		
	}
	
	
}
