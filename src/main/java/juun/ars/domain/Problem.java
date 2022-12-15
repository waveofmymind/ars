package juun.ars.domain;

import lombok.*;

import javax.persistence.*;

@Table(name="problem")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class Problem extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id")
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member writer;

    private String link;

    private int step;

}
