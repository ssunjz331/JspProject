package review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductOrderVO;
import model.ProductVO;
import model.ReviewVO;
import review.service.Service;
import review.service.ServiceImpl;

/**
 * Servlet implementation class ListReviweController
 */
@WebServlet("/ListReviewController")
public class ListReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new ServiceImpl();

		HttpSession session = request.getSession(false);
		String m_id = (String)session.getAttribute("id");
		
		ArrayList<ReviewVO> list = service.getMyReviewAll(m_id);

		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/review/myReviewList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
