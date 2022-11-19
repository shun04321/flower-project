package model;

public class CartItem {
	private int cartItemId;
	private int quantity;
	private String customerId;
	private int productId;	//product 클래스에서 얻어옴
	
	public CartItem() {
		super();
	}

	public CartItem(int cartItemId, int quantity, String customerId, int productId) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
		this.customerId = customerId;
		this.productId = productId;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}