<%-- 
    Document   : add-project
    Created on : Aug 7, 2024, 1:07:19 AM
    Author     : sheha
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    
    String p_name = request.getParameter("p_name");
    String project_des = request.getParameter("project_des");
    String start_date = request.getParameter("start_date");
    String deu_date = request.getParameter("deu_date");
    
    
    
    
    
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
        String sql = "INSERT INTO project(project_name,project_des,start_date,due_date,isStarted) VALUES(?, ?, ?, ?,?)";
       pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, p_name);
        pstmt.setString(2, project_des);
        pstmt.setString(3, start_date);
        pstmt.setString(4, deu_date);
        pstmt.setInt(5, 0);
        int a = pstmt.executeUpdate();
        if (a > 0) {
              response.sendRedirect("dashboard_admin.jsp");
        } else {
      }

    } catch (Exception e) {
        out.println(e);
    }
%>



<!--<a style="text-decoration: none;color: white;" href="mailto:admin@gmail.com" class="email-button"> Submit here</a>-->
