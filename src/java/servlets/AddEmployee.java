
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

@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String firstname=request.getParameter("firstname");
                String lastname=request.getParameter("lastname");
	 	String email=request.getParameter("email");
		String address=request.getParameter("address");
		String password=request.getParameter("password");
		
		EmployeeBean bean=new EmployeeBean(firstname, lastname, email, password, address);
		int status=EmployeeDao.save(bean);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Employee</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navaccountant.html").include(request, response);
		out.println("<div class='container'>");
		
                if(status >0)
                    out.println("Employee is added successfully!");
		else
                    out.println("Something went wrong... ");
                
		request.getRequestDispatcher("AddEmployeeForm.html").include(request, response);
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
