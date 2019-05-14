package cafe.jjdev.mall.service;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.jjdev.mall.mapper.MemberMapper;
import cafe.jjdev.mall.vo.Member;
@Service
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	public Member getMember(Member member) {		
		return memberMapper.getLoginMember(member);
	}

	public int addMember(Member member) {
		return memberMapper.addAllMember(member);
	}
	public Member selectMember(String memberId) {
		System.out.println("MemberService selectMember" +memberId);
		return memberMapper.selectGetMember(memberId);
	}
	public int modifyPwMember(Map<String,String> map) {
		System.out.println("MemberService modifyPwMember"+map);		
		return memberMapper.modifyPwMember(map);
	}
	public Member modifyMember(String memberId) {
		return memberMapper.selectGetMember(memberId);
	}	
	public int modifyMember(Member member) {
		return memberMapper.modifyAllMember(member);
	}
	public void removeMember(HttpSession session, Member member) {
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		member.setMemberId(member.getMemberId());
		// 15. member_out_id 테이블 생성 후 탈퇴시 사용ID 저장
		memberMapper.insertMemberOut(loginMember);
		memberMapper.removeAllMember(member);		
		session.invalidate();		
	}
	public Member getId(Member member) {
		System.out.println("MemberService getId" + member);
		return memberMapper.getIdMember(member);
	}
	public boolean getAffirmation(String memberId) {
		boolean check = false;
		if(memberMapper.getAffirmationId(memberId) == null) {
			System.out.println("ID 사용가능");
			check = false;
		}else {
			System.out.println("ID 사용불가능");
			check = true;
		}
		return check;
	}
	public Member findPw(Member member) {		
		return memberMapper.findPwMember(member);
	}
	public String newfindPw(Member member) {		
		return memberMapper.newFindPwMember(member);
	}
}
