/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.FeeDao;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Status;

/**
 *
 * @author adrie
 */
@WebServlet(name = "ManageFee", urlPatterns = {"/ManageFee"})
public class ManageFee extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Fee Added</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navemployee.html").include(request, response);
		out.println("<div class='container'>");
		
		String action=request.getParameter("action");
                String sid=request.getParameter("id");
	 	
                if("accept".equals(action)){
                    FeeDao.updateStatus(Integer.parseInt(sid), Status.ACCEPTED.getValue());
                }else if("delete".equals(action)){
                    FeeDao.delete(Integer.parseInt(sid));
                }
                else{
                  FeeDao.updateStatus(Integer.parseInt(sid), Status.DENIED.getValue());
                }
		
		out.print("<h1>Add Fee Form</h1>");
		out.println("<p>Fee is updated successfully!</p>");
		response.sendRedirect("/ProjetPOO/AllFees");

		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
