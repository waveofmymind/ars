package juun.ars.service;

import juun.ars.domain.Member;
import juun.ars.domain.Problem;
import juun.ars.domain.Review;
import juun.ars.dto.ProblemRequestDto;
import juun.ars.mapper.ReviewMapper;
import juun.ars.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProblemService {

    private final ProblemRepository problemRepository;
    private final ReviewMapper reviewMapper;

    @Transactional(readOnly = true)
    public List<Problem> findProblemByStep(int step)
    {
        return problemRepository.findProblemByStep(step);
    }

    @Transactional(readOnly = true)
    public Problem getProblemById(Long problemId) {
        return problemRepository.findById(problemId).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public long getProblemCount() {
        return problemRepository.count();
    }

    @Transactional
    public Long registerProblem(Problem problem, ProblemRequestDto registerDto) {
        Review review = reviewMapper.toEntity(problem, registerDto);
        problem.setReview(review);
        problemRepository.save(problem);

        return problem.getId();
    }

    @Transactional
    public void updateStep(Long problemId, Member member,int step) {
        Problem updateProblem = checkValidUser(problemId, member);
        problemRepository.save(updateProblem);
    }

    private Problem checkValidUser(Long problemId,Member member) {
        return problemRepository.findProblemByIdAndWriter(problemId,member).orElseThrow(EntityNotFoundException::new);
    }
}
