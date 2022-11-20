package model.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Qna;
import model.Review;

// 게시글번호, 날짜 까지 구현
// 페이지 계산 함수 검토 필요
// create의 customerId, productId 가져오기 필요
// 조회수, 댓글 구현 필요

public class PostDAO {
	private JDBCUtil jdbcUtil = null;
	
	public PostDAO() {			
		jdbcUtil = new JDBCUtil();
	}
		
	// Qna 게시글 작성
	public int createQna(Qna qna) throws SQLException {
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

	// Review 게시글 작성
	public int createReview(Review review) throws SQLException {
		int maxnum = 1;
		String sql = "SELECT MAX(reviewId) FROM review";
		
		try {	
			int rs = jdbcUtil.executeUpdate();
			if(rs.next())
				maxnum = rs.getInt(1);
			rs.close();
			
			String sql = "INSERT INTO review VALUES (?, ?, ?, ?, ?, ?, ?, ?)";		
			Object[] param = new Object[] {(maxnum+1), review.CustomerId, review.getProductId(), review.getTitle(), 
											review.getContent(), SYSDATE(), 0, review.getRate()};				
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
	public int updateQna(Qna qna) throws SQLException {
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
	
	// Review 게시글 수정
	public int updateReview(Review review) throws SQLException {
		String sql = "UPDATE review "
					+ "SET customerId=?, productId=?, title=?, content=?, creationDate=?, viewCount=?, rate=? "
					+ "WHERE reviewId=?";
		Object[] param = new Object[] {review.getCustomerId(), review.getProductId(), review.getTitle(), review.getContent(), 
										review.getCreationDate(), review.getViewCount(), review.getRate(), review.getReviewId()};				
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
	public int removeQna(String qnaId) throws SQLException {
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

	// Review 게시글 삭제
	public int removeReview(String reviewId) throws SQLException {
		String sql = "DELETE FROM review WHERE reviewId=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {reviewId});
		
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
	public Qna findQna(String qnaId) throws SQLException {
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
	
	// Review 게시글 상세 조회
	public Review findReview(String reviewId) throws SQLException {
        String sql = "SELECT * FROM review WHERE reviewId=?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {reviewId});

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				Review review = new Review(
					rs.getInt("productId"),
					rs.getInt("rate"),
					rs.getString("title"),
					rs.getString("customerId"),
					rs.getDate("creationDate")),
					rs.getInt("viewCount")),
					rs.getString("content"),					
				return review;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	// Qna 게시물 목록 조회 - 테이블 전체를 List로 반환
	public List<Qna> findQnaList() throws SQLException {
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
	
	// Review 게시물 목록 조회 - 테이블 전체를 List로 반환
	public List<Review> findReviewList() throws SQLException {
        String sql = "SELECT * FROM review ORDER BY reviewId";
		jdbcUtil.setSqlAndParameters(sql, null);
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<Review> reviewList = new ArrayList<Review>();
			while (rs.next()) {
				Review review = new Review(
					reviewId,
					rs.getString("title"),
					rs.getString("customerId"),				
					rs.getDate("creationDate")),
					rs.getInt("viewCount")),
				reviewList.add(review);
			}		
			return reviewList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	// Qna 게시물 목록 조회 - 테이블 전체를 List로 반환 (현재 페이지, 페이지당 출력할 사용자 수)
	public List<Qna> findQnaList(int currentPage, int countPerPage) throws SQLException {
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
	
	// Review 게시물 목록 조회 - 테이블 전체를 List로 반환 (현재 페이지, 페이지당 출력할 사용자 수)
	public List<Review> findReviewList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT * FROM review ORDER BY reviewId";
		jdbcUtil.setSqlAndParameters(sql, null, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			int start = ((currentPage-1) * countPerPage) + 1;
			
			if ((start >= 0) && rs.absolute(start)) {
				List<Review> reviewList = new ArrayList<Review>();
				
				do {
					Review review = new Review(
						reviewId,
						rs.getString("title"),
						rs.getString("customerId"),				
						rs.getDate("creationDate")),
						rs.getInt("viewCount")),
					reviewList.add(review);
				} while ((rs.next()) && (--countPerPage > 0));		
				
				return reviewList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
}
