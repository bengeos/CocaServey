package com.victorshub.coca.cocastock.Model;

public class Report {
	private String id,date,product_name, remaining_day,user_name, shop_name,shop_id;

	public Report(String id, String date,String product_name, String remaining_day, String user_name, String shop_name,String shop_id) {
		this.id = id;
        this.date = date;
		this.product_name = product_name;
		this.remaining_day = remaining_day;
		this.user_name = user_name;
		this.shop_name = shop_name;
		this.shop_id = shop_id;

	}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getRemaining_day() {
		return remaining_day;
	}

	public void setRemaining_day(String remaining_day) {
		this.remaining_day = remaining_day;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Report(){
		
	}
}
