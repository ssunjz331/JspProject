package review.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.ProductOrderVO;
import model.ReviewVO;
import review.service.Service;
import review.service.ServiceImpl;

/**
 * Servlet implementation class AddReviewController
 */
@WebServlet("/AddReviewController")
public class AddReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int p_num = Integer.parseInt(request.getParameter("p_num"));
		
		System.out.println("AddReviewController들어감");
		
		Service service = new ServiceImpl();
		HttpSession session = request.getSession(false);
	    String m_id = (String) session.getAttribute("id");
        
	    ReviewVO review = new ReviewVO();
	    
	    review.setM_id(m_id);
//	    review.setNum(service.makeNum());
	    
//	    int num = service.makeNum();
//	    productorder.service.Service service_order = new productorder.service.ServiceImpl();
//	    ProductOrderVO o = service_order.getOrder(num);
//	    review.setP_num(o.getP_num());
	    review.setP_num(p_num);
	    
//	    review.setContent(request.getParameter("message"));
////		review.setRate(Double.parseDouble(request.getParameter("rate")));	
//	    review.setRate(Integer.parseInt(request.getParameter("rate")));
//		review.setImg(request.getParameter("r_img"));

	    String review_img = "";
	    int maxSize =1024 *1024 *10;
		MultipartRequest multi = null;
		

		String uploadPath = "C:\\Web-kitri\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\review_img";
		
		try {
			// request,파일저장경로,용량,인코딩타입,중복파일명에 대한 기본 정책
			multi = new MultipartRequest(request, uploadPath, maxSize, "utf-8", 
		new DefaultFileRenamePolicy());
			
			review.setRate(Integer.parseInt(multi.getParameter("rate")));	
			review.setContent(multi.getParameter("message"));				

			// 전송한 전체 파일이름들을 가져옴
			Enumeration files = multi.getFileNames();
			
			while (files.hasMoreElements()) {
				// form 태그에서 <input type="file" name="여기에 지정한 이름" />을 가져온다.
			String file1 = (String) files.nextElement();// 파일 input에 지정한 이름을 가져옴	
				// 그에 해당하는 실재 파일 이름을 가져옴
				review_img = multi.getOriginalFileName(file1);
				//파일업로드
				File file = multi.getFile(file1);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		review.setImg("/review_img/" + review_img);

		service.add(review);	

		productorder.service.Service service_po = new productorder.service.ServiceImpl();

		service_po.editR_State(m_id,p_num);
		System.out.println("pnum은"+p_num+"m_id는"+m_id);
		
		// 적립금
		int o_num = Integer.parseInt(request.getParameter("o_num"));
		ProductOrderVO po = new ProductOrderVO();
		
		service_po.editPoint(m_id, o_num);
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/review/myReviewList.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListReviewController");	
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
