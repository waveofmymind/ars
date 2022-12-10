package juun.ars.service;

import juun.ars.domain.Problem;
import juun.ars.dto.ProblemRequestDto;
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
    public void registerProblem(Problem problem, ProblemRequestDto registerDto) {
        
    }
}
