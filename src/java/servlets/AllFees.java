package servlets;

import beans.FeeBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FeeDao;
import utils.Status;
@WebServlet("/AllFees")
public class AllFees extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Student</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navaccountant.html").include(request, response);
		out.println("<div class='container'>");
		
		out.print("<h1>All Fees</h1>");
	
	
		List<FeeBean> list=FeeDao.getAll();
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>Id</th><th>Amount</th><th>Date</th><th>IdUser</th><th>Status</th><th>Delete</th>");
		for(FeeBean bean:list){
			out.print("<tr><td>"+bean.getId()+"</td><td>"+bean.getAmount()+"</td><td>"+bean.getDate()+"</td><td>"+bean.getIduser()+"</td><td>"+ Status.findByValue(bean.getStatus())+"</td><td><a href='ManageFee?action=delete&id="+bean.getId()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</table>");
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	
	}

}
