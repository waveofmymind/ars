package juun.ars.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="problem")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Problem {

    @Id @GeneratedValue
    private Long id;

    private Long title;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member writer;

    private String link;

    private int step;
}
