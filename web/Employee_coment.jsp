<%-- 
    Document   : Employee_coment
    Created on : Aug 8, 2024, 5:29:44 PM
    Author     : sheha
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String comment = request.getParameter("comment");

    String user_name = (String) session.getAttribute("user_name");
    Integer userIdObject = (Integer) session.getAttribute("user_id");
    Integer user_id = (userIdObject != null) ? userIdObject : 0;
    out.println(user_id);
    out.println(user_name);
    
    
    
    String dbURL = "jdbc:mysql://localhost:3306/task_tracker";
    String dbUser = "task";
    String dbPassword = "task";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        // Connect to the database
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

        // Prepare the SQL query to retrieve all property details
        String sql = "INSERT INTO ecomment(userId,comment) VALUES(?, ?)";
        pstmt = conn.prepareStatement(sql);


        pstmt.setInt(1, user_id);
        pstmt.setString(2, comment);
        int a = pstmt.executeUpdate();
        if (a > 0) {
            response.sendRedirect("dashboard_user.jsp");
        } else {
            response.sendRedirect("dashboard_user.jsp");
        }

    } catch (Exception e) {
        out.println(e);
    }


%>