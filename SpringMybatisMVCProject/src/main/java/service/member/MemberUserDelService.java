package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import model.AuthInfo;
import model.MemberDTO;
import repository.MemberRepository;

@Service
public class MemberUserDelService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public String execute(String userPw, Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId(authInfo.getUserId());

		MemberDTO member = memberRepository.selectByMember(memberDTO);
		
		if(bCryptPasswordEncoder.matches(userPw, member.getUserPw())) {
									// 현재입력된 pw, db에 있는 pw
			memberRepository.memberDelete(authInfo.getUserId());
			return "redirect:/login/logout";
		}else {
			model.addAttribute("err", "비밀번호가 틀렸습니다.");
			return "member/userDeletePw";
		}
	}

}
