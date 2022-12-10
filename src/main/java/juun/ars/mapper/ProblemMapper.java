package juun.ars.mapper;

import juun.ars.domain.Member;
import juun.ars.domain.Problem;
import juun.ars.dto.ProblemDto;
import juun.ars.dto.ProblemOnlyDto;
import juun.ars.dto.ProblemRequestDto;
import juun.ars.dto.ReviewRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProblemMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "writer", source = "member")
    @Mapping(target = "reviewList", ignore = true)
    Problem toEntity(ProblemRequestDto requestDto, Member member);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "writer", source = "member")
    @Mapping(target = "link", ignore = true)
    @Mapping(target = "step", ignore = true)
    @Mapping(target = "reviewList", ignore = true)
    @Mapping(target = "title", ignore = true)
    Problem toEntity(Long id, ReviewRequestDto requestDto, Member member);

    ProblemDto toDto(Problem problem);

    ProblemOnlyDto toReviewExcludeDto(Problem problem);


}
