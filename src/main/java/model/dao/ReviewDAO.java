package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Review;

public class ReviewDAO {
	private JDBCUtil jdbcUtil = null;
	
	public ReviewDAO() {			
		jdbcUtil = new JDBCUtil();
	}
		
	// Review 게시글 작성
	public int create(Review review) throws SQLException {
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

	// Review 게시글 수정
	public int update(Review review) throws SQLException {
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
	
	// Review 게시글 삭제
	public int remove(String reviewId) throws SQLException {
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

	// Review 게시글 상세 조회
	public Review findPost(String reviewId) throws SQLException {
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

	// Review 게시물 목록 조회 - review 테이블 전체를 List로 반환하는 함수
	public List<Review> findPostList() throws SQLException {
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
	
	// Review 게시물 목록 조회 - review 테이블 전체를 List로 반환하는 함수 (현재 페이지, 페이지당 출력할 사용자 수)
	public List<Review> findPostList(int currentPage, int countPerPage) throws SQLException {
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
