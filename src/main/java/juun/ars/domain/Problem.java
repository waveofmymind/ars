package juun.ars.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

@Entity
@Getter
@Setter
@Table(name = "problem")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Problem extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member writer; // 해결한 사람

    private String title; // 문제 이름

    private String link; // 문제 링크

    private int step;

    @Builder.Default
    @OrderBy("createdDate desc")
    @OneToMany(mappedBy = "problem", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    public void setReview(Review review) {
        this.reviewList = singletonList(review);
    }

    public void updateStep(int step) {
        this.step = step;
    }




}
