package net.hammed.craft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.cors(cors->cors.disable())
        .csrf(csrf -> csrf.disable())
        
        .authorizeHttpRequests(authz->authz.requestMatchers("/api/v1/auth/**").permitAll()
        .requestMatchers("/ws/**").permitAll()
        .requestMatchers("/api/v1/student/**").hasAuthority("STUDENT")
        .requestMatchers("/api/v1/tutor/**").hasAuthority("TUTOR")
        .requestMatchers("/api/v1/admin/**").hasAuthority("ADMIN")
        
        .anyRequest()
        .authenticated())
        // .exceptionHandling(exceptions -> exceptions
        // .authenticationEntryPoint(customAuthenticationEntryPoint) // Set custom entry point
    
        .sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
