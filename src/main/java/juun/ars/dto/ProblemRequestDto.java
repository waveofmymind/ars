package juun.ars.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProblemRequestDto {

    private String title;

    private String link;

    private int step = 1;

    private String content;
}
