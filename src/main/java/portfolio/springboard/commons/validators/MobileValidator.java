package portfolio.springboard.commons.validators;

public interface MobileValidator {
    default boolean mobileNumCheck(String mobile){
        /**
         * 010 0000 0000
         * 010-0000-0000
         * 010_0000_0000
         * => 1.문자 제거를 통해 전화번호 형식 통일화
         *    2.패턴 생성 체크
         */

        mobile = mobile.replaceAll("\\D", ""); //문자 제거
        String pattern = "^01[016]\\d{3,4}\\d{4}$";
        return mobile.matches(pattern);
    }
}
