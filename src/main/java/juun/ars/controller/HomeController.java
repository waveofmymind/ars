package juun.ars.controller;

import juun.ars.domain.Member;
import juun.ars.domain.Problem;
import juun.ars.domain.Review;
import juun.ars.service.MemberService;
import juun.ars.service.ProblemService;
import juun.ars.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;
    private final ProblemService problemService;
    private final ReviewService reviewService;

    @RequestMapping("/")
    public String home() {
        log.info("home controller");
        return "home";
    }

    @GetMapping("/members/new")
    public String add() {
        return "/member/memberJoinForm";
    }

    @PostMapping("/members/new")
    public String addMember(@ModelAttribute Member member) {
        memberService.joinMember(member);
        return "/member/memberResult";
    }

    @GetMapping("/problems/new")
    public String addProblem() {
        return "/problem/problemRegister";
    }

    @PostMapping("/problems/new")
    public String registerProblem(@ModelAttribute Problem problem) {
        problemService.registerProblem(problem);
        return "/home";
    }

    @GetMapping("/problems")
    public String problemList(Model model) {
        List<Problem> problems = problemService.findAll();
        model.addAttribute("problems",problems);
        return "/problem/problemList";
    }

    @GetMapping("/reviews/new")
    public String addReview() {
        return "/review/reviewAddForm";
    }

    @PostMapping("/reviews/new")
    public String createReview(@ModelAttribute Review review) {
        reviewService.addReview(review);
        return "/home";
    }




}
