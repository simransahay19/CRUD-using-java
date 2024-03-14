import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/delete_servlet")
public class delete_servlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    public delete_servlet() {
        super();
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieving the name from the session
        String name = (String) request.getSession().getAttribute("name");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", "root", "rootsim");

            // SQL query to delete the user from the table
            String query = "DELETE FROM user WHERE name=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);

            // Execute the delete query
            int rowsAffected = pst.executeUpdate();

            // Check if the user was deleted successfully
            if (rowsAffected > 0) {
                response.sendRedirect("delete.jsp");
            } else {
                out.print("<h1>Failed to delete user " + name + ".</h1>");
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h1>Error processing your request</h1>");
            e.printStackTrace(out); // For debugging, better logging mechanism recommended for production
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Call doDelete() method to handle delete operation
        doDelete(request, response);
    }
}
