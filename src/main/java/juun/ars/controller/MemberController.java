package juun.ars.controller;

import juun.ars.domain.Member;
import juun.ars.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/join")
    public String addMember() {
        return "/member/memberJoinForm";
    }

    @PostMapping("/join")
    public String createMember(@ModelAttribute Member member) {
        memberRepository.save(member);
        return "/member/memberResult";
    }
}
