package pl.infoshare.junit5.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import pl.infoshare.junit5.security.user.CurrendaUserRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class CurrendaSecurityFilter extends GenericFilterBean {

    private final CurrendaUserRepository currendaUserRepository;

    public CurrendaSecurityFilter(CurrendaUserRepository currendaUserRepository) {
        this.currendaUserRepository = currendaUserRepository;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var httpServletRequest = (HttpServletRequest) servletRequest;
        var secretTokenHeader = httpServletRequest.getHeader("x-secret-token");

        if (Objects.nonNull(secretTokenHeader)) {
            currendaUserRepository.findBySecret(secretTokenHeader)
                    .map(c -> new User(c.getUsername(), c.getPassword(), List.of(new SimpleGrantedAuthority(c.getRole()))))
                    .map(u -> new UsernamePasswordAuthenticationToken(u, "pass", u.getAuthorities()))
                    .ifPresent(u -> SecurityContextHolder.getContext().setAuthentication(u));
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
