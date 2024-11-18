<%-- 
    Document   : startProject
    Created on : Aug 7, 2024, 11:31:00 AM
    Author     : sheha
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int p_id = Integer.parseInt(request.getParameter("projectID"));
    String user_name = (String) session.getAttribute("user_name");
    Integer userIdObject = (Integer) session.getAttribute("user_id");
    Integer user_id = (userIdObject != null) ? userIdObject : 0;

    String dbURL = "jdbc:mysql://localhost:3306/task_tracker";
    String dbUser = "task";
    String dbPassword = "task";

    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;

    try {
        // Connect to the database
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

        // Prepare the SQL query to retrieve all property details
        String sql = "INSERT INTO startproject(projectId,userId) VALUES(?, ?)";

        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, p_id);
        pstmt.setInt(2, user_id);
        int a = pstmt.executeUpdate();
        if (a > 0) {
            response.sendRedirect("dashboard_user.jsp?k=1");
        } else {
            response.sendRedirect("dashboard_user.jsp?k=0");
        }

        String sql2 = "UPDATE project SET isStarted=1 WHERE project_id=?";
        pstmt2 = conn.prepareStatement(sql2);
        pstmt2.setInt(1, p_id);
        int a2 = pstmt2.executeUpdate();
        

    } catch (Exception e) {
        out.println(e);
    }


%>
<!DOCTYPE html>
