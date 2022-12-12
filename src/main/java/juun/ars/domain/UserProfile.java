package juun.ars.domain;

import lombok.Getter;

@Getter
public class UserProfile {
    private final String oauthId;
    private final String username;
    private final String email;


    public UserProfile(String oauthId, String username, String email) {
        this.oauthId = oauthId;
        this.username = username;
        this.email = email;
    }

    public Member toMember() {
        return new Member(oauthId, username, email,Role.USER);
    }

    public String getOauthId() {
        return oauthId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
