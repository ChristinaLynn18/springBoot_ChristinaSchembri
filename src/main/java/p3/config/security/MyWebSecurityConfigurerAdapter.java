package p3.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(MyWebSecurityConfigurerAdapter.class);
	
	
	@Value("${mh.security.authserver.BCryptPasswordEncoder.usedToEncodePassword:true}")
	private boolean useBCryptPasswordEncoder2encodePassword;
	
	private String encode(String rawPassword) {
		String password = useBCryptPasswordEncoder2encodePassword ? passwordEncoder().encode(rawPassword) : rawPassword;
		logger.info("--ILKER --> encode({}) with useBCryptPasswordEncoder2encodePassword:{} returning password as {}", rawPassword, useBCryptPasswordEncoder2encodePassword, password);
		return password;
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/home","/public**").permitAll()
			.antMatchers("/anonymous").anonymous()
			.antMatchers("/authenticated", "userSettings/**").authenticated()
			.antMatchers("/admin", "/h2_console/**").hasRole("ADMIN")
			.antMatchers("/developer/**").hasAnyAuthority("haveDogs", "ROLE_ADMIN", "ROLE_DEVELOPER", "ROLE_catMaster", "ROLE_dogMaster")
			.antMatchers("/rest/v1/catsUser/echoMessage").hasRole("catMaster")
			.antMatchers("/rest/v1/dogsUser/echoMessage").hasAnyAuthority("haveDogs", "ROLE_dogMaster")
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").permitAll()
			.and()
			.logout().permitAll()
			;
		
		http.exceptionHandling().accessDeniedPage("/403");
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
	protected void configure_OLD(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/admin", "/h2_console/**").hasRole("ADMIN").anyRequest()
				.authenticated()
				.and()
				.formLogin().loginPage("/login").permitAll()
				.and()
				.logout().permitAll();
		http.exceptionHandling().accessDeniedPage("/403");
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
	@Autowired
	public void configureGlobal_(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("admin").password(encode("admin")).roles("ADMIN")
				.and()
				.withUser("developer").password(encode("developer")).authorities("haveDogs", "ROLE_ADMIN", "ROLE_DEVELOPER", "ROLE_catMaster", "ROLE_dogMaster")
				.and()
				.withUser("catsUser").password(encode("catsUser")).roles("catMaster")
				.and()
				.withUser("dogsUser").password(encode("dogsUser")).authorities("haveDogs", "ROLE_dogMaster")
				;
	}	
}
