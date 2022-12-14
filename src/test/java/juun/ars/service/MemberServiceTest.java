package juun.ars.service;

import juun.ars.domain.Member;
import juun.ars.domain.Problem;
import juun.ars.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
class MemberServiceTest {

    @Autowired
    public MemberService memberService;
    @Autowired
    public MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setEmail("sjun0913@gmail.com");
        member.setUsername("waveofmymind");
        Problem problem = new Problem();
        problem.setWriter(member);
        problem.setLink("link");
        problem.setTitle("토마토");
        //when

        Assertions.assertThat(member).isEqualTo(problem.getWriter());
        Assertions.assertThat(member.getEmail()).isEqualTo(problem.getWriter().getEmail());



        //then
    }

}