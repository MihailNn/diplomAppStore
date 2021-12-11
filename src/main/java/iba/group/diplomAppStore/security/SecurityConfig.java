package iba.group.diplomAppStore.security;

import iba.group.diplomAppStore.domain.User;
import iba.group.diplomAppStore.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//@Configuration аннотация указывает Spring, что это класс конфигурации, который будет предоставлять компоненты для контекста приложения Spring.
//        Методы класса конфигурации снабжены аннотациями @Bean, указывающими, что возвращаемые ими объекты должны быть добавлены в качестве компонентов в контексте приложения (где по умолчанию их соответствующие компонентам ID будут совпадать с именами методов, которые их определяют).
@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //the UserDetailsService interface defines only a single loadUserByUsername() method.
    // That means it is a functional interface and can be implemented as a lambda
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            if (user != null) return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests() //The call to authorizeRequests() returns an object ( ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry) on which you can specify URL paths and patterns and the security requirements for those paths
                  .antMatchers("/cart", "/catalog").hasRole("USER")//Requests for /cart and /catalog should be for users with a granted authority of ROLE_USER. Don’t include the "ROLE_" prefix on roles passed to hasRole(); it will be assumed by hasRole()
                  .antMatchers("/", "/**").permitAll()
//                  .antMatchers("/h2-console/**").permitAll()

                .and()
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()
                  .formLogin()//formLogin() to start configuring your custom login form
                    .loginPage("/login")
                    .defaultSuccessUrl("/catalog")

                .and()
                  .logout()
                    .logoutSuccessUrl("/")

                .and()
                 .build();
    }

}
