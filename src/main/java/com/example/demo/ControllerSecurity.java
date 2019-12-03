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
		
		.antMatchers("/index").hasAnyRole("ADMIN , USER")
		.antMatchers("/user").hasAnyRole("ADMIN , USER")
		.antMatchers("/cadUser").hasAnyRole("ADMIN , USER")
		.antMatchers("/editar").hasRole("ADMIN")
		.antMatchers("/delete").hasRole("ADMIN")
	
		.
		anyRequest().authenticated()
		.and()
		.formLogin();
		
	}


}
