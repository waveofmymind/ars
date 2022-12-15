package juun.ars.repository;


import juun.ars.domain.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


public interface ProblemRepository extends JpaRepository<Problem,Long> {


}
