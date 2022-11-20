package model.dao;

import java.sql.SQLException;

public class ReservationDAO {
   private JDBCUtil jdbcUtil = null;
   
   public ReservationDAO() {
      jdbcUtil = new JDBCUtil();
   }
 
   //클래스 예약하기
   public int classReservation(String classId) throws SQLException {
      String query = "select * from class where maxNum ≠ currenNum";
      jdbcUtil.setSqlAndParameters(query, new Object[] {classId});
      
      try {
         
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
   
}