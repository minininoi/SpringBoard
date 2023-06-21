package portfolio.springboard.models.member;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import portfolio.springboard.controllers.members.JoinForm;
import portfolio.springboard.entities.Member;
import portfolio.springboard.repositories.MemberRepository;

/**
 * 회원 정보 추가 & 수정
 * 수정시, 비밀번호 값이 있을때만 수정이 가능
 */
@Service
@RequiredArgsConstructor
public class MemberSaveService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder; //비밀번호 해시화

    public void save(JoinForm joinForm){
        Member member = new ModelMapper().map(joinForm,Member.class);
        member.setUserPw(passwordEncoder.encode(joinForm.getUserPw()));

        memberRepository.saveAndFlush(member);
    }

}
