package com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.config.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration   {


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);

        // Configure the authorization rules
        http.authorizeHttpRequests((authorizationManagerRequestMatcherRegistry) -> {
            // Allow unauthenticated access to specific endpoints
            authorizationManagerRequestMatcherRegistry
                    .requestMatchers("/images/**").permitAll() // Add your public endpoints here
                    .anyRequest().authenticated(); // All other requests require authentication
        });

        // Configure OAuth2 Resource Server with Opaque Tokens (already set in your original code)
        http.oauth2ResourceServer((t -> t.opaqueToken(Customizer.withDefaults())));

        // Configure session management for stateless security
        http.sessionManagement(t -> t.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
