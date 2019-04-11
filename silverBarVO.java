package CreditSuisse;

public class silverBarVO {

	private String userId;
	private float quantity;
	private float priceperkg;
	private String orderType ;

	public silverBarVO(){
	}

	public silverBarVO(String u, float q, float p, String o){
		this.userId = u;
		this.quantity = q;
		this.priceperkg = p;
		this.orderType = o;
	}

	public String getUserId(){
		return this.userId;
	}
	public void setUserId(String x){
		this.userId = x;
	}

	public float getQuantity(){
		return this.quantity;
	}
	public void setQuantity(float x){
		this.quantity = x;
	}

	public float getPriceperkg(){
		return this.priceperkg;
	}
	public void setPriceperkg(float x){
		this.priceperkg = x;
	}
		
	public String getOrderType(){
		return this.orderType;
	}
	public void setOrderType(String x){
		this.orderType = x;
	}
}

