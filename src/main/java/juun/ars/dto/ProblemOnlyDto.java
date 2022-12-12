package juun.ars.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProblemOnlyDto {

    private Long id;

    private String title;

    private String link;

    @Builder.Default
    private int step = 1;


}
