package model;

public class LineItem {
	private String lineItemId;
	private int orderId;
	private int productId;
	private int quantity;
	
	public LineItem() {
		super();
	}

	public LineItem(String lineItemId, int orderId, int productId, int quantity) {
		super();
		this.lineItemId = lineItemId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(String lineItemId) {
		this.lineItemId = lineItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPoductId() {
		return productId;
	}

	public void setPoductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "LineItem [lineItemId=" + lineItemId + ", orderId=" + orderId + ", productId=" + productId + ", quantity="
				+ quantity + "]";
	}
	
}