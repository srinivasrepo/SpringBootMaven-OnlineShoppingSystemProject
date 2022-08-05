package com.example.repositories;



public interface CartDAO {
	public boolean addToCart(int uId, int pId);
	public boolean updateCart(int cId, int addOrMinus);
	public boolean deleteCart(int cId) ;
	
}
