<%@page import="app.classes.MD5"%>
<%@page import="java.sql.SQLException"%>
<%@page import="app.classes.User"%>
<%@page import="app.classes.DbConnector"%>
<%@page import="java.sql.Connection"%>
<%
    String action = request.getParameter("action");
    String email = request.getParameter("email");
    Connection connection = null;

    try {
        connection = DbConnector.getConnection();
        User user = new User(); // Create User instance

        if ("updateProfile".equals(action)) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            // Update user profile details in the database
            boolean isUpdated = user.updateProfile(email, firstName, lastName);
            if (isUpdated) {
                session.setAttribute("successMessage", "Profile updated successfully.");
                response.sendRedirect("dashboard_user.jsp"); // Redirect to admin dashboard
            } else {
                out.println("Profile update failed.");
            }
        } else if ("updatePassword".equals(action)) {
            String currentPassword = request.getParameter("currentPassword");
            String newPassword = request.getParameter("newPassword");
            String newPasswordAgain = request.getParameter("newPasswordAgain");

            // Check current password and update if new passwords match
            String storedPasswordHash = user.getPasswordHash(email);

            if (storedPasswordHash != null && storedPasswordHash.equals(MD5.getMd5(currentPassword))) {
                if (newPassword.equals(newPasswordAgain)) {
                    boolean isPasswordUpdated = user.updatePassword(email, newPassword);
                    if (isPasswordUpdated) {
                        session.setAttribute("successMessage", "Password updated successfully.");
                        response.sendRedirect("dashboard_user.jsp"); // Redirect to admin dashboard
                    } else {
                        out.println("Password update failed.");
                    }
                } else {
                    out.println("New passwords do not match.");
                }
            } else {
                out.println("Current password is incorrect.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("An error occurred: " + e.getMessage());
    } finally {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>
