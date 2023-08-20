package springboot.gettingstarted.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails jabbar = User.builder()
                .username("Jabbar")
                .password("{noop}jabbar123")
                .roles("REGULAR")
                .build();

        UserDetails javad = User.builder()
                .username("Javad")
                .password("{noop}javad123")
                .roles("REGULAR", "ELDER")
                .build();

        UserDetails jamil = User.builder()
                .username("Jamil")
                .password("{noop}jamil123")
                .roles("REGULAR", "ELDER", "BOSS")
                .build();

        return new InMemoryUserDetailsManager(jabbar, jamil, javad);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/","/nothome").hasRole("REGULAR")
                        .requestMatchers(HttpMethod.GET,"/leaders/**").hasRole("ELDER")
                        .requestMatchers(HttpMethod.GET,"/systems/**").hasRole("BOSS")
                        .anyRequest().authenticated()
        )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                );
        return http.build();
    }
}
