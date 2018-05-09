package hello;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class Token {
    private Long userId;
    private String tokenString;
    private Long expirationTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTokenString() {
        return tokenString;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime() {
        this.expirationTime = new Date().getTime() + 120000;
    }

    public String tokenGenerator() {
        return "yolo" + new Date().getTime() + "hadada";
    }
}
