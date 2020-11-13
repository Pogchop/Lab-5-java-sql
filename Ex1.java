package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex1 {
    public Ex1() {
    }

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");

            try {
                Statement stmt = conn.createStatement();

                try {
                    String sqldelete = "Delete from books where id >1008";
                    System.out.println("The SQL statement is " + sqldelete);
                    int countDelete = stmt.executeUpdate(sqldelete);
                    System.out.println(countDelete + " row(s) effected");
                    System.out.println("===============================================================");
                    String sqlInsert = "insert into books values(1010,'Java Core','Dang Kim Thi',15.5,55),(1011,'Java Advanced','James Gosling',25.5,55)";
                    System.out.println("The SQL statement is: " + sqlInsert);
                    int countInserted = stmt.executeUpdate(sqlInsert);
                    System.out.println(countInserted + " row(s) infected");
                    System.out.println("===============================================================");
                    sqlInsert = "insert into books(id,title,author) values(1012,'Java JDBC MySQL','ThiDK')";
                    System.out.println("The SQL statement is: " + sqlInsert);
                    countInserted = stmt.executeUpdate(sqlInsert);
                    System.out.println(countInserted + " row(s) infected");
                    System.out.println("===============================================================");
                    System.out.println("Enter bookID you want to delete: ");
                    Scanner input = new Scanner(System.in);
                    int id = input.nextInt();
                    sqldelete = "delete from books where id =" + id;
                    System.out.println("The SQL statement is " + sqldelete);
                    countDelete = stmt.executeUpdate(sqldelete);
                    System.out.println(countDelete + " row(s) effected");
                    System.out.println("===============================================================");
                    System.out.println("Enter information of the book you want to add:\nBookId: ");
                    id = input.nextInt();
                    System.out.println("Title: ");
                    input.nextLine();
                    String title = input.nextLine();
                    System.out.println("Author: ");
                    String author = input.nextLine();
                    System.out.println("Price: ");
                    double price = input.nextDouble();
                    System.out.println("Qty: ");
                    int qty = input.nextInt();
                    sqlInsert = "Insert into books values(" + id + ",'" + title + "','" + author + "'," + price + "," + qty + ")";
                    System.out.println("The SQL statemnet is " + sqlInsert);
                    countInserted = stmt.executeUpdate(sqlInsert);
                    System.out.println(countInserted + " row(s) effected");
                } catch (Throwable var16) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var15) {
                            var16.addSuppressed(var15);
                        }
                    }

                    throw var16;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var17) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var14) {
                        var17.addSuppressed(var14);
                    }
                }

                throw var17;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var18) {
            var18.printStackTrace();
        }

    }
}