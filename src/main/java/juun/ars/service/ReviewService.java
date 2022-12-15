package juun.ars.service;

import juun.ars.domain.Member;
import juun.ars.domain.Problem;
import juun.ars.domain.Review;
import juun.ars.repository.ProblemRepository;
import juun.ars.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProblemRepository problemRepository;

    public Long registerReview(Long problemId, Review review) {
        Problem problem = problemRepository.findById(problemId).orElseThrow(EntityNotFoundException::new);
        problemRepository.save(problem);
        review.setProblem(problem);
        reviewRepository.save(review);
        return review.getId();
    }
}
