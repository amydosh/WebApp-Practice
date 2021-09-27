package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shop.Product;
import com.shop.ProductImage;
import com.shop.ProductImageMeta;
import com.util.HibernateUtil;

/**
 * Servlet implementation class NewProduct
 */
@WebServlet("/NewProduct")
public class NewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 

			String name="Mug";
			double price =12.95;
			String name2="Hat";
			double price2 =10.55;
			
//			List<ProductImageMeta> imagesMeta = new ArrayList<ProductImageMeta>();
//			List<ProductImage> images = new ArrayList<ProductImage>();
			// The below code was used in the beginning to demonstrate creating the tables, however it does not map the images/products, therefore the 
			// code below with ProductImage img1... through p1.setImages(images) was added which maps correctly
//			images.add(new ProductImage("a.jpg"));
//			images.add(new ProductImage("b.jpg"));
//			images.add(new ProductImage("c.jpg"));
			
			
			
			Product p1 = new Product(name,price);
			Product p2 = new Product(name2,price2);
			// Using below to verify
			System.out.println("Product 1 is: "+p1);
			System.out.println("Product 2 is: "+p2);
			
			
			ProductImage img1 = new ProductImage("a.jpg",p1);
			img1.addImageMeta(new ProductImageMeta("height","200",img1));
			
			ProductImage img2 = new ProductImage("b.jpg",p1);
			img2.addImageMeta(new ProductImageMeta("height","200",img2));
//			// Using below to verify
			System.out.println("Image 1 is: "+img1);
			System.out.println("Image 2 is: "+img2);
			
			
//			
			ProductImage img3 = new ProductImage("a.jpg",p2);
			ProductImage img4 = new ProductImage("b.jpg",p2);
//			// Using below to verify
			System.out.println("Image 3 is: "+img3);
			System.out.println("Image 4 is: "+img4);
			img3.addImageMeta(new ProductImageMeta("height","200",img1));
			img4.addImageMeta(new ProductImageMeta("height","200",img2));

			
			
			p1.addImage(img1);
			p1.addImage(img2);
			
			p2.addImage(img3);
			p2.addImage(img4);
//			
			

			// The below two lines were replaced by the third down as more streamlined
//			SessionFactory factory = HibernateUtil.getSessionFactory();
//			Session session = factory.openSession();
			Session session = HibernateUtil.getSessionFactory().openSession();
		
			Transaction trans = session.beginTransaction();
			
			session.save(p1);
			session.save(p2);
			
			// End your transaction & close session
			trans.commit();
			session.close();
			
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("Transaction complete!");
			out.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}


}
