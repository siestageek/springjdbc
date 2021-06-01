package siestageek.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siestageek.spring.vo.SungJuk;

@Repository("sjdao02")
public class SungJukDAO02Impl implements SungJukDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertSungJuk(SungJuk sj) {
		int cnt = sqlSession.insert("sungjuk.insertSungjuk", sj);
		
		if (cnt > 0) System.out.println("회원 등록 성공!");
	}

	@Override
	public List<SungJuk> selectAllSungJuk() {
		return null;
	}
	
	@Override
	public SungJuk selectOneSungJuk(int sjno) {
		return null;
	}
	
		
	@Override
	public void updateSungJuk(SungJuk sj) {
		
	}

	
	@Override
	public void deleteSungJuk(int sjno) {
		
	}
	

}





