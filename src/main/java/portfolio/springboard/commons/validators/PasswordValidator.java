package portfolio.springboard.commons.validators;

//비밀번호 복잡성 세분화 구현
public interface PasswordValidator {

    /**
     * 비밀번호 복잡성 체크 -> 알파벳 체크
     * @param password
     * @param caseIncentive
     *          false : 소문자 + 대문자가 반드시 포함
     *          true : 대소문자 상관없이 포함되는 패턴
     * @return
     */
    default boolean alphaCheck(String password, boolean caseIncentive){ //caseIncentive 대소문자 구뷴하지 않음

        if(caseIncentive){
            return password.matches("[a-zA-Z]+");
        }
        return password.matches("[a-z]+") && password.matches("[A-Z]+");
    }

    /**
     * 비밀번호 복잡성 체크 -> 숫자 포함 여부 확인
     * @param password
     * @return
     */
    default  boolean numberCheck(String password){
        return password.matches("\\d");
    }


    /**
     * 비밀번호 복잡성 체크 -> 특수문자 포함 여부 확인
     * @param password
     * @return
     */
    default  boolean specialCharCheck(String password){
        return password.matches("[~!@#$%^&*()-_+=]+");
    }
}
