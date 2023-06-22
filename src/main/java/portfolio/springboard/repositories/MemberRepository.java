package portfolio.springboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import portfolio.springboard.entities.Member;
import portfolio.springboard.entities.QMember;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {

    //아이디로 회원 조회
    Member findByUserId(String userId);

    // 아이디로 회원 존재 유무 체크
        default boolean exists(String userId){

            QMember member = QMember.member;

            return exists(member.userId.eq(userId)); //userId가 일치하는지 확인
    }
}
