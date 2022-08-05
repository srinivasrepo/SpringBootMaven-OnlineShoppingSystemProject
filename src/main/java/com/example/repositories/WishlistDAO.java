package com.example.repositories;


public interface WishlistDAO {
	public boolean addToWishlist(int uId, int pId);
	public boolean deleteWishlist(int wId);
}
