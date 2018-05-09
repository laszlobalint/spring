package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.Date;

public class TokenAuthenticationFilter extends GenericFilterBean {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final String accessToken = httpRequest.getHeader("header-name");
        if (null != accessToken) {
            for (hello.User user : userRepository.findAll()) {
                if (user.getToken().getTokenString().equals(accessToken)) {
                    if (isExpired(user.getToken())) {
                        throw new HTTPException(403);
                    }
                }
            }
        }
        chain.doFilter(request, response);
    }

    public Boolean isExpired(Token token) {
        Long currentTime = new Date().getTime();
        return token.getExpirationTime() > currentTime;

    }
}
