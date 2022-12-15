package juun.ars.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name ="review")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class Review extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    private Problem problem;


}
