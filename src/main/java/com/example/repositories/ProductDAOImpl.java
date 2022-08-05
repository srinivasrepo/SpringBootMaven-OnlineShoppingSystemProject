package com.example.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.dto.ProductDto;
import com.example.entities.Product;




@Repository
public class ProductDAOImpl implements ProductDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public ProductDto getProductById(int pId) {
		// TODO Auto-generated method stub
//		Query q = null;
//		String query = "from Product";
//		q = (Query) this.entityManager.createQuery(query);
//		System.out.println(query);
		ProductDto pro;
		Product product = entityManager.find(Product.class, pId);
		 int prId = product.getProId();
		 String pName = product.getProName();
		 String pBrand = product.getProBrand();
		 float pPrice = product.getProPrice();
		 String pImage1 = product.getProImg1();
		 String pImage2 = product.getProImg2();
		 String pImage3 = product.getProImg3();
		 String pDescription = product.getProDescription();
		
	pro = new ProductDto( pImage1,  pImage2, pImage3, pDescription, pId,  pName,  pBrand,  pPrice)	;
		//System.out.println(product.getProName());
		return pro;
	}
	@Override
	@Transactional
	public List<ProductDto> getProductBySearchKeyWord(String keyword) {
		// TODO Auto-generated method stub
		List<ProductDto> products = new ArrayList<ProductDto>();
		String query = "from Product where Upper(proBrand) like Upper(:x) or Upper(proCategory) like Upper(:x) or upper(proName) like Upper(:x)";
		Query q = (Query)this.entityManager.createQuery(query);
		//q.setParameter("x",keyword);
		//q.setParameter("","%"+keyword+"%");
		q.setParameter("x", "%"+keyword+"%");
		//Product prod = (Product) q.getSingleResult();
		//System.out.println(prod.getProBrand());
		//System.out.println(prod.getProName());
		List<Product> productTables = q.getResultList();
		for(Product p : productTables)
		{
			int pId = p.getProId();
			String pImage1 = p.getProImg1();
			String pName = p.getProName();
			String pBrand = p.getProBrand();
			float pPrice = p.getProPrice();
			String pImage2 = p.getProImg2();
			String pImage3 = p.getProImg3();
			String pDescription = p.getProDescription();
			products.add(new ProductDto(pImage1,pImage2,pImage3,pDescription,pId,pName,pBrand,pPrice));	
			System.out.println(pId);
			System.out.println(pName);
			System.out.println(pBrand);
		}
		return products;
	}
	
	@Override
	@Transactional
	public List<ProductDto> sortProduct(String by, int order) {
		// TODO Auto-generated method stub
		//1 is for ascending and 0 is for descending
		List<ProductDto> products = new ArrayList<ProductDto>();
		Query query = null;
		if(order==1 && by.equalsIgnoreCase("price"))
		{	
			String commonQuery = "from Product order by proPrice asc ";
			query = (Query)this.entityManager.createQuery(commonQuery);
		}
		else if(order==0 && by.equalsIgnoreCase("price"))
		{
			String commonQuery = "from Product order by proPrice desc ";
			query = (Query)this.entityManager.createQuery(commonQuery);
		}
		else if(order==1 && by.equalsIgnoreCase("brand"))
		{
			String commonQuery = "from Product order by proBrand asc ";
			query = (Query)this.entityManager.createQuery(commonQuery);
		}
		else if(order==0 && by.equalsIgnoreCase("brand"))
		{
			String commonQuery = "from Product order by proBrand desc ";
			query = (Query)this.entityManager.createQuery(commonQuery);
		}
		else if(order==1 && by.equalsIgnoreCase("name"))
		{
			String commonQuery = "from Product order by proName desc ";
			query = (Query)this.entityManager.createQuery(commonQuery);
		}
		else if(order==0 && by.equalsIgnoreCase("name"))
		{
			String commonQuery = "from Product order by proName desc ";
			query = (Query)this.entityManager.createQuery(commonQuery);
		}
		List<Product> pro = query.getResultList();
		for(Product  p : pro)
		{
			int pId = p.getProId();
			String pImage1 = p.getProImg1();
			String pName = p.getProName();
			String pBrand = p.getProBrand();
			float pPrice = p.getProPrice();
			String pImage2 = p.getProImg2();
			String pImage3 = p.getProImg3();
			String pDescription = p.getProDescription();
			products.add(new ProductDto(pImage1,pImage2,pImage3,pDescription,pId,pName,pBrand,pPrice));
			System.out.println(pId);
			System.out.println(pName);
			System.out.println(pBrand);
			System.out.println(p.getProCategory());
			System.out.println(pPrice);
		}
		return products;

 }
	@Override
	public List<ProductDto> filterProduct(String brand, float s, float e) {
		// TODO Auto-generated method stub
		List<ProductDto> products = new ArrayList<ProductDto>();
		if(s==0f && e==0f)
		{
			System.out.println("Filtering By Brand");
			String q = "from Product where Upper(proBrand) like Upper(:x) ";
			Query query = (Query)this.entityManager.createQuery(q);
			query.setParameter("x", "%"+brand+"%");
			List<Product> pro = query.getResultList();
			for(Product  p : pro)
			{
				int pId = p.getProId();
				String pImage1 = p.getProImg1();
				String pName = p.getProName();
				String pBrand = p.getProBrand();
				float pPrice = p.getProPrice();
				String pImage2 = p.getProImg2();
				String pImage3 = p.getProImg3();
				String pDescription = p.getProDescription();
				products.add(new ProductDto(pImage1,pImage2,pImage3,pDescription,pId,pName,pBrand,pPrice));
				System.out.println(pName);
				System.out.println(pBrand);
				System.out.println(p.getProCategory());
				System.out.println(pPrice);
			}
		}
		else
		{
			System.out.println("Filtering By Range");
			String q = "from Product where Upper(proBrand) like Upper(:x) and proPrice between :y and :z ";
			Query query = (Query)this.entityManager.createQuery(q);
			query.setParameter("x", "%"+brand+"%");
			query.setParameter("y", s);
			query.setParameter("z", e);
			List<Product> pro = query.getResultList();
			for(Product  p : pro)
			{
				int pId = p.getProId();
				String pImage1 = p.getProImg1();
				String pName = p.getProName();
				String pBrand = p.getProBrand();
				float pPrice = p.getProPrice();
				String pImage2 = p.getProImg2();
				String pImage3 = p.getProImg3();
				String pDescription = p.getProDescription();
				products.add(new ProductDto(pImage1,pImage2,pImage3,pDescription,pId,pName,pBrand,pPrice));
				System.out.println(pId);
				System.out.println(pName);
				System.out.println(pBrand);
				System.out.println(p.getProCategory());
				System.out.println(pPrice);
			}
		}
		return products;
	}
	@Override
	public List<Product> getAllProducts() {
		String q = "from Product ";
		Query query = (Query)this.entityManager.createQuery(q);
		List<Product> products = query.getResultList();
		for(Product p : products) {
			System.out.println(p.getProId());
			System.out.println(p.getProName());
			System.out.println(p.getProPrice());
			System.out.println(p.getProDescription());
			System.out.println(p.getProBrand());
			System.out.println("--------------------------------------------------------------");
		}
		return products;
	}

}
	