package edu.miu.cs.alvin.music_streaming_app_backend.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity


public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable CSRF for simplicity
                .authorizeRequests()
                .antMatchers("/public/**").permitAll() // Public API
                .antMatchers("/admin/**").hasRole("ADMIN") // Admin API
                .antMatchers("/user/**").hasRole("USER") // User API
                .anyRequest().authenticated() // All other APIs require authentication
                .and()
                .httpBasic(); // Use basic authentication
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}adminpass").roles("ADMIN")
                .and()
                .withUser("user").password("{noop}userpass").roles("USER");
    }
}

}
