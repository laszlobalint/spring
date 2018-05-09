package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class CustomBasicAuthenticationFilter extends BasicAuthenticationFilter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public CustomBasicAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void onSuccessfulAuthentication(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response, final Authentication authResult) {
        Token token = new Token();
        for (hello.User user: userRepository.findAll()) {
            if (user.getName().equals(request.getRemoteUser())) {
                token.setUserId(user.getId());
                token.setExpirationTime();
                token.setTokenString(token.tokenGenerator());
                user.setToken(token);
                response.setHeader("header-name" , token.getTokenString());
            }
        }
    }
}