package model.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Qna;

// 게시글번호, 날짜 까지 구현
// 페이지 계산 함수 검토 필요
// create의 customerId, productId 가져오기 필요
// 조회수, 댓글 구현 필요

public class QnaDAO {
	private JDBCUtil jdbcUtil = null;
	
	public QnaDAO() {			
		jdbcUtil = new JDBCUtil();
	}
		
	// Qna 게시글 작성
	public int create(Qna qna) throws SQLException {
		int maxnum = 1;
		String sql = "SELECT MAX(qnaId) FROM qna";
		
		try {	
			int rs = jdbcUtil.executeUpdate();
			if(rs.next())
				maxnum = rs.getInt(1);
			rs.close();
			
			String sql = "INSERT INTO qna VALUES (?, ?, ?, ?, ?, ?, ?, ?)";		
			Object[] param = new Object[] {(maxnum+1), qna.CustomerId, qna.getProductId(), qna.getTitle(), 
											qna.getContent(), SYSDATE(), 0, qna.getPwd()};				
			jdbcUtil.setSqlAndParameters(sql, param);
							
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;			
	}

	// Qna 게시글 수정
	public int update(Qna qna) throws SQLException {
		String sql = "UPDATE qna "
					+ "SET customerId=?, productId=?, title=?, content=?, creationDate=?, viewCount=?, pwd=? "
					+ "WHERE qnaId=?";
		Object[] param = new Object[] {qna.getCustomerId(), qna.getProductId(), qna.getTitle(), qna.getContent(), 
										qna.getCreationDate(), qna.getViewCount(), qna.getPwd(), qna.getQnaId()};				
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;
	}
	
	// Qna 게시글 삭제
	public int remove(String qnaId) throws SQLException {
		String sql = "DELETE FROM qna WHERE qnaId=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {qnaId});
		
		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;
	}

	// Qna 게시글 상세 조회
	public Qna findPost(String qnaId) throws SQLException {
        String sql = "SELECT * FROM qna WHERE qnaId=?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {qnaId});

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				Qna qna = new Qna(
					rs.getInt("productId"),
					rs.getString("title"),
					rs.getString("customerId"),
					rs.getDate("creationDate")),
					rs.getInt("viewCount")),
					rs.getString("content"),					
				return qna;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	// Qna 게시물 목록 조회 - qna 테이블 전체를 List로 반환하는 함수
	public List<Qna> findPostList() throws SQLException {
        String sql = "SELECT * FROM qna ORDER BY qnaId";
		jdbcUtil.setSqlAndParameters(sql, null);
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<Qna> qnaList = new ArrayList<Qna>();
			while (rs.next()) {
				Qna qna = new Qna(
					qnaId,
					rs.getString("title"),
					rs.getString("customerId"),				
					rs.getDate("creationDate")),
					rs.getInt("viewCount")),
				qnaList.add(qna);
			}		
			return qnaList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	// Qna 게시물 목록 조회 - Qna 테이블 전체를 List로 반환하는 함수 (현재 페이지, 페이지당 출력할 사용자 수)
	public List<Qna> findPostList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT * FROM qna ORDER BY qnaId";
		jdbcUtil.setSqlAndParameters(sql, null, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			int start = ((currentPage-1) * countPerPage) + 1;
			
			if ((start >= 0) && rs.absolute(start)) {
				List<Qna> qnaList = new ArrayList<Qna>();
				
				do {
					Qna qna = new Qna(
						qnaId,
						rs.getString("title"),
						rs.getString("customerId"),				
						rs.getDate("creationDate")),
						rs.getInt("viewCount")),
					qnaList.add(qna);
				} while ((rs.next()) && (--countPerPage > 0));		
				
				return qnaList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
}
