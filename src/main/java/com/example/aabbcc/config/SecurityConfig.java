package com.example.aabbcc.config;

import com.example.aabbcc.repo.UserRepo;
import com.example.aabbcc.services.CVHKUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AndRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    private final CVHKUserService cvhkUserService;
    private final UserRepo userRepo;

    public SecurityConfig(CVHKUserService cvhkUserService, UserRepo userRepo) {

        this.cvhkUserService = cvhkUserService;
        this.userRepo = userRepo;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    private DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(cvhkUserService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/register/**","/show/**","/login/**","/img**")
                .permitAll().anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().invalidateHttpSession(true).clearAuthentication(true);
              //  .logoutRequestMatcher(new AndRequestMatcher("") )
              //  .logoutSuccessUrl("/logout?logout").permitAll();
//
       /* http
                .cors().and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtAuthorizationFilter(authenticationManagerBean(), userRepository))
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers(("/auth/login")).permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        */
    }



}
