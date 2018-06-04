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
        PrintWriter out = response.getWriter();
        String sid = request.getParameter("id") != null ? request.getParameter("id") : "0";
        int id = Integer.parseInt(sid);
        AccountantBean bean = AccountantDao.getRecordById(id);

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

        out.println("<form action=\"EditAccountant\" method=\"post\">");
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
        out.println(
                "<div class=\"form-group\"><label for=\"inputRole\">Rôle</label><input type=\"number\" class=\"form-control\" id=\"inputRole\" name=\"role\" value=\""
                + bean.getRole() + "\" required></div>");
        out.println("<button type=\"submit\" class=\"btn btn-default\">Update Accountant</button>");

        out.println("</form>");

        out.println("</div>");
        request.getRequestDispatcher("footer.html").include(request, response);
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

}
