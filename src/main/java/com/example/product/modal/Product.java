package com.example.product.modal;

	
	public class Product {
		 
	    private String prodNo;
	    private String prodName;
	    private int price;
	 
	    public Product() {
	 
	    }
	 
	    public Product(String prodNo, String prodName, int price) {
	        this.prodNo = prodNo;
	        this.prodName = prodName;
	        this.price = price;
	    }
	 
	    public String getprodNo() {
	        return prodNo;
	    }
	 
	    public void setprodNo(String prodNo) {
	        this.prodNo = prodNo;
	    }
	 
	    public String getprodName() {
	        return prodName;
	    }
	 
	    public void setprodName(String prodName) {
	        this.prodName = prodName;
	    }
	 
	    public int getprice() {
	        return price;
	    }
	 
	    public void setprice(int price) {
	        this.price = price;
	    }
	 
	}


