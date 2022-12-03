package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LineItem;
import model.Orders;
import model.Product;

public class OrderDAO {
   private JDBCUtil jdbcUtil = null;
   
   public OrderDAO() {
      jdbcUtil = new JDBCUtil();
   }
   
   //주문 목록 조회(모든)
   public List<Orders> findOrderList() throws SQLException{
      String query = "SELECT * FROM orders ORDER BY orderId";
      
      jdbcUtil.setSqlAndParameters(query, null);
      
      try {
         ResultSet rs = jdbcUtil.executeQuery();
         List<Orders> orderList = new ArrayList<Orders>();
         
         while(rs.next()) {
            Orders order = new Orders(
                  rs.getInt("orderId"),
                  rs.getString("customerId"),
                  rs.getDate("creationDate"),
                  rs.getString("receiveType"),
                  rs.getString("receiverName"),
                  rs.getString("receiverPhone"),
                  rs.getString("memo"),
                  rs.getString("receiverAddress"));
            orderList.add(order);
            
            System.out.println(order.toString());
         }
         return orderList;
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         jdbcUtil.close();
      }
      return null;
   }
   
   //주문 목록 조회(고객 1명에 대한)
   public List<Orders> findOrderList(String customerId) throws SQLException{
      String query = "SELECT * FROM orders WHERE customerId = ? ORDER BY orderId";
      Object[] param = new Object[] {customerId};
      
      jdbcUtil.setSqlAndParameters(query, param);
      
      try {
         ResultSet rs = jdbcUtil.executeQuery();
         List<Orders> orderList = new ArrayList<Orders>();
         
         while(rs.next()) {
            Orders order = new Orders(
                  rs.getInt("orderId"),
                  customerId,
                  rs.getDate("creationDate"),
                  rs.getString("receiveType"),
                  rs.getString("receiverName"),
                  rs.getString("receiverPhone"),
                  rs.getString("memo"),
                  rs.getString("receiverAddress"));
            orderList.add(order);
            
            System.out.println(order.toString());
         }
         return orderList;
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         jdbcUtil.close();
      }
      return null;
   }
   
   //주문 상세 조회(mypage 주문 클릭 시 해당 상품 주문 내용 확인)
   public LineItem findOrder(int orderId) throws SQLException {
       String query = "SELECT * FROM lineItem WHERE orderId = ?";
       Object[] param = new Object[] {orderId};
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				LineItem lineItem = new LineItem(
					rs.getString("lineItemId"),
					orderId,
					rs.getInt("productId"),					
					rs.getInt("quantity"));
				
				System.out.println(lineItem.toString());
				return lineItem;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
   
   //주문 내역 저장
   public int addOrder(Orders order, int[] quantity, int[] productIds) throws SQLException{
	   int result = 0; 
	   
	   try {
		   //order
		   String query1 = "INSERT INTO orders (orderId, customerId, creationDate, receiveType, receiverName, receiverPhone, memo, receiverAddress) "
		   		+ "VALUES (Sequence_order.nextVal, ?, SYSDATE, ?, ?, ?, ?, ?)";
		   Object[] param1 = new Object[] {order.getCustomerId(), order.getReceiveType(),
				   order.getReceiverName(), order.getReceiverPhone(), order.getMemo(), order.getReceiverAddress()};      
  
		   jdbcUtil.setSqlAndParameters(query1, param1);   
		   String key[] = {"orderId"};
		   
		   jdbcUtil.executeUpdate(key);
		   ResultSet rs = jdbcUtil.getGeneratedKeys();
			if(rs.next()) {
				int generatedKey = rs.getInt(1);
				order.setOrderId(generatedKey);
			}
			System.out.println("order 추가 성공");
			
			//lineItem insert
			int i = 0;
			for (int pId : productIds) {
				String query2 = "INSERT INTO lineItem (lineItemId, orderId, productId, quantity) "
						+ "VALUES (Sequence_lineItem.nextVal, ?, ?, ?)";
				Object[] param2 = new Object[] {order.getOrderId(), pId, quantity[i]};     
				
				jdbcUtil.setSqlAndParameters(query2, param2);      
				String key2[] = {"lineItemId"};
				   
				jdbcUtil.executeUpdate(key2);
				ResultSet rs2 = jdbcUtil.getGeneratedKeys();
				if(rs2.next()) {
					int generatedKey = rs2.getInt(1);
					order.setOrderId(generatedKey);
				}
				i++;
			}
			
			System.out.println("lineItem 추가 성공");
			return result;
	   } catch(Exception ex) {
		   jdbcUtil.rollback();
		   ex.printStackTrace();   
	   }finally {
		   jdbcUtil.commit();
		   jdbcUtil.close();
	   }
	   return result;
   }   
   
}


