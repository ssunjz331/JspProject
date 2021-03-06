package admin.memberManage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.Service;
import member.service.ServiceImpl;
import model.MemberVO;

/**
 * Servlet implementation class MemberManageEditController
 */
@WebServlet("/MemberManageEditController")
public class MemberManageEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberManageEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        
        Service service = new ServiceImpl();
        
        String id = request.getParameter("id");
        String pwd=request.getParameter("pwd");
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String addr=request.getParameter("addr");

        System.out.println("받은 데이터 : " + id + "," + pwd + "," + name +"," + email +"," + addr );
        //요청 파라미터로 읽은 값으로 Member 객체 생성
        MemberVO m = new MemberVO(id, pwd, name, email, addr);
        

        
        //서비스의 수정 메소드 호출
        service.editMember(m);
        

        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/MemberManageController");
        if(dispatcher!=null) {
           dispatcher.forward(request, response);
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
