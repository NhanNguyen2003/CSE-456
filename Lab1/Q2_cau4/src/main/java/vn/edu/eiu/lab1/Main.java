package vn.edu.eiu.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;

        // Thông tin kết nối MySQL
        String url = "jdbc:mysql://localhost:3306/lab1";
        String username = "root";
        String password = "123456";

        try {
            // Kết nối tới MySQL
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully");

            // Thực thi câu lệnh SELECT
            String sql = "SELECT * FROM Course";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // In kết quả ra console
            System.out.println("Code | Name | Credits | StudyHours");
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                int credits = rs.getInt("Credits");
                int studyHours = rs.getInt("StudyHours");
                System.out.println(code + " | " + name + " | " + credits + " | " + studyHours);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            try {
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
