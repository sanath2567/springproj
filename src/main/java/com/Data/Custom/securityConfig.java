package com.Data.Custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {
    @Autowired
    private UserDetailsService userDetails;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetails);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /*http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/login", "/home").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )

                );*/
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login", "/home").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")  // Admin role required for /admin
                        .anyRequest().authenticated()  // Other requests require authentication
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error=true")// Specify the custom login page
                        .permitAll()  // Allow all to access the login page
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll())  // Allow logout for all authenticated users
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling.accessDeniedPage("/access-denied")
                );


        http.httpBasic(Customizer.withDefaults());
        http.csrf(customizer -> customizer.disable());
        return http.build();
    }

}
