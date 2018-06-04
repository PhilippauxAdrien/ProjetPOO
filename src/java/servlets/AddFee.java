package servlets;


import beans.FeeBean;
import dao.FeeDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Status;

/**
 *
 * @author adrien
 */
@WebServlet("/AddFee")
public class AddFee extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		String amount=request.getParameter("amount");
                String sdate=request.getParameter("date");
	 	
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
                java.util.Date date;
                java.sql.Date sqlDate = null;
                try {
                    date = sdf1.parse(sdate);
                    sqlDate = new java.sql.Date(date.getTime());  
                } catch (ParseException ex) {
                    Logger.getLogger(AddFee.class.getName()).log(Level.SEVERE, null, ex);
                }
                
		HttpSession session = request.getSession();
                int iduser = (int)session.getAttribute("idemployee");
		FeeBean bean= new FeeBean(Double.parseDouble(amount), sqlDate, iduser, Status.SUBMITTED.getValue());
		int status=FeeDao.save(bean);
		
		out.print("<h1>Add Fee Form</h1>");
		out.println("<p>Fee is added successfully!</p>");
		request.getRequestDispatcher("AddFeeForm.html").include(request, response);
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
