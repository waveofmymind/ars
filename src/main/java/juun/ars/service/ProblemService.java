package juun.ars.service;

import juun.ars.domain.Problem;
import juun.ars.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository problemRepository;

    public Long registerProblem(Problem problem) {
        problem.setStep(1);
        return problemRepository.save(problem).getId();
    }

    public List<Problem> findAll() {
        return problemRepository.findAll();
    }
}
