package com.movieapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.movieapp.implementation.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		
		.authorizeRequests()
		.antMatchers("/addcinema/**").hasAnyAuthority("Admin")
		.antMatchers("/allcinema/**").hasAnyAuthority("Admin")
		.antMatchers("/allmovies/**").hasAnyAuthority("User")
		.antMatchers("/updatemovie/**").permitAll()
		.antMatchers("/movie/**").permitAll()
		.antMatchers("/deleltemovie/**").permitAll()
		.antMatchers("/deleltehistory/**").permitAll()
		.antMatchers("/cinema/**").permitAll()
		.antMatchers("/deletecinema/**").permitAll()
		.antMatchers("/historyList/**").hasAnyAuthority("User")
		.antMatchers("/home").permitAll()
		.antMatchers("/movieCompare").permitAll()
		.antMatchers("/register").permitAll()
		.antMatchers("/trailer").permitAll()
		.antMatchers("/process_register").permitAll()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/*.js").permitAll()
		.antMatchers("/movie_compare").anonymous()
		.antMatchers("/cinema").permitAll()
			.antMatchers("/film").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().defaultSuccessUrl("/home",true)
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			;
	}
	
	
}
