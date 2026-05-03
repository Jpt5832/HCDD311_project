import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.*;

public class H2ConnectionExample {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    //static final String DB_URL = "jdbc:h2:~/testdb"; // Embedded Mode, file-based
    //static final String DB_URL = "jdbc:h2:/path/to/database/file"; 
    //static final String DB_URL = "jdbc:h2:C:\Users\jvo101\eclipse-workspace\HCDD311 - Spring 2026\src\databases"; // Embedded Mode, file-based
    static final String DB_URL = "jdbc:h2:/Users/jaysontroxel/IdeaProjects1/ZombieGame/src/databases/H2ConnEx"; // Embedded Mode, file-based
        // Database credentials
    static final String USER = "sa"; // H2 default user
    static final String PASS = ""; // H2 default password (empty)

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // STEP 1: Register JDBC driver (less necessary for modern JDBC, but good practice)
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection successful.");

         /** ... Perform database operations here ... */
            // SQL statements
            final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS testexample (ID_field INT PRIMARY KEY, Product_Name VARCHAR(25), Description VARCHAR(100), Quantity INT, Price DECIMAL(5,2));";
            // 1. Create a Statement to execute simple SQL
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(CREATE_TABLE_SQL);
                System.out.println("Table created/verified.");
            }
            
            final String INSERT_SQL = "INSERT INTO testexample (ID_field, Product_Name, Description, Quantity, Price) VALUES (?, ?, ?, ?, ?)";
            // 2. Create a PreparedStatement for inserting data (safe against SQL injection)
            try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
               pstmt.setInt(1, 101);
               pstmt.setString(2, "Pringles");
               pstmt.setString(3, "can of chips");
               pstmt.setInt(4, 2);
               pstmt.setDouble(5, 3.99);
               pstmt.executeUpdate();
                
               pstmt.setInt(1, 102);
               pstmt.setString(2, "Soda");
               pstmt.setString(3, "carbonated water");
               pstmt.setInt(4, 12);
               pstmt.setDouble(5, 6.49);
               pstmt.executeUpdate();
               
               System.out.println("Data inserted.");
            }
            
            final String SELECT_SQL = "SELECT * FROM testexample";
            // 3. Query the data
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(SELECT_SQL)) 
            {
                 
                System.out.println("--- Product Table Data ---");
                while (rs.next()) {
                    int id = rs.getInt("ID_field");
                    String productName = rs.getString("Product_Name");
                    String desc = rs.getString("Description");
                    int qty = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    System.out.println("Product ID: " + id + ", Name: " + productName + ", Description: " + desc + ", QTY " + qty + " Price: " + price);
                }
            }
            
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // STEP 3: Close connection
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}