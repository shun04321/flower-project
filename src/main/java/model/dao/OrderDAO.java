package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;

public class OrderDAO {
   private JDBCUtil jdbcUtil = null;
   
   public OrderDAO() {
      jdbcUtil = new JDBCUtil();
   }
   
   //주문 목록 조회
   public List<Order> findOrderList() throws SQLException{
      String query = "select * from orderlist order by customerId";
      jdbcUtil.setSqlAndParameters(query, null);
      
      try {
         ResultSet rs = jdbcUtil.executeQuery();
         List<Order> orderList = new ArrayList<Order>();
         
         while(rs.next()) {
            Order order = new Order(
                  rs.getString("orderId"),
                  rs.getString("productId"),
                  rs.getInt("quantity"),
                  rs.getInt("price"));
            orderList.add(order);
         }
         return orderList;
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         jdbcUtil.close();
      }
      return null;
   }
   
   //주문자 정보 입력
   public int ConsumerInfo (ConsumerInfo consumerInfo) throws SQLException{
      int result = 0;
      String query = "insert into consumer(name, phone, email, address) value(”?”,”?”,”?”,”?”)";
      
      Object[] param = new Object[] { consumerInfo.getName(),consumerInfo.getPhone(),consumerInfo.getEmail(),consumerInfo.getAddress(),  };      
      jdbcUtil.setSqlAndParameters(query, param);   
      
      try {
         result = jdbcUtil.executeUpdate();
         return result;
      } catch(Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      } finally {
         jdbcUtil.commit();
         jdbcUtil.close();
      }
      return result;
   }
   
   //배송 정보 입력
   public int DeliverInfo (DeliverInfo deliverInfo) throws SQLException{
      int result = 0;
      String query = "insert into consumer(name, phone, email, address) value(”?”,”?”,”?”,”?”)";
      
      Object[] param = new Object[] { deliverInfo.getName(),deliverInfo.getPhone(),deliverInfo.getEmail(),deliverInfo.getAddress(),  };      
      jdbcUtil.setSqlAndParameters(query, param);   
      
      try {
         result = jdbcUtil.executeUpdate();
         return result;
      } catch(Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      } finally {
         jdbcUtil.commit();
         jdbcUtil.close();
      }
      return result;
   }
   
   //상품 예약 정보 입력
   public int ReservationInfo (ReservationInfo resInfo) throws SQLException{
      int result = 0;
      String query = "insert into consumer(name, phone, date, memo) value(”?”,”?”,”?”,”?”)";
      
      Object[] param = new Object[] { resInfo.getName(),resInfo.getPhone(),resInfo.getDate(),resInfo.getMemo(),  };      
      jdbcUtil.setSqlAndParameters(query, param);   
      
      try {
         result = jdbcUtil.executeUpdate();
         return result;
      } catch(Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      } finally {
         jdbcUtil.commit();
         jdbcUtil.close();
      }
      return result;
   }

}


