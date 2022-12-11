package juun.ars.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name ="member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Setter
@AllArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    @Column(unique = true)
    private String username; // 닉네임
    @Column
    private String password; // 패스워드
    @Column
    private String email; // 이메일 (소셜 로그인때 필요)


    public Member(String username, String password, String email, List<Problem> problemList, List<Review> reviewList) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Member update(String username) {
        this.username = username;
        return this;
    }
}
