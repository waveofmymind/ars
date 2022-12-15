package juun.ars.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="member")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String email;



}
