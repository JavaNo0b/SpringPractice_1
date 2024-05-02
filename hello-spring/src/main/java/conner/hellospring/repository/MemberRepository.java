package conner.hellospring.repository;

import conner.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //null처리를 위한 Optional
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
