package wisdomClass;

import java.sql.*;

public class JdbcDemoOne {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeeDemoDB";
        String username = "root";
        String password = "PASSword1234!#";


        // the goal is to perform C.R.U.D -- Create, Read, Update, Delete
        try{
            // Register the Driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create statement
            Statement statement = connection.createStatement();

            // 1. CREATE
//            int insertData = statement.executeUpdate("INSERT INTO user VALUES (1, 'Arya', 'Stark', 'arya@gmail.com', '12345')");
//
//            System.out.println(insertData + " records inserted");

            // 2. READ
//            ResultSet result = statement.executeQuery("SELECT * FROM user");
//
//            while (result.next()){
//                System.out.println(result.getInt(1) +
//                        " " + result.getString(2) +
//                        " " + result.getString(3) +
//                        " " + result.getString(4) +
//                        " " + result.getString(5));
//            }

            // 3. UPDATE
//            int updateData = statement.executeUpdate("UPDATE user SET firstName='Joy', lastName='Omo' WHERE employeeId=1");
//            System.out.println(updateData + " record affected");


            // 4. DELETE
            int deleteData = statement.executeUpdate("DELETE FROM user WHERE employeeId=1");
            System.out.println(deleteData + " record deleted");



            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
