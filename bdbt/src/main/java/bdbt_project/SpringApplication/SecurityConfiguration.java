package bdbt_project.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("KIEROWNIK PRODUKCJI REKLAMOWEJ")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN")
                .and()
                .withUser("KierownikProdukcjiReklamowej")
                .password("client")
                .roles("CLIENT");


    }

    @Bean
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/main").authenticated()
                .antMatchers("/main_admin").access("hasRole('ADMIN')")
                .antMatchers("/data_admin").access("hasRole('ADMIN')")
                .antMatchers("/main_user").access("hasRole('USER')")
                .antMatchers("/data_user").access("hasRole('USER')")
                .antMatchers("/main_client").access("hasRole('CLIENT')")
                .antMatchers("/data_client").access("hasRole('CLIENT')")

                .antMatchers("/update/klienci").access("hasRole('ADMIN')")
                .antMatchers("/update/pracownicy").access("hasRole('ADMIN')")
                .antMatchers("/update/producenci").access("hasRole('ADMIN')")
                .antMatchers("/update/reklamy").access("hasRole('ADMIN' or 'USER')")
                .antMatchers("update/stacje").access("hasRole('ADMIN')")

                .antMatchers("/save_klienci").access("hasRole('ADMIN')")
                .antMatchers("/save_pracownicy").access("hasRole('ADMIN')")
                .antMatchers("/save_producenci").access("hasRole('ADMIN')")
                .antMatchers("/save_reklamy").access("hasRole('ADMIN' or 'USER')")
                .antMatchers("/save_stacje").access("hasRole('ADMIN')")

                .antMatchers("/delete/klienci/{id}").access("hasRole('ADMIN')")
                .antMatchers("/delete/pracownicy/{id}").access("hasRole('ADMIN')")
                .antMatchers("/delete/producenci/{id}").access("hasRole('ADMIN')")
                .antMatchers("/delete/reklamy/{id}").access("hasRole('ADMIN' or 'USER')")
                .antMatchers("/delete/stacje/{id}").access("hasRole('ADMIN')")


                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/index")
                .logoutSuccessUrl("/index")
                .permitAll();
    }
}