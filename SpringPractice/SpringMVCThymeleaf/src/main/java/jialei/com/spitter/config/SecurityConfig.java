package jialei.com.spitter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("123456").roles("USER").and()
                .withUser("admin").password("123456").roles("USER", "ADMIN");


//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select username, password, true from Spitter where username=?")
//                .authoritiesByUsernameQuery("select username, 'ROLE_USER' from Spitter where username=?")
//        .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
//        auth.userDetailsService();

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin()
                //指定登录页的路径
                .loginPage("/login")
//                .failureUrl("/login?error")
//                .defaultSuccessUrl("/success")
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .authorizeRequests()
                .antMatchers("/spittles").authenticated()
                //.antMatchers("/spittles").authenticated()
                .antMatchers("/spitter/me").authenticated()
                //.antMatchers(HttpMethod.POST, "/spittles").authenticated()
                .anyRequest().permitAll()
                .and()
                .requiresChannel()
                .antMatchers("/spittles")
                .requiresSecure()
                .and()
                .rememberMe()
        ;
    }
}
