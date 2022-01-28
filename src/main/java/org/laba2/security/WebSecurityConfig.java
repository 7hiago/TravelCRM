package org.laba2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(@Qualifier("userdatails") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

//    private final ManagerService managerService;
//
//    @Autowired
//    public WebSecurityConfig(@Qualifier("managerService") ManagerService managerService) {
//        this.managerService = managerService;
//    }
//
//    public List<UserDetails> userList = new ArrayList<>();
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        userList.add(User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build());
//        userList.add(User.builder().username("user").password(passwordEncoder().encode("user")).roles("USER").build());
//        for(Manager manager : managerService.getAvailableManagers()) {
//            userList.add(User.builder().username(manager.getLogin()).password(passwordEncoder().encode(manager.getPassword())).roles("MANAGER").build());
//        }
//        return new InMemoryUserDetailsManager(userList);
//    }


//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//                User.builder()
//                        .username("admin")
//                        .password(passwordEncoder().encode("admin"))
//                        .roles("ADMIN") // можно роль
//                        .authorities(Role.ADMIN.getAuthorities()) // можно права
//                        .build(),
//                User.builder()
//                        .username("manager")
//                        .password(passwordEncoder().encode("manager"))
//                        .roles("MANAGER")
//                        .authorities(Role.MANAGER.getAuthorities())
//                        .build()
//        );
//    }


    @Bean
    protected PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder(12);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                    .antMatchers("/", "/index").authenticated()
//                    .antMatchers("/createOrder").authenticated()
//                    .and()
//                .formLogin()
//                    .and()
//                .logout()
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/managers").hasAnyRole("ADMIN")
//                .antMatchers("/").hasAuthority(Permission.DELETE.getPermission())
//                .antMatchers(HttpMethod.GET, "/api/**").hasRole(Role.ADMIN.name())
//                .antMatchers(HttpMethod.POST, "/api/**").hasAnyRole(Role.ADMIN.name(), Role.MANAGER.name())
//                .antMatchers(HttpMethod.PATCH, "/api/**").hasRole(Role.ADMIN.name())
//                .antMatchers(HttpMethod.DELETE, "/api/**").hasAuthority(Permission.DELETE.getPermission()) можна давать права, можна роли
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/menuPage")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

}
