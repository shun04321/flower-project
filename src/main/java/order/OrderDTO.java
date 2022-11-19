package order;

public class OrderDTO {

	private String name;
	private String phone;
	private String email;
	private String telephone;
	private String address;
	private String date;
	private String memo;
	
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
	public OrderDTO(String name, String phone, String email, String telephone, String address, String date,
			String memo) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
		this.date = date;
		this.memo = memo;
	}
	
}
