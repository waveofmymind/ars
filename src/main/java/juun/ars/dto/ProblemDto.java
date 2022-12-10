package juun.ars.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import juun.ars.domain.Problem;
import juun.ars.domain.Review;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProblemDto {

    private Long id;

    private String title;

    private String link;

    private int step;

    @JsonIgnoreProperties({"problem"})
    private List<Review> reviewList;

}
