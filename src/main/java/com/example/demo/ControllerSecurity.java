	package com.example.demo;



import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SuppressWarnings("deprecation")
@EnableWebSecurity
public class ControllerSecurity extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		
		.withUser("user")
		.password("user")
		.roles("USER")
		
		.and()	
		
		.withUser("diogo")
		.password("diogo")
		.roles("ADMIN")
		
		.and();
		
			
	}
	
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() 
		
		.antMatchers("/resources/**", "/webjars/**").permitAll()
		
		.antMatchers("/index").hasAnyRole("ADMIN,USER")
		.antMatchers("/cad").hasRole("ADMIN")
		.antMatchers("/cadastroUsers").hasAnyRole("USER, ADMIN")
		.antMatchers("/editar/id").hasRole("ADMIN")
		.antMatchers("/delete/id").hasRole("ADMIN")
		.antMatchers("/userCad").hasAnyRole("ADMIN, USER")
		.antMatchers("/sobre").hasAnyRole("ADMIN, USER")
		.antMatchers("/sair").hasAnyRole("ADMIN, USER")
			
		.
		anyRequest().authenticated()
		.and()
		.formLogin();
		
	}


}
