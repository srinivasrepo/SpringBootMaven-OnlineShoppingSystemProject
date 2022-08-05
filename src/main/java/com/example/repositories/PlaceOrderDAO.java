package com.example.repositories;

import java.util.List;

import com.example.dto.CartDto;
import com.example.dto.Carts;
import com.example.dto.PlacedOrder;
import com.example.entities.Cart;



public interface PlaceOrderDAO {
	public boolean placeOrder(List<CartDto> carts, String payType);
	public List<PlacedOrder> showPlacedOrders(int uId);
}