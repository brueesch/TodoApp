package ch.brueesch.todoapp.todoapp.config;

import static java.util.Arrays.asList;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.*;

/**
 * Security-Konfiguration
 *
 * @author upr4940 {@code <michael.lorenzi@raiffeisen.ch>}
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/actuator/health", "/actuator/info", "swagger-ui.html", "/webjars/**");
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// disabled for non-browser-clients
		http.csrf().disable();

		// authentication
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// cors
		http.cors().configurationSource(corsConfigurationSource());
	}

	private static CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
		corsConfiguration.setAllowedMethods(asList("GET", "PUT", "POST", "DELETE", "OPTIONS"));
		corsConfiguration.setAllowedHeaders(asList("origin", "content-type", "accept", "x-requested-with"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration);
		return source;
	}


}
