package siestageek.spring.dao;

import java.util.List;

import siestageek.spring.vo.Member;

public interface MemberDAO {
	void insertMember(Member m);
	List<Member> selectAllMember();
	Member selectOneMember(int mno);
	void updateMember(Member m);
	void deleteMember(int mno);
}
