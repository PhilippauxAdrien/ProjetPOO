package servlets;

import beans.EmployeeBean;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import utils.Role;
@WebServlet("/SearchEmployee")
public class SearchEmployee extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String query=request.getParameter("query");
		
		EmployeeBean bean=EmployeeDao.getRecordByLastName(query);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Search Employee</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navaccountant.html").include(request, response);
		out.println("<div class='container'>");
		
	
		out.println("<h1>Search Employee</h1>");
		
		if(bean != null && bean.getId()>0){
                    out.println("<table class='table table-bordered table-striped'>");
                    out.print("<tr><td>Id:</td><td>"+bean.getId()+"</td></tr>");
                    out.print("<tr><td>Firstname:</td><td>"+bean.getFirstname()+"</td></tr>");
                    out.print("<tr><td>Lastname:</td><td>"+bean.getLastname()+"</td></tr>");
                    out.print("<tr><td>Email:</td><td>"+bean.getEmail()+"</td></tr>");
                    out.print("<tr><td>Password:</td><td>"+bean.getPassword()+"</td></tr>");
                    out.print("<tr><td>Address:</td><td>"+bean.getAddress()+"</td></tr>");
                    out.print("<tr><td>Role:</td><td>"+Role.findByValue(bean.getRole())+"</td></tr>");
                    out.print("</table>");
		}else{
			out.println("<p>Sorry, No Record found for query '"+query+"'</p>");
		}
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
