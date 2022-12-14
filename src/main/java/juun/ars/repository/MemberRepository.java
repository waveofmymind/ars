package juun.ars.repository;

import juun.ars.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findMemberByEmail(String email);



}
