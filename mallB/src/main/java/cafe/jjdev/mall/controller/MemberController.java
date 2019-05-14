package cafe.jjdev.mall.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.mall.service.MemberService;
import cafe.jjdev.mall.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private JavaMailSender emailSender;
	// 1. 로그인 폼
	@GetMapping(value="/member/login")
	public String getMember(HttpSession session) {
		//session에 주입
		if(session.getAttribute("loginMember") != null) {
			return "redirect:/";
		}else {
			
		}
		return "/member/login";
	}
	// 2. 로그인 액션
	@PostMapping(value="/member/login")
	public String getMember(HttpSession session, Member member) {
		Member loginMember = memberService.getMember(member);
		
		if(loginMember == null) {
			return "redirect:/member/login";
		}else {
			session.setAttribute("loginMember", loginMember);
			return "redirect:/";
		}
	}
	// 3. 로그아웃
	@GetMapping(value="/member/logout")
	public String logout(HttpSession session) {
		session.invalidate();		
		return "redirect:/";
		
	}
	// 4. 회원가입 폼 Get AddMember
	@GetMapping(value="/member/addMember")
	public String addMember() {
		
		return "/member/addMember";
	}
	// 5. 회원가입 액션 Post AddMember
	@PostMapping(value="/member/addMember")
	public String addMember(Member member) {		
		memberService.addMember(member);	
		return "redirect:/";
	}
	// 6. 개인정보확인 session말고 db정보 상세보기
	@GetMapping(value="/member/selectMember")
	public String selectMember(Model model, HttpSession session) {
		Member loginMember = (Member) session.getAttribute("loginMember");
		System.out.println(loginMember);
		Member dbmember = memberService.selectMember(loginMember.getMemberId());
		System.out.println("MemberController" + dbmember);
		model.addAttribute("dbmember", dbmember);
		
		return "/member/selectMember";
	}	
	// 7. 비밀번호 수정 폼
	@GetMapping(value="/member/modifyPwMember")
	public String modifyPwMember() {		
		return "/member/modifyPwMember";
	}
	// 8. 비밀번호 수정 액션
	// 이전비밀번호/ 새로운비밀번호 / 세션에담겨있는 아이디값
	@PostMapping(value="/member/modifyPwMember")
	public String modifyPwMember(Member member, @RequestParam(value="memberNewPw", required = true) String memberNewPw, HttpSession session) {
		//아이디값
		Member loginMember = (Member) session.getAttribute("loginMember");		
		System.out.println(loginMember +"loginMember");
		Map<String,String> map = new HashMap<String,String>();
		//틀림
		map.put("memberNewPw", memberNewPw);
		map.put("memberId", loginMember.getMemberId());
		map.put("memberPw", member.getMemberPw());
		//틀림끝
		System.out.println("modifyPwMember" +memberNewPw);
		System.out.println("modifyPwMember" + loginMember.getMemberId());
		System.out.println("modifyPwMember" + member.getMemberPw());
		memberService.modifyPwMember(map);
		return "redirect:/member/selectMember";
	}
	
	// 9. 회원정보 수정 폼
	@GetMapping(value="/member/modifyMember")
	public String modifyMember(Model model, HttpSession session) {
		Member loginMember = (Member) session.getAttribute("loginMember");
		System.out.println(loginMember);
		Member dbmember = memberService.modifyMember(loginMember.getMemberId());
		System.out.println("MemberController" + dbmember);
		model.addAttribute("dbmember", dbmember);
		return "/member/modifyMember";
	}
	// 10. 회원정보 수정 액션
	@PostMapping(value="/member/modifyMember")
	public String modifyMember(Member member) {
		memberService.modifyMember(member);		
		return "redirect:/member/selectMember";
	}	
	// 11. 회원탈퇴 폼  MemberController.removeMember -> removeMember.jsp
	@GetMapping(value="/member/removeMember")
	public String removeMember() {		
		
		return "/member/removeMember";
	}
	//12. 회원탈퇴 액션 MemberController.removeMember -> MemberService.removeMember.jsp ->
	@PostMapping(value="/member/removeMember")
	public String removeMember(HttpSession session, Member member) {
		// 15. member_out_id 테이블 생성 후 탈퇴시 사용ID 저장
		memberService.removeMember(session, member);		
		return "redirect:/";
	}	
	// 팀플
	// 13. 아이디 찾기 폼
	@GetMapping(value="/member/loginId")
	public String getId() {				
		return "/member/loginId";		
	}
	// 14. 아이디 찾기 액션
	@PostMapping(value="/member/loginId")
	public String getId(Model model,Member member) {
		Member loginId = memberService.getId(member);
		System.out.println("MemberController.java"+member);
		System.out.println("MemberController.java"+loginId);
		model.addAttribute("loginId", loginId);
		return "/member/loginId";
	}
	// 15. 아이디 중복확인 폼
	@GetMapping(value="/member/getAffirmation")
	public String getAffirmation() {
		return "/member/getAffirmation";
	}
	// 16. 아이디 중복확인 액션
	@PostMapping(value="/member/getAffirmation")
	public String getAffirmation(Model model, Member member) {
		boolean check = memberService.getAffirmation(member.getMemberId());
		System.out.println("MemberController getAffirmation check" + check);
		System.out.println("MemberController getAffirmation " + member.getMemberId());		
		model.addAttribute("check", check);
		return "/member/getAffirmation";
	}
	// 17. 비밀번호 찾기 폼
	@GetMapping(value="/member/findPw")
	public String findPw() {
		return "/member/findPw";
	}
	// 18. 비밀번호 찾기 액션
	@PostMapping(value="/member/findPw")
	public String findPw(Member member) {
		 
		SimpleMailMessage message = new SimpleMailMessage(); 
			Member pwEmail = memberService.findPw(member); 
			String email = pwEmail.getMemberEmail();
			String newPw = memberService.newfindPw(member); 
			String subject = "비밀번호 발송합니다.";
			String text = "비밀번호는" + newPw + "입니다.";
			message.setTo(email); 
			message.setSubject(subject); 
			message.setText(text);
			emailSender.send(message);
		return "/member/findPw";
	}
	
	
	
}
