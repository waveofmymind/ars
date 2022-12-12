package juun.ars.service;

import juun.ars.domain.Member;
import juun.ars.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Optional<Member> findMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Transactional
    public Long saveMember(Member member) {
        return memberRepository.save(member).getId();
    }

    @Transactional
    public Long joinUserWithMember(Member member) {
        return memberRepository.save(member).getId();
    }
}
