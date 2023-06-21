package portfolio.springboard.controllers.members;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원가입 양식 데이터
 */

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class JoinForm {

    @NotBlank
    @Size(min = 6, max = 20)
    private String userId;

    @NotBlank
    @Size(min = 8)
    private String userPw;

    @NotBlank
    private String userPwRe;

    @NotBlank
    private String userNm;

    @NotBlank @Email
    private String email;

    private String mobile;

    private boolean[] agrees; //checkbox
}
