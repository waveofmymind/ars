package juun.ars.controller;

import juun.ars.domain.Problem;
import juun.ars.dto.ProblemDto;
import juun.ars.dto.ProblemOnlyDto;
import juun.ars.dto.ProblemRequestDto;
import juun.ars.mapper.ProblemMapper;
import juun.ars.repository.ProblemRepository;
import juun.ars.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/problem")
public class ProblemController {

    private final ProblemService problemService;

    private final ProblemMapper problemMapper;

    @GetMapping("/register")
    public String addProblem() {
        return "/problem/problemRegister";
    }
    @PostMapping("/register")
    public String registerProblem(@ModelAttribute ProblemDto problemDto) {


        return "redirect:/";
    }
}
