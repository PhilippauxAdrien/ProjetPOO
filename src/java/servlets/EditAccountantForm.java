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

@WebServlet("/EditAccountantForm")
public class EditAccountantForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String sid=request.getParameter("id") != null ? request.getParameter("id") : "0";
		int id=Integer.parseInt(sid);
		AccountantBean bean=AccountantDao.getRecordById(id);
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Accountant</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		
		out.print("<h1>Edit Accountant Form</h1>");
		out.print("<form action='EditAccountant' method='post'>");
		out.print("<table>");
		out.print("<tr><td><input type='hidden' name='id' value='"+bean.getId()+"' /></td></tr>");
		out.print("<tr><td>Firstname:</td><td><input type='text' name='firstname' value='"+bean.getFirstname()+"'/></td></tr>");
                out.print("<tr><td>Lastname:</td><td><input type='text' name='lastname' value='"+bean.getLastname()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+bean.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='text' name='password' value='"+bean.getPassword()+"'/></td></tr>");
		out.print("<tr><td>Address:</td><td><textarea name='address' style='width:300px;height:100px;'>"+bean.getAddress()+"</textarea></td></tr>");
		out.print("<tr><td>Role (Admin:1,Acc.:2,Empl.:3) :</td><td><input type='text' name='role' value='"+bean.getRole()+"'/></td></tr>");
		out.print("<tr><td colspan='2' align='center'><input type='submit' value='Update Accountant' class='btn btn-default'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		
		out.close();
	}

}
