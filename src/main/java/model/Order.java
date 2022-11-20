package model;

public class Order {

   private String name;
   private String phone;
   private String email;
   private String telephone;
   private String address;
   private String date;
   private String memo;
   private String orderId;
   private String productId;
   private int quantity;
   private int price;
   
   public String getOrderId() {
      return orderId;
   }
   public void setOrderId(String orderId) {
      this.orderId = orderId;
   }
   public String getProductId() {
      return productId;
   }
   public void setProductId(String productId) {
      this.productId = productId;
   }
   public int getQuantity() {
      return quantity;
   }
   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getPhone() {
      return phone;
   }
   public void setPhone(String phone) {
      this.phone = phone;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getTelephone() {
      return telephone;
   }
   public void setTelephone(String telephone) {
      this.telephone = telephone;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public String getDate() {
      return date;
   }
   public void setDate(String date) {
      this.date = date;
   }
   public String getMemo() {
      return memo;
   }
   public void setMemo(String memo) {
      this.memo = memo;
   }
   @Override
   public String toString() {
      return "Order [name=" + name + ", phone=" + phone + ", email=" + email + ", telephone=" + telephone
            + ", address=" + address + ", date=" + date + ", memo=" + memo + ", orderId=" + orderId + ", productId="
            + productId + ", quantity=" + quantity + ", price=" + price + "]";
   } 
   


  
}