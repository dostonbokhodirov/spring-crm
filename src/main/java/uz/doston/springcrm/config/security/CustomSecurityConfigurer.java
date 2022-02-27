package uz.doston.springcrm.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

import static org.springframework.http.HttpMethod.POST;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomSecurityConfigurer extends WebSecurityConfigurerAdapter {

    public static final String[] WHITE_LIST = {"/auth/login", "/error", "/auth/register","/project/**", "/task/**", "/organization/**"};
    public static final String[] WHITE_LIST_RESOURCE = {"/webjars/**", "/css/**", "/js/**", "/img/**"};

    private int rememberMeTokenExpiryInSeconds;

    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService userDetailsService;

    public CustomSecurityConfigurer(PasswordEncoder passwordEncoder, CustomUserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @PostConstruct
    public void init() {
        this.rememberMeTokenExpiryInSeconds = (int) TimeUnit.DAYS.toSeconds(40);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer
                                .maximumSessions(1)
                                .maxSessionsPreventsLogin(false)
                )
                .authorizeRequests((authorizeRequests) ->
                        authorizeRequests
                                .antMatchers(WHITE_LIST).permitAll()
                                .antMatchers(POST, WHITE_LIST).permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .formLogin((httpSecurityFormLoginConfigurer) ->
                        httpSecurityFormLoginConfigurer
                                .permitAll()
                                .loginPage("/auth/login")
                                .loginProcessingUrl("/auth/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/", false)
                )
                .rememberMe((httpSecurityRememberMeConfigurer) ->
                        httpSecurityRememberMeConfigurer
                                .tokenValiditySeconds(rememberMeTokenExpiryInSeconds)
                                .alwaysRemember(false)
                                .key("!@#!@#W#ERFGSD$T##$%^%^$%$^%^@#$@#$WERREFG$#%")
                                .rememberMeParameter("remember-me"))
                .logout(httpSecurityLogoutConfigurer ->
                        httpSecurityLogoutConfigurer
                                .logoutUrl("/auth/logout")
                                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
                                .clearAuthentication(true)
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID", "remember-me")
                                .logoutSuccessHandler(new LogoutSuccessHandler())
                                .logoutSuccessUrl("/auth/login"));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(WHITE_LIST_RESOURCE);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }
}