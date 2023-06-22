package portfolio.springboard.controllers.members;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import portfolio.springboard.models.member.MemberSaveService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberSaveService saveService;
    private final JoinValidator joinValidator;

    @GetMapping("/join")
    public String join(@ModelAttribute JoinForm joinForm, Model model){


        return "/member/join";
    }

    @PostMapping ("/join")
    public String joinPs(@Valid JoinForm joinForm, Errors errors){ //아이디, 이메일 중복 검증

        joinValidator.validate(joinForm, errors); //회원가입 검증

        if(errors.hasErrors()){

            return "member/join";
        }

        saveService.save(joinForm);
        return "redirect:/member/login";
    }
    @GetMapping("/login")
    public String login(){

        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs(){

        return "redirect:/member";
    }
}
