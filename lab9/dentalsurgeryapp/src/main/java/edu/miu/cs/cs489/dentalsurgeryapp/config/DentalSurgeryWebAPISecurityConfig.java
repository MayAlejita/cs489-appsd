package edu.miu.cs.cs489.dentalsurgeryapp.config;

import edu.miu.cs.cs489.dentalsurgeryapp.filter.JWTAuthFilter;
import edu.miu.cs.cs489.dentalsurgeryapp.service.impl.DentalSurgeryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
public class DentalSurgeryWebAPISecurityConfig {
    private DentalSurgeryUserDetailsService dentalSurgeryUserDetailsService;
    private JWTAuthFilter jwtAuthFilter;

    public DentalSurgeryWebAPISecurityConfig(DentalSurgeryUserDetailsService dentalSurgeryUserDetailsService, JWTAuthFilter jwtAuthFilter) {
        this.dentalSurgeryUserDetailsService = dentalSurgeryUserDetailsService;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> {
                            auth
                                    .requestMatchers("/adsweb/api/v1/public/auth/**").permitAll()
                                    .requestMatchers("/adsweb/api/v1/user/**").permitAll()
                                    .requestMatchers("/adsweb/api/v1/appointment/**").authenticated()
                                    .requestMatchers("/adsweb/api/v1/address/**").authenticated()
                                    .requestMatchers("/adsweb/api/v1/patient/**").authenticated();
                        }
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(dentalSurgeryUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
