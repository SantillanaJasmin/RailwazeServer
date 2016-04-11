

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
 * Servlet implementation class CheckInServlet
 */
@WebServlet("/CheckInServlet")
public class CheckInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInServlet() {
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
		
		int userid = Integer.parseInt(request.getParameter("userID"));
		int station = Integer.parseInt(request.getParameter("station"));
		String direction = request.getParameter("direction");
		
		try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a Connection
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/railwazedb", "root", "password");
            
            // Execute SQL query
            String query;
            query = "INSERT INTO `checkin`(`user_id`, `station`, `direction`, `time`) VALUES(?, ?, ?, NOW())";
            pst = conn.prepareStatement(query);
            pst.setInt(1, userid);
            pst.setInt(2, station);
            pst.setString(3, direction);
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
