import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", "root", "rootsim");

            String query = "SELECT * FROM user WHERE name=? AND password=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // If credentials are valid, store the name in the session
                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                session.setAttribute("password", password);
                // Storing the name attribute in the session

                // Forward the request to the success JSP page
                RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
                dispatcher.forward(request, response);
            } else {
                out.print("<h1>Invalid user</h1><br>");
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h1>Error processing your request</h1>");
            e.printStackTrace(out); // For debugging, better logging mechanism recommended for production
        }
    }
}
