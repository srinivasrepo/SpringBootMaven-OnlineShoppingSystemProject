package com.example;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entities.Admin;
import com.example.entities.Cart;
import com.example.entities.Customer;
import com.example.entities.Product;
import com.example.entities.Retailer;
import com.example.repositories.CartDAO;
import com.example.repositories.PlaceOrderDAO;
import com.example.repositories.ProductDAO;
import com.example.repositories.RetailerDao;
import com.example.repositories.UserDAO;
import com.example.repositories.WishlistDAO;



@SpringBootTest
class OnlineShoppingSystemApplicationTests {
	
	@Autowired
	RetailerDao rd;
	@Autowired
	UserDAO ud;
	@Autowired
	WishlistDAO ws;
	@Autowired
	CartDAO cd;
	@Autowired
	PlaceOrderDAO po;
	@Autowired
	ProductDAO pr;
	
	/*                                  //Admin test cases 
	@Test
	void  myTest3() {
		Admin admin = new Admin();
		admin.setAdminName("Rajesh");
		admin.setAdminPassword("********");
		admin.setAdminEmail("jaggu@gmail.com");
		admin.setAdminMobile("8977519022");
	rd.addAdmin(admin);
	}
	
                                      //Retailer test cases
	@Test                               //add retailer
	void  myTest1() {

		Retailer rt = new Retailer();
		rt.setRetailerName("Kumar");
		rt.setRetailerPassword("********");
		rt.setRetailerEmail("Kumar@gmail.com");
		rt.setRetailerAddress("Tenali");
	
		rd.addRetailer(rt);
	}
	@Test                                    //get retailer by id
	void  myTest2() {
		int id = 3;
		 rd.getRetailerById(id);
	   
	}
	@Test
	void addProduct() {                       //retailer will add product
		int id= 3;
		Product p = new Product();
		p.setProName("iPhone11Pro");
		p.setProBrand("IPhone");
		p.setProCategory("Electronics");
		p.setProDescription("4gb ram");
		p.setProQuantity(10);
		p.setProSubCategory("Mobiles");
		p.setProPrice(125000f);
		p.setProImg1("image1.jpg");
		p.setProImg2("image2.jpg");
		p.setProImg3("image3.jpg");
		rd.addProduct(p,id);				
	}
	@Test                                         //get retailer by email and password
	void getRetailerByEmailAndPassword() {
		String email = "ashok@gmail.com";
		String Password = "********";
		rd.getRetailerByEmailAndPassword(email, Password);
	}
	@Test                                       //update retailer
	void updateRetailer() {
		Retailer rt = new Retailer();
		rt.setRetailerId(3);
		rt.setRetailerName("Rajesh");
		rt.setRetailerPassword("********");
		rt.setRetailerEmail("Kumar@gmail.com");
		rt.setRetailerAddress("Tenali");
		rd.updateRetailer(rt);
	}
	@Test                                     //retailer will update products
	void updateProductByRetailer() {	
	Product p = new Product();
	p.setProId(102);
	p.setProName("iPhone11Pro");
	p.setProBrand("IPhone");
	p.setProCategory("Electronics");
	p.setProDescription("4gb ram");
	p.setProQuantity(10);
	p.setProSubCategory("Mobiles");
	p.setProPrice(125000f);
	p.setProImg1("image1.jpg");
	p.setProImg2("image2.jpg");
	p.setProImg3("image3.jpg");
		
	}
	

	@Test                                 //show products of particular retailer id
	void showMyProducts() {
		int id = 3;
		rd.showMyProducts(id);
	}
	@Test                                // get reatiler by email
	void getRetailerByEmail() {
		String email = "Kumar@gmail.com";		
		rd.getRetailerByEmail(email);
	}
	
	                                 //Customer test cases
	@Test                                  //Add customer
	void  myTest4() {
		Customer c = new Customer();
		c.setUserName("Ramarao");
		c.setUserEmail("NTR@Gmail.com");
		c.setUserGender("M");
		c.setUserAddress("Hyderabad");
		c.setUserMobile("9876879898");
		c.setUserPassword("Tarak@24343");
		ud.addUser(c);
	}
	@Test                               //get customer by email and password
	void  myTest5() {
		String email = "NTR@Gmail.com";
		String password = "Tarak@24343";
	 ud.getUserByEmailAndPassword(email, password);
	}
	@Test                                //get customer by id
	void myTest6() {
		int id = 79;
		ud.getUserById(id);		
	}
	@Test                                   //get  all customers
	void myTest7() {
	ud.getAllUsers();
		
	}
	@Test                                //get customer by email
	void myTest8() {
		String email = "Raja@Gmail.com";
		ud.getUserByEmail(email);
		
	}
	@Test                                      //update customer
	void myTest9() {
		int id=134;
		Customer c = new Customer();
		c.setUserId(id);
		c.setUserName("Rajinikanth");
		c.setUserEmail("Baba@Gmail.com");
		c.setUserGender("M");
		c.setUserAddress("Chennai");
		c.setUserMobile("9999999999");
		c.setUserPassword("Rajni@24343");
	}
	@Test                                      // get cart of customer
	void myTest10() {
		int id =5;
		ud.getCartOfUser(id);
	}
	@Test                                      //get wishlist of customer
	void myTest11() {
		int id =5;
		ud.getWishlistOfUser(id);
	}
	
	                                //wishlist test cases
	
	@Test                         //add to wishlist
	void myTest12() {
		int uId =5;
		int pId = 302;
		ws.addToWishlist(uId, pId);
		
	}
	@Test                         //delete wishlist
	void myTest13() {
		int wId =7;
		ws.deleteWishlist(wId);
	}
	
	                                     //Cart test cases
	@Test
	void myTest14() {                       //add to cart
		int uId =141;
		int pId = 302;
		cd.addToCart(uId, pId);
	}
	/*@Test
	void myTest24() {                       //add to cart
		String uId ="Upendra";
		String pId = "Lenovo";
		cd.addToCart(uId, pId);
	}
	@Test
	void myTest15() {                           //delete  cart
		int cId=143;
		cd.deleteCart(cId);
		
	}
	
	@Test
	void myTest16() {                             //update  cart
		int cId=144;
		int addOrMinus =1;
		cd.updateCart(cId, addOrMinus);	
	}
	
                                               //Place order tests
	
	@Test                                             //place order
	void myTest17() {  
		List<Cart> myCart = new ArrayList<Cart>();
		String payType = "G pay";
		//Cart c1 = new Cart();
		Cart c2 = new Cart();
		Cart c3 = new Cart();
		
		
		c3.setCartId(144);
		c2.setCartId(142);
		//myCart.add(c1);
		//myCart.add(c2);
		myCart.add(c3);
		myCart.add(c2);
		
		po.placeOrder(myCart, payType);
				
		
	}
	/*@Test
	void myTest18() {                      //show placed orders
		int uId=92;
	po.showPlacedOrders(uId);
		
	}
	                                          //Product test
	@Test
	void myTest19() {                         //get product by id
		int pId=301;
	pr.getProductById(pId);
		
	}
	@Test
	void myTest20() {              //get products by search keyword name,brand,category
		String searchKeyword = "AA";
	pr.getProductBySearchKeyWord(searchKeyword);
		
	}
	@Test                
	void myTest21() {                    //sort products name,price,brand
		String orderBy = "price";
		int ascOrDesc = 1;
		pr.sortProduct(orderBy, ascOrDesc);
	}
	@Test
	void myTest22() {                    //filter products by price and brand
		String brand = "AA"; 
		float s = 2f;
		float e = 15000f;
		pr.filterProduct(brand, s, e);
	}
	@Test                                //get all products
	void myTest23() {
		pr.getAllProducts();
	}
	*/
}
