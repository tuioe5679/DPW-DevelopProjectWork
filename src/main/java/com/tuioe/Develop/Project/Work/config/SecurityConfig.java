package com.tuioe.Develop.Project.Work.config;

import com.tuioe.Develop.Project.Work.auth.CustomOAuth2UserService;
import com.tuioe.Develop.Project.Work.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()
                    .antMatchers("/api/**").hasRole(Role.USER.name())
                    .anyRequest().permitAll()
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                    .redirectionEndpoint()
                    .baseUri("/login/oauth2/code/github")
                .and()
                    .userInfoEndpoint()
                    .userService(customOAuth2UserService);
        return http.build();
    }
}
