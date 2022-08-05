package com.example.repositories;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import com.example.dto.AddProduct;
import com.example.dto.RetailerSignUp;
import com.example.entities.Admin;
import com.example.entities.Customer;
import com.example.entities.Product;
import com.example.entities.Retailer;



@Repository
public class RetailerDaoImpl implements RetailerDao {
	@PersistenceContext
    EntityManager entityManager;

	@Transactional
	public int addRetailer(RetailerSignUp  rt) {

		Retailer retailer= new Retailer();
		retailer.setRetailerName(rt.getuName());
		retailer.setRetailerPassword(rt.getuPassword());
		retailer.setRetailerAddress(rt.getAddress());
		retailer.setRetailerEmail(rt.getuEmail());
		retailer.setRetailerMobile(rt.getuPhone());
		this.entityManager.persist(retailer);
	
		System.out.println("Added successfully");
//Query q = null;
		
//		String query = "from Retailer where retailerName=:x";
//		q = (Query) this.entityManager.createQuery(query);
//		q.setParameter("x", rt.getuName());
//		Retailer c = (Retailer) q.getSingleResult();
		
		//System.out.println("Your user_id is "+newUser.getUserId());
		//return newUser.getUserId();
		return retailer.getRetailerId();
	}

//
//	@Override
//	@Transactional
//	public RetailerSignUp getRetailerById(int rid) {
////		Query q = null;
////		String query = "from Retailer";
////		q = (Query) this.entityManager.createQuery(query);
////		System.out.println(query);
//		Retailer retailer = entityManager.find(Retailer.class, rid);
//		 int rId = retailer.getRetailerId();
//		String uName = retailer.getRetailerName();
//	    String uEmail = retailer.getRetailerEmail();
//		String uPassword = retailer.getRetailerPassword();
//		String uPhone = retailer.getRetailerMobile();
//		String address = retailer.getRetailerAddress();
//		RetailerSignUp r = 	new RetailerSignUp(uName,uEmail, uPassword,uPhone, rId,address);
//		System.out.println(retailer);
//		return r;
	//}
	@Transactional
	public void addAdmin(Admin ad) {
		entityManager.persist(ad);
		//System.out.println(rt);
		
	}

	@Override
	@Transactional
	public boolean addProduct(AddProduct product, int RetailerId) {
		Retailer supply= this.entityManager.find(Retailer.class, RetailerId);
		Product prod = new Product();
		prod.setProBrand(product.getpBrand());
		prod.setProCategory(product.getpCategory());
	    prod.setProSubCategory(product.getpSubCategory());
	    prod.setProDescription(product.getpDescription());
		prod.setProImg1(product.getpImage1());
		prod.setProImg2(product.getpImage2());
		prod.setProImg3(product.getpImage3());
		prod.setProName(product.getpName());
		prod.setProPrice(product.getpPrice());
		prod.setProQuantity(product.getpQty());
		
		this.entityManager.persist(prod);
		return true;
	}
	@Override
	@Transactional
	public int getRetailerByEmailAndPassword(String email, String Password) {
		// TODO Auto-generated method stub
		String query = "from Retailer where retailerEmail=:x and retailerPassword=:y";
		Query stmt= null;
			stmt=(Query)this.entityManager.createQuery(query);
			stmt.setParameter("x", email);
			stmt.setParameter("y", Password);
			System.out.println("Result is :"+stmt.getSingleResult());
			Retailer supply = (Retailer)stmt.getSingleResult();
			int id = supply.getRetailerId();
			System.out.println(id);
			return id;
	}
	@Transactional
	public RetailerSignUp updateRetailer(RetailerSignUp retailer) {
		// TODO Auto-generated method stub
		Retailer updateSupply = this.entityManager.find(Retailer.class, retailer.getrId());
		updateSupply.setRetailerName(retailer.getuName());
		updateSupply.setRetailerPassword(retailer.getuPassword());
		updateSupply.setRetailerMobile(retailer.getuPhone());
		updateSupply.setRetailerEmail(retailer.getuEmail());
		updateSupply.setRetailerAddress(retailer.getAddress());
		this.entityManager.merge(updateSupply);
		System.out.println("Updated successfully");
		
		return retailer;
	}
	@Transactional
	public AddProduct updateProduct(AddProduct updateProduct, int proId) {
		// TODO Auto-generated method stub
		Product oldPro= this.entityManager.find(Product.class, proId);
		oldPro.setProName(updateProduct.getpName());
		oldPro.setProBrand(updateProduct.getpBrand());
		oldPro.setProCategory(updateProduct.getpCategory());
		oldPro.setProDescription(updateProduct.getpDescription());
		oldPro.setProQuantity(updateProduct.getpQty());
		oldPro.setProSubCategory(updateProduct.getpSubCategory());
		oldPro.setProPrice(updateProduct.getpPrice());
		oldPro.setProImg1(updateProduct.getpImage1());
		oldPro.setProImg2(updateProduct.getpImage2());
		oldPro.setProImg3(updateProduct.getpImage3());
		this.entityManager.merge(oldPro);
		System.out.println("Updated product successfully");
		return updateProduct;
		
	}


	@Transactional
	public List<Product> showMyProducts(int retailerId) {
		// TODO Auto-generated method stub
		List<Product> prod = new ArrayList<Product>();
		Retailer supply =this.entityManager.find(Retailer.class,retailerId);
		prod= supply.getProductstables();

		for(Product p: prod)
		{
			
			System.out.println(p.getProBrand());
			
			String proImg1 = p.getProImg1();
			String proImg2 = p.getProImg2();
			String proImg3 = p.getProImg3();
			String pDesc = p.getProDescription();
			int proId = p.getProId();
			String proName = p.getProName();
			String proBrand = p.getProBrand();
			float proPrice = p.getProPrice();
			System.out.println(proName);
//			//prod.add(new Product(proImg1,proImg2,proImg3,pDesc,proId,proName,proBrand,proPrice));
			
		}
		return prod;
		
}
	@Transactional
	public Retailer getRetailerByEmail(String email) {
		// TODO Auto-generated method stub
		String query = "from Retailer where retailerEmail=:x";
		Retailer user = null;
		Query q = null;
			q = (Query) this.entityManager.createQuery(query);
			q.setParameter("x", email);
			user = (Retailer)q.getSingleResult();
			return user;
	}


	@Override
	public List<RetailerSignUp> showAllRetailers() {
		List<RetailerSignUp>  rs = new ArrayList<RetailerSignUp>();
		String query = "from Retailer";
		Retailer user = null;
		Query q = null;
		q = (Query) this.entityManager.createQuery(query);
		List<Retailer> retailer = q.getResultList();
		for(Retailer r : retailer) {
			 int rId = r.getRetailerId();
			 String uName = r.getRetailerName();
			String uEmail = r.getRetailerEmail();
			String uPassword = r.getRetailerPassword();
			 String uPhone = r.getRetailerMobile();
			 String address = r.getRetailerAddress();
			 rs.add(new RetailerSignUp( uName,  uEmail,  uPassword,  uPhone,  rId,address));
		}
		return rs;
	}


}