package cafe.jjdev.mall.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.Member;


@Mapper
public interface MemberMapper {
	public Member getLoginMember(Member member);
	public int addAllMember(Member member);
	public Member selectGetMember(String memberId);
	public int modifyPwMember(Map<String,String> map);
	
	public int modifyAllMember(Member member);
	public int removeAllMember(Member member);
	public int insertMemberOut(Member member);
	public Member getIdMember(Member member);
	public Member getAffirmationId(String memberId);
	public Member findPwMember(Member member);
	public String newFindPwMember(Member member);
	
}
