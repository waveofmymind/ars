package juun.ars.service;

import juun.ars.domain.Member;
import juun.ars.domain.Problem;
import juun.ars.domain.Review;
import juun.ars.dto.ReviewRequestDto;
import juun.ars.mapper.ReviewMapper;
import juun.ars.repository.ProblemRepository;
import juun.ars.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final ProblemRepository problemRepository;

    @Transactional
    public void registerReview(Long problemId, ReviewRequestDto registerDto, Member member) {
        Problem problem = problemRepository.findById(problemId).orElseThrow(EntityNotFoundException::new);
        problemRepository.save(problem);
        reviewRepository.save(reviewMapper.toEntity(problem,registerDto));
    }

    @Transactional
    public void updateReview(Long reviewId, Review review, Member member) {
        checkValidUser(reviewId,member);
    }

    @Transactional
    public void deleteReview(Long reviewId, Member member) {
        checkValidUser(reviewId, member);
        reviewRepository.deleteById(reviewId);
    }

    @Transactional(readOnly = true)
    public Review getReview(Long reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow(EntityNotFoundException::new);
    }

    private void checkValidUser(Long reviewId,Member member) {
        reviewRepository.findReviewByIdAndMemberId(reviewId,member.getId()).orElseThrow(EntityNotFoundException::new);
    }




}
