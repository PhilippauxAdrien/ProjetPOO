package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AccountantBean;
import beans.StudentBean;
import dao.AccountantDao;
import dao.StudentDao;
@WebServlet("/EditAccountant")
public class EditAccountant extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String firstname=request.getParameter("firstname");
                String lastname=request.getParameter("lastname");
	 	String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String role=request.getParameter("role");
		
		AccountantBean bean=new AccountantBean(id, firstname, lastname, email, password, address, role);
		AccountantDao.update(bean);
		response.sendRedirect("ViewAccountant");
		
		out.close();
	}

}
