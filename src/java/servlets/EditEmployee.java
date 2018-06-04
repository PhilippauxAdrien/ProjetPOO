package servlets;

import beans.EmployeeBean;
import dao.EmployeeDao;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String firstname=request.getParameter("firstname");
                String lastname=request.getParameter("lastname");
	 	String email=request.getParameter("email");
		String address=request.getParameter("address");
		String password=request.getParameter("password");
				
		EmployeeBean bean=new EmployeeBean(id, firstname, lastname, email, password, address);
		int status=EmployeeDao.update(bean);
		response.sendRedirect("ViewEmployee");
		
		out.close();
	}

}
