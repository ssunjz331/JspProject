package product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductVO;
import model.ReviewVO;
import product.service.Service;
import product.service.ServiceImpl;

@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CategoryController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String category = request.getParameter("category");
		Service service = new ServiceImpl();
		review.service.Service review_service = new review.service.ServiceImpl();
		
		ArrayList<ProductVO> products = service.getCategoryProducts(category);
		
		for (ProductVO product : products) {
			ArrayList<ReviewVO> reviews = review_service.getReviewByProductNum(product.getNum());
			product.setReviews(reviews);
		}
		
		request.setAttribute("products", products);

//		System.out.println(products.size());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/product/categoryList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
