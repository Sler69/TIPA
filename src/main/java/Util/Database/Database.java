package Util.Database;

import java.sql.*;

public class Database {
    private static final String HOST_CONNECTION = "";

    // Create a variable for the connection string.
    String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
            "databaseName=AdventureWorks;user=UserName;password=*****";

    // Declare the JDBC objects.
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    public void exampleExecution (){
        try
        {
            // the sql server driver string
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");

            // the sql server url
            String url = "jdbc:microsoft:sqlserver://HOST:1433;DatabaseName=DATABASE";

            // get the sql server database connection
            con = DriverManager.getConnection(url,"THE_USER", "THE_PASSWORD");

            // now do whatever you want to do with the connection
            // ...

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.exit(2);
        }
    }
}
