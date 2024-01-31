package com.example.boc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest()
//                        .permitAll());
        http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest()
                        .permitAll())
                .formLogin(form->form.permitAll())
                .   logout(logout -> logout
                        .logoutUrl("/logout") // URL mapping for logout
                        .logoutSuccessUrl("/") // Redirect to home page after logout
                        .invalidateHttpSession(true) // Invalidate session
                        .deleteCookies("JSESSIONID")) // Delete cookies upon logout

                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }



    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        String encodedPassword = passwordEncoder().encode("123");
        UserDetails user = User.withUsername("Sami")
                .password(encodedPassword)
                .roles("USER")
                .build();

        userDetailsService.createUser(user);
        System.out.println(user);
        return userDetailsService;
    }




}
