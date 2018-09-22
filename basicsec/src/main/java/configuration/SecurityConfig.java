package configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user")
				.password("pass")
				.roles("USER")
			.and()
				.withUser("admin")
				.password("secret")
				.roles("ROLES");
	}

	@Override
	protected void configure(HttpSecurity httpSec) throws Exception {
		httpSec
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers("/delete").hasRole("ADMIN")
				.antMatchers("/admin/**").hasRole("ADMIN")
			.and()
				.formLogin()
				.permitAll();
	}
}
