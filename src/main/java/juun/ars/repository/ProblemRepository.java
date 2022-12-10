package juun.ars.repository;

import juun.ars.domain.Member;
import juun.ars.domain.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProblemRepository extends JpaRepository<Problem,Long> {

    Optional<Problem> findProblemByIdAndWriter(Long id, Member writer);

    void deleteProblemById(Long id);

    List<Problem> findProblemByStep(int step);
}
