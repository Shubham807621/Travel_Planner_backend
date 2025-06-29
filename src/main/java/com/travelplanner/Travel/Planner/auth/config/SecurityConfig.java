package com.travelplanner.Travel.Planner.auth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JWTTokenHelper jwtTokenHelper;

    public SecurityConfig(JWTTokenHelper jwtTokenHelper, UserDetailsService userDetailsService) {
        this.jwtTokenHelper = jwtTokenHelper;
        this.userDetailsService = userDetailsService;
    }

    private static final String[] PUBLIC_APIS = {
            "/auth/**",

    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // ✅ CORS Enabled
                .csrf(AbstractHttpConfigurer::disable) // ✅ CSRF Disabled for APIs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(PUBLIC_APIS).permitAll() // ✅ Public APIs allowed
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/get_states/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/add-states").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/update-states").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/cities/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/city/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/add-city").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/update-city").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/hotel/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/hotel/search").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/add-hotel").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/update-hotel").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/room/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/add-room").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/update-room").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/packages/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/add-package").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/get-places/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/availability/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/add-places").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/update-place").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/add-hotel-booking").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/all-booking").permitAll()

                        .anyRequest().authenticated()
                )
                .addFilterBefore(new JWTAuthenticationFilter(jwtTokenHelper, userDetailsService),
                        UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }


    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(daoAuthenticationProvider);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:5173","https://travel-planner-sable-pi.vercel.app/"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
