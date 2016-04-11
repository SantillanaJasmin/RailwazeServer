import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		
		String mobNumber = request.getParameter("mobileNumber");
		
		try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a Connection
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/railwazedb", "root", "password");
            
            // Execute SQL query
            String query;
            query = "INSERT INTO `railwazedb`.`users`(`mobile_number`) VALUES(?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, mobNumber);
            pst.executeUpdate();

            // Clean-up environment
            pst.close();
            conn.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
        } catch (Exception e) {
            //Handle errors for Class.forName
        } finally {
            //finally block used to close resources
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }//end finally try
        } //end try */
	}

}
