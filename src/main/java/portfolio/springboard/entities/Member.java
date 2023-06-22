package portfolio.springboard.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Table(indexes = { //검색이 많은 부분은 index를 통해 따로 관리 할 수 있고, 테이블 당 2개 정도 하는 것이 적절하다.
        @Index(name="idx_member_userNm", columnList = "userNm"),
        @Index(name="idx_member_email", columnList = "email")
})
public class Member extends BaseEntity{

    @Id @GeneratedValue
    private Long userNo; //회원번호

    @Column(length = 40, nullable = false, unique = true)
    private String userId; //아이디

    @Column(length = 65, nullable = false)
    private String userPw; //비밀번호

    @Column(length = 40, nullable = false)
    private String userNm; //회원명

    @Column(length = 100, nullable = false)
    private String email; //이메일 (알림, 비밀번호 초기화)

    @Column(length = 11)
    private String mobile; //전화번호

    @Lob
    private String termsAgree; //약관 동의(약관이 여러 항목일 수 있으므로 JSON형태로 만들어 추가해 사용할 수 있게함)
}
