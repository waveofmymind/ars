package juun.ars.service;

import juun.ars.domain.Member;
import juun.ars.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long joinMember(Member member) {
        return memberRepository.save(member).getId();
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
