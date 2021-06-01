package siestageek.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import siestageek.spring.vo.Member;

@Repository("mdao")
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertMember(Member m) {
		String sql = "insert into member "
			+ " (userid, passwd, name, email) values (?,?,?,?)";

		Object[] params = new Object[] { m.getUserid(),
			m.getPasswd(), m.getName(), m.getEmail() };
		
		int cnt = jdbcTemplate.update(sql, params);
		if (cnt > 0) System.out.println("회원 추가 완료!"); 
	}

	@Override
	public List<Member> selectAllMember() {
		String sql = "select mno, userid, name, joindate "
				+ " from member order by mno desc";
		RowMapper<Member> mapper = new MemberMapper();
		
		return jdbcTemplate.query(sql, mapper);
	}
	
	private class MemberMapper implements RowMapper<Member> {

		@Override
		public Member mapRow(ResultSet rs, int num) throws SQLException {
			String mno = rs.getString("mno");
			String userid = rs.getString("userid");
			String name = rs.getString("name");
			String joindate = 
						rs.getString("joindate").substring(0,10);
			Member m = new Member(
					mno, userid, "", name, "", joindate);			
			
			return m;
		}
		
	}

	@Override
	public Member selectOneMember(int mno) {
		String sql = "select * from member where mno = ?";
		Object[] params = new Object[] { mno }; 
		
		RowMapper<Member> mapper = new MemberOneMapper();
		
		return jdbcTemplate.queryForObject(sql, params, mapper);
	}
	
	private class MemberOneMapper implements RowMapper<Member> {

		@Override
		public Member mapRow(ResultSet rs, int num) throws SQLException {
			
			String mno = rs.getString("mno");
			String userid = rs.getString("userid");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String joindate = rs.getString("joindate");
			
			Member m = new Member(
					mno, userid, "", name, email, joindate);
			
			return m;
		}
		
	}

	@Override
	public void updateMember(Member m) {
		String sql = "update member set passwd = ?, "
				+ " name = ?, email = ? where mno = ? ";
		Object[] params = new Object[] { m.getPasswd(),
			m.getName(), m.getEmail(), m.getMno() };
		
		int cnt = jdbcTemplate.update(sql, params);
		if (cnt > 0) System.out.println("회원수정 완료!");
	}

	@Override
	public void deleteMember(int mno) {
		String sql = "delete from member where mno = ?";
		Object[] params = new Object[] { mno };
		
		int cnt = jdbcTemplate.update(sql, params);
		if (cnt > 0) System.out.println("회원삭제 완료!");
	}

}


