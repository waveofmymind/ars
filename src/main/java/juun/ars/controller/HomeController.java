package juun.ars.controller;

import juun.ars.domain.Member;
import juun.ars.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;

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
}
