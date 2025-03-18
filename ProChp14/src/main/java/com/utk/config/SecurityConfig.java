package com.utk.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {

		/*
		 * Uncomment this block for the first time to create users in the database
		 * 
		 * User.UserBuilder users =
		 * User.builder().passwordEncoder(passwordEncoder()::encode); UserDetails john =
		 * users.username("john").password("password").roles("USER").build();
		 * UserDetails jane =
		 * users.username("jane").password("password").roles("USER").build();
		 * UserDetails admin = users.username("admin").password("admin").roles("ADMIN")
		 * .build(); JdbcUserDetailsManager manager = new
		 * JdbcUserDetailsManager(dataSource); manager.createUser(john);
		 * manager.createUser(jane); manager.createUser(admin);
		 */
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/styles/**", "/images/**").permitAll()
				.anyRequest().authenticated())
				// .httpBasic(Customizer.withDefaults())
				.formLogin(loginConfigurer -> loginConfigurer.loginPage("/auth").loginProcessingUrl("/auth")
						.usernameParameter("user").passwordParameter("pass").defaultSuccessUrl("/home").permitAll())
				.csrf().disable().logout(httpSecurirtyLogoutConfigurer -> httpSecurirtyLogoutConfigurer
						.logoutUrl("/exit").permitAll().clearAuthentication(true));

		return http.build();
	}

}
