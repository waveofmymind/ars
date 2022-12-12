package juun.ars.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    private String provider;
    private String providerId;


    private String role;

    @Builder
    public Member(String username, String password, String email, String role, String provider, String providerId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }

    public Member update(String username){
        this.username = username;
        return this;
    }

}
