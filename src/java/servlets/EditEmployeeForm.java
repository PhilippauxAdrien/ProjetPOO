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

@WebServlet("/EditEmployeeForm")
public class EditEmployeeForm extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        EmployeeBean bean = EmployeeDao.getRecordById(id);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Edit Employee Form</title>");
        out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
        out.println("<link rel='stylesheet' href='style.css'/>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("navaccountant.html").include(request, response);
        out.println("<div class='container'>");

        out.print("<h1>Edit Employee Form</h1>");

        out.println("<form action=\"EditEmployee\" method=\"post\">");
        out.println(
                "<div class=\"form-group\"><input type=\"hidden\" name=\"id\" value=\"" + bean.getId() + "\" required></div>");
        out.println(
                "<div class=\"form-group\"><label for=\"inputFirstname\">Firstname</label><input type=\"text\" class=\"form-control\" id=\"inputFirstname\" name=\"firstname\" value=\""
                + bean.getFirstname() + "\" required></div>");

        out.println(
                "<div class=\"form-group\"><label for=\"inputLastname\">Lastname</label><input type=\"text\" class=\"form-control\" id=\"inputLastname\" name=\"lastname\" value=\""
                + bean.getLastname() + "\" required></div>");
        out.println(
                "<div class=\"form-group\"><label for=\"inputPassword\">Password</label><input type=\"password\" class=\"form-control\" id=\"inputPassword\" name=\"password\" value=\""
                + bean.getPassword() + "\" required></div>");
        out.println(
                "<div class=\"form-group\"><label for=\"inputEmail\">Email</label><input type=\"email\" class=\"form-control\" id=\"inputEmail\" name=\"email\" value=\""
                + bean.getEmail() + "\" required></div>");
        out.println(
                "<div class=\"form-group\"><label for=\"inputAddress\">Address</label><textarea class=\"form-control\" name=\"address\" id=\"inputAddress\" rows=\"3\">"
                + bean.getAddress() + "</textarea></div>");
        out.println("<button type=\"submit\" class=\"btn btn-default\">Update Employee</button>");

        out.println("</form>");

        out.println("</div>");
        request.getRequestDispatcher("footer.html").include(request, response);
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

}
