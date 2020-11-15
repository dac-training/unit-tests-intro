package pl.infoshare.junit5.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * UWAGA! Ta konfiguracja oraz pochodne komponenty tj. filtry powstały jedynie w celu zaprezentowania konkretnych
 * testowych przypadków i nie powinna być w żadnym wypadku brane za wzór w jaki sposób implementować warstwę Security w Springu.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CurrendaSecurityFilter currendaSecurityFilter;

    public SecurityConfiguration(CurrendaSecurityFilter currendaSecurityFilter) {
        this.currendaSecurityFilter = currendaSecurityFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(currendaSecurityFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/**").authenticated();
    }
}
