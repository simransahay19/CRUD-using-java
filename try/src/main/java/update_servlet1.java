import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/update_servlet1")
public class update_servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String updateType = request.getParameter("update");
        if (updateType != null) {
            if (updateType.equals("name")) {
                updateName(request, response);
            } else if (updateType.equals("password")) {
                updatePassword(request, response);
            }
        }
    }

    private void updateName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newName = request.getParameter("newName");
        // Get name from session
        String name = (String) request.getSession().getAttribute("name");
        // Check if name and new name are not null or empty
        if (name != null && newName != null && !name.isEmpty() && !newName.isEmpty()) {
        	try {
        	    Class.forName("com.mysql.cj.jdbc.Driver");
        	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", "root", "rootsim");

        	    // SQL query to update the name
        	    String query = "UPDATE user SET name = ? WHERE name = ?";
        	    PreparedStatement pst = con.prepareStatement(query);
        	    pst.setString(1, newName);  // Set the new name
        	    pst.setString(2, name);      // Set the old name

        	    // Execute the update query
        	    int rowsAffected = pst.executeUpdate();

        	    // Check if the name was updated successfully
        	    if (rowsAffected > 0) {
        	        // Name updated successfully
        	    	response.getWriter().println("<h1> Name updated successfully <h1>");
        	    } else {
        	        // Failed to update name
        	        response.getWriter().println("<h1>Failed to update name.</h1>");
        	    }

        	    con.close();
        	} catch (ClassNotFoundException | SQLException e) {
        	    // Error processing the request
        	    response.getWriter().println("<h1>Error processing your request</h1>");
        	    e.printStackTrace(response.getWriter()); // For debugging, better logging mechanism recommended for production
        	}

        	
        	
        	
        	
            
        } else {
            response.getWriter().println("<h1>Invalid parameters for updating name.</h1>");
        }
    }

    private void updatePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPassword = request.getParameter("newPassword");
        // Get name from session
        String name = (String) request.getSession().getAttribute("name");
        // Check if name and new password are not null or empty
        if (name != null && newPassword != null && !name.isEmpty() && !newPassword.isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", "root", "rootsim");

                // SQL query to update the password
                String query = "UPDATE user SET password = ? WHERE name = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, newPassword);  // Set the new password
                pst.setString(2, name);      // Set the name

                // Execute the update query
                int rowsAffected = pst.executeUpdate();

                // Check if the password was updated successfully
                if (rowsAffected > 0) {
                    // Password updated successfully
                    response.getWriter().println("<h1>Password updated successfully</h1>");
                } else {
                    // Failed to update password
                    response.getWriter().println("<h1>Failed to update password.</h1>");
                }

                con.close();
            } catch (ClassNotFoundException | SQLException e) {
                // Error processing the request
                response.getWriter().println("<h1>Error processing your request</h1>");
                e.printStackTrace(response.getWriter()); 
            }
        } else {
            response.getWriter().println("<h1>Invalid parameters for updating password.</h1>");
        }
    }
}