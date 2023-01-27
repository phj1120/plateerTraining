package org.plateer.backlms.common.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.backlms.security.JWTUtil;
import org.plateer.backlms.security.filter.JWTLoginFilter;
import org.plateer.backlms.security.filter.TokenCheckFilter;
import org.plateer.backlms.security.handler.JWTLoginFailHandler;
import org.plateer.backlms.security.handler.JWTLoginSuccessHandler;
import org.plateer.backlms.security.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Log4j2
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class CustomSecurityConfig {
    private final CustomUserDetailsService userDetailsService;
    private final JWTUtil jwtUtil;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        log.info("filterChain......");

        // JWT 4번
        //AuthenticationManager 설정
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

        // Get AuthenticationManager
        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        //반드시 필요
        http.authenticationManager(authenticationManager);

        JWTLoginFilter jwtLoginFilter = new JWTLoginFilter("/auth/api/login"); // JWT 2번
        jwtLoginFilter.setAuthenticationManager(authenticationManager);// JWT 5번
        jwtLoginFilter.setAuthenticationSuccessHandler(new JWTLoginSuccessHandler(jwtUtil));
        jwtLoginFilter.setAuthenticationFailureHandler(new JWTLoginFailHandler());

        TokenCheckFilter tokenCheckFilter = new TokenCheckFilter(jwtUtil, userDetailsService);

//        http.addFilterBefore(jwtLoginFilter, UsernamePasswordAuthenticationFilter.class); // JWT 3번
//        http.addFilterBefore(new TokenCheckFilter(jwtUtil, userDetailsService), UsernamePasswordAuthenticationFilter.class);

//        http.formLogin();
        http.httpBasic().disable();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 상태를 유지하지 않겠다.
        http.cors(httpSecurityCorsConfigurer ->
                httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()));

        // 필터에다가 경로 확인 해서 돌리기.
        http.authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/auth/api/register").permitAll();

        http.addFilterBefore(jwtLoginFilter, UsernamePasswordAuthenticationFilter.class) // JWT 3번
                .addFilterBefore(tokenCheckFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
