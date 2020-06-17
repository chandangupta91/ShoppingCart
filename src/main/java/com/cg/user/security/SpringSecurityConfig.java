package com.cg.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cg.user.security.JWT.JwtEntryPoint;
import com.cg.user.security.JWT.JwtFilter;

import javax.sql.DataSource;

/**
 * Created By Zhu Lin on 1/1/2019.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    JwtFilter jwtFilter;
    @Autowired
    private JwtEntryPoint accessDenyHandler;

    @Autowired
    @Qualifier("dataSource")
    DataSource dataSource;

    @Value("${users-query}")
    private String usersQuery;

    @Value("${roles-query}")
    private String rolesQuery;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable()
                .authorizeRequests()

                .antMatchers("/profile/**").authenticated()
              //  .antMatchers("/users/login").access("hasAnyRole('MANAGER')")
                .antMatchers("/ordler/finish/**").access("hasAnyRole('EMPLOYEE', 'MANAGER')")
                .antMatchers("/order/**").authenticated()
                .antMatchers("/profiles/**").authenticated()
                .antMatchers("/seller/product/new").access("hasAnyRole('MANAGER')")
                .antMatchers("/seller/**/delete").access("hasAnyRole( 'MANAGER')")
                .antMatchers("/seller/**").access("hasAnyRole('EMPLOYEE', 'MANAGER')")
                .anyRequest().permitAll()

                .and()
                .exceptionHandling().authenticationEntryPoint(accessDenyHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
    
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
