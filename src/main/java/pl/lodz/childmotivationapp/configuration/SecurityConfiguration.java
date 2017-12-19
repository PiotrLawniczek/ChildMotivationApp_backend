package pl.lodz.childmotivationapp.configuration;

/**
 * Created by elawpio on 2017-12-17.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Resource(name="myUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN","USER");
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

       /* http.authorizeRequests()

                .antMatchers("/home").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .and().formLogin().loginPage("/login").permitAll()
                .usernameParameter("login").passwordParameter("password")
                .and().exceptionHandling().accessDeniedPage("/accessDenied");*/
        http.authorizeRequests()

                .antMatchers("/home").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')");
    }
}